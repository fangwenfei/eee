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


    @Test
    public void createData() {

        for (int i = 0; i < 100; i++) {
            Map<String, Object> map = new HashMap<String, Object>();

            map.put("name", "鹏磊" + i);
            map.put("age", i);
            map.put("interests", new String[]{"阅读", "学习"});
            map.put("about", "我是鹏磊，认识自己的无知是认识世界的最可靠的方法。");
            map.put("processTime", new Date());

            ElasticsearchUtils.addData(JSONObject.parseObject(JSONObject.toJSONString(map)), "about_test", "about_test", "uuid" + i);
        }

    }


    @Test
    public void searchListData() {

        List<Map<String, Object>> list = ElasticsearchUtils.searchListData("about_test", "about_test", 0, "", "", true, "", "name=鹏磊1");

        for (Map<String, Object> item : list) {

            System.out.println(JSONObject.toJSONString(item));
        }

    }

    @Test
    public void searchDataPage() {

        EsPage esPage = ElasticsearchUtils.searchDataPage("about_test", "about_test", 10, 5, 1509943495299l, 1509943497954l, "", "processTime", false, "about", "about=鹏磊");

        for (Map<String, Object> item : esPage.getRecordList()) {

            System.out.println(JSONObject.toJSONString(item));
        }

    }

}

























