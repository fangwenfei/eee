package io.ymq.example.elasticsearch;


import com.alibaba.fastjson.JSONObject;
import io.ymq.example.elasticsearch.run.Startup;
import io.ymq.example.elasticsearch.utils.ElasticsearchUtils;

import io.ymq.example.elasticsearch.utils.EsPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Startup.class)
public class ElasticsearchUtilsTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ElasticsearchUtilsTest.class);

    /**
     * 创建索引
     */
    @Test
    public void createIndexTest() {
        ElasticsearchUtils.createIndex("ymq_index");
        ElasticsearchUtils.createIndex("ymq_indexsssss");
    }

    /**
     * 删除索引
     */
    @Test
    public void deleteIndexTest() {
        ElasticsearchUtils.deleteIndex("ymq_indexsssss");
    }

    /**
     * 判断索引是否存在
     */
    @Test
    public void isIndexExistTest() {
        ElasticsearchUtils.isIndexExist("ymq_index");
    }

    /**
     * 数据添加
     */
    @Test
    public void addDataTest() {

        for (int i = 0; i < 100; i++) {
            Map<String, Object> map = new HashMap<String, Object>();

            map.put("name", "鹏磊" + i);
            map.put("age", i);
            map.put("interests", new String[]{"阅读", "学习"});
            map.put("about", "世界上没有优秀的理念，只有脚踏实地的结果");
            map.put("processTime", new Date());

            ElasticsearchUtils.addData(JSONObject.parseObject(JSONObject.toJSONString(map)), "ymq_index", "about_test", "id=" + i);
        }
    }

    /**
     * 通过ID删除数据
     */
    @Test
    public void deleteDataByIdTest() {

        for (int i = 0; i < 10; i++) {
            ElasticsearchUtils.deleteDataById("ymq_index", "about_test", "id=" + i);
        }
    }


    /**
     * 通过ID 更新数据
     * <p>
     * jsonObject 要增加的数据
     * index      索引，类似数据库
     * type       类型，类似表
     * id         数据ID
     */
    @Test
    public void updateDataByIdTest() {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put("name", "鹏磊");
        map.put("age", 11);
        map.put("interests", new String[]{"阅读", "学习"});
        map.put("about", "这条数据被修改");
        map.put("processTime", new Date());

        ElasticsearchUtils.updateDataById(JSONObject.parseObject(JSONObject.toJSONString(map)), "ymq_index", "about_test", "id=11");
    }

    /**
     * 通过ID获取数据
     * <p>
     * index  索引，类似数据库
     * type   类型，类似表
     * id     数据ID
     * fields 需要显示的字段，逗号分隔（缺省为全部字段）
     */
    @Test
    public void searchDataByIdTest() {
        Map<String, Object> map = ElasticsearchUtils.searchDataById("ymq_index", "about_test", "id=11", null);
        System.out.println(JSONObject.toJSONString(map));
    }


    /**
     * 使用分词查询
     * <p>
     * index          索引名称
     * type           类型名称,可传入多个type逗号分隔
     * startTime      开始时间
     * endTime        结束时间
     * size           文档大小限制
     * fields         需要显示的字段，逗号分隔（缺省为全部字段）
     * sortField      排序字段
     * matchPhrase    true 使用，短语精准匹配
     * highlightField 高亮字段
     * matchStr       过滤条件（xxx=111,aaa=222）
     */
    @Test
    public void searchListData() {

        List<Map<String, Object>> list = ElasticsearchUtils.searchListData("ymq_index", "about_test", 1509959382607l, 1509959383865l, 0, "", "", false, "", "name=鹏磊");

        for (Map<String, Object> item : list) {

            System.out.println(JSONObject.toJSONString(item));
        }
    }

    /**
     * 使用分词查询,并分页
     * <p>
     * index          索引名称
     * type           类型名称,可传入多个type逗号分隔
     * currentPage    起始条数
     * pageSize       每页显示条数
     * startTime      开始时间
     * endTime        结束时间
     * fields         需要显示的字段，逗号分隔（缺省为全部字段）
     * sortField      排序字段
     * matchPhrase    true 使用，短语精准匹配
     * highlightField 高亮字段
     * matchStr       过滤条件（xxx=111,aaa=222）
     */
    @Test
    public void searchDataPage() {

        EsPage esPage = ElasticsearchUtils.searchDataPage("ymq_index", "about_test", 10, 5, 1509943495299l, 1509943497954l, "", "processTime", false, "about", "about=鹏磊");

        for (Map<String, Object> item : esPage.getRecordList()) {

            System.out.println(JSONObject.toJSONString(item));
        }

    }

}

























