package io.ymq.example.elasticsearch;


import com.alibaba.fastjson.JSONObject;
import io.ymq.example.elasticsearch.run.Startup;
import org.elasticsearch.action.ActionFuture;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexResponse;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;

import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Startup.class)
public class BaseTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTests.class);

    @Autowired
    private TransportClient transportClient;

    /**
     * ES的基本类型可以去官网查看
     * 如果您使用map的方式去写入数据并且创建索引，es会自动根据map的value数据类型来自动转换
     * 比如age是int，es里面使用有integer，不赘述
     * 使用map有个大缺陷(除非自己封装对象保存),当你保存java.util.Date类型进去的时候ES会全部转成UTC来保存
     * 这个只能通过后面的api方式定义索引field的一些属性来指定才行
     **/
    @Test
    public void createData() {

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("name", "鹏磊");
        map.put("age", 24);
        map.put("interests", new String[]{"阅读", "学习"});
        map.put("about", "我是鹏磊，认识自己的无知是认识世界的最可靠的方法。");

        IndexResponse response = transportClient.prepareIndex("about_index", "about", UUID.randomUUID().toString().replaceAll("-", "").toUpperCase()).setSource(map).get();

        System.out.println("写入数据结果=" + response.status().getStatus() + "，id=" + response.getId());

    }


    @Test
    public void deleteData() {

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("name", "鹏磊");
        map.put("age", 24);
        map.put("interests", new String[]{"阅读", "学习"});
        map.put("about", "我是即将要删除的数据");

        IndexResponse indexResponse = transportClient.prepareIndex("about_index", "about", UUID.randomUUID().toString()).setSource(map).get();

        System.out.println("写入数据结果=" + indexResponse.status().getStatus() + "！id=" + indexResponse.getId());

        DeleteResponse deleteResponse = transportClient.prepareDelete("about_index", "about", indexResponse.getId().toString()).execute().actionGet();

        System.out.println("删除数据结果=" + deleteResponse.status().getStatus() + "，id=" + deleteResponse.getId());
    }


    @Test
    public void updateData() {

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("name", "鹏磊");
        map.put("age", 24);
        map.put("interests", new String[]{"阅读", "学习"});
        map.put("about", "我是更新后的数据!");

        UpdateRequest updateRequest = new UpdateRequest();

        updateRequest.index("about_index").type("about").id("72c7aaac-bdaf-418c-b1bd-185558d2b231").doc(map);

        transportClient.update(updateRequest);

    }

    /**
     * 删除整个索引
     */
    @Test
    public void deleteIndex() {

        DeleteIndexResponse deleteIndexResponse = transportClient.admin().indices().delete(new DeleteIndexRequest("book_index")).actionGet();

        System.out.println("删除数据结果=" + JSONObject.toJSONString(deleteIndexResponse));
    }

    /**
     * match 使用，会被分词查询
     */
    @Test
    public void match() {
        SearchRequestBuilder requestBuilder = transportClient.prepareSearch("about_index").setTypes("about")
                .setQuery(QueryBuilders.matchQuery("about", "鹏磊"));
        System.out.println(requestBuilder.toString());

        SearchResponse response = requestBuilder.execute().actionGet();

        long totalHits = response.getHits().totalHits;
        long length = response.getHits().getHits().length;
        LOGGER.debug("共查询到[{}]条数据,处理数据条数[{}]", totalHits, length);

        System.out.println(response.status());
        if (response.status().getStatus() == 200) {
            for (SearchHit hits : response.getHits().getHits()) {
                System.out.println(hits.getSourceAsString());
            }
        }
    }


    /**
     * matchphrase使用，短语精准匹配
     * 不使用matchPhraseQuery会导致 rock climbing被拆分查询
     */
    @Test
    public void matchPhrase() {
        SearchRequestBuilder requestBuilder = transportClient.prepareSearch("about_index").setTypes("about")
                .setQuery(QueryBuilders.matchPhraseQuery("about", "鹏磊"));
        System.out.println(requestBuilder.toString());

        SearchResponse response = requestBuilder.execute().actionGet();

        long totalHits = response.getHits().totalHits;
        long length = response.getHits().getHits().length;
        LOGGER.debug("共查询到[{}]条数据,处理数据条数[{}]", totalHits, length);

        System.out.println(response.status());
        if (response.status().getStatus() == 200) {
            for (SearchHit hits : response.getHits().getHits()) {
                System.out.println(hits.getSourceAsString());
            }
        }
    }

    /**
     * 高亮显示
     */
    @Test
    public void highlight() {
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        // highlightBuilder.preTags(FragmentSettings.prefix);//设置前缀
        // highlightBuilder.postTags(FragmentSettings.subfix);//设置后缀
        highlightBuilder.field("about");
        // highlightBuilder.fragmenter(FragmentSettings.SPAN)
        // .fragmentSize(FragmentSettings.HIGHLIGHT_MAX_WORDS).numOfFragments(5);
        SearchRequestBuilder requestBuilder = transportClient.prepareSearch("about_index").setTypes("about")
                .setQuery(QueryBuilders.matchPhraseQuery("about", "鹏磊")).highlighter(highlightBuilder);
        System.out.println(requestBuilder.toString());

        SearchResponse response = requestBuilder.execute().actionGet();

        long totalHits = response.getHits().totalHits;
        long length = response.getHits().getHits().length;
        LOGGER.debug("共查询到[{}]条数据,处理数据条数[{}]", totalHits, length);

        System.out.println(response.status());
        if (response.status().getStatus() == 200) {
            for (SearchHit hits : response.getHits().getHits()) {
                System.out.println(hits.getSourceAsString());
                // 这里使用hight field来覆盖source里面的字段即可
                System.out.println(hits.getHighlightFields());
            }
        }

    }


}
