package io.ymq.example.mongodb;

/**
 * 描述: Demo DAO
 *
 * @author yanpenglei
 * @create 2018-02-03 16:56
 **/
public interface DemoDao {

    void saveDemo(DemoEntity demoEntity);

    void removeDemo(Long id);

    void updateDemo(DemoEntity demoEntity);

    DemoEntity findDemoById(Long id);

}
