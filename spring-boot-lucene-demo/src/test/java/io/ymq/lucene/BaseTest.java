package io.ymq.lucene;

import com.chenlb.mmseg4j.analysis.ComplexAnalyzer;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;

import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Paths;

/**
 * 描述:
 *
 * @author yanpenglei
 * @create 2017-11-07 17:59
 **/
public class BaseTest {


    private Directory directory;

    private IndexReader indexReader;

    private IndexSearcher indexSearcher;


    @Before
    public void setUp() throws IOException {
        //索引存放的位置，设置在当前目录中
        directory = FSDirectory.open(Paths.get("indexDir/"));

        //创建索引的读取器
        indexReader = DirectoryReader.open(directory);

        //创建一个索引的查找器，来检索索引库
        indexSearcher = new IndexSearcher(indexReader);
    }

    @After
    public void tearDown() throws Exception {
        indexReader.close();
    }


    /**
     * 写索引
     *
     * @throws IOException
     */
    @Test
    public void indexWriterTest() throws IOException {
        long start = System.currentTimeMillis();

        //索引存放的位置，设置在当前目录中
        Directory directory = FSDirectory.open(Paths.get("indexDir/"));

        //在 6.6 以上版本中 version 不再是必要的，并且，存在无参构造方法，可以直接使用默认的 StandardAnalyzer 分词器。
        Version version = Version.LUCENE_7_1_0;

        //创建lucene的分词器，主要用于进行分词，比如识别,我是中国人，甚至一些以前没有，但现在出先的词
        //Analyzer analyzer = new StandardAnalyzer(); // 标准分词器，适用于英文
        Analyzer analyzer = new SmartChineseAnalyzer();//中文分词

        //创建索引写入配置
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);

        //创建索引写入对象
        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);

        //创建Document对象，存储索引

        Document doc = new Document();

        int id = 1;

        //将字段加入到doc中
        doc.add(new IntPoint("id", id));
        doc.add(new StringField("title", "我是鹏磊", Field.Store.YES));
        doc.add(new TextField("content", "i am peng lei, 世界上没有优秀的理念，只有脚踏实地的结果", Field.Store.YES));
        doc.add(new StoredField("id", id));

        //将doc对象保存到索引库中
        indexWriter.addDocument(doc);

        //关闭流
        indexWriter.close();

        long end = System.currentTimeMillis();
        System.out.println("索引花费了" + (end - start) + " 毫秒");
    }

    /**
     * 测试更新
     * 实际上就是删除后新增一条
     *
     * @throws IOException
     */
    @Test
    public void testUpdate() throws IOException {

        //创建lucene的分词器，主要用于进行分词，比如识别,我是中国人，甚至一些以前没有，但现在出先的词
        //Analyzer analyzer = new StandardAnalyzer(); // 标准分词器，适用于英文
        Analyzer analyzer = new SmartChineseAnalyzer();//中文分词

        //创建索引写入配置
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);

        //创建索引写入对象
        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);

        Document doc = new Document();

        int id = 1;

        doc.add(new IntPoint("id", id));
        doc.add(new StringField("title", "我是鹏磊啊", Field.Store.YES));
        doc.add(new TextField("content", "i am peng lei, 世界上没有优秀的理念，只有脚踏实地的结果", Field.Store.YES));
        doc.add(new StoredField("id", id));

        long count = indexWriter.updateDocument(new Term("id", "1"), doc);
        System.out.println(count);
        indexWriter.close();
    }


    /**
     * 对特定项搜索
     * 按词条搜索—TermQuery
     * TermQuery是最简单、也是最常用的Query。TermQuery可以理解成为“词条搜索”，
     * 在搜索引擎中最基本的搜索就是在索引中搜索某一词条，而TermQuery就是用来完成这项工作的。
     * 在Lucene中词条是最基本的搜索单位，从本质上来讲一个词条其实就是一个名/值对。
     * 只不过这个“名”是字段名，而“值”则表示字段中所包含的某个关键字。
     *
     * @throws IOException
     */
    @Test
    public void termQueryTest() throws IOException {

        String searchField = "title";
        //这是一个条件查询的api，用于添加条件
        TermQuery query = new TermQuery(new Term(searchField, "我是鹏磊啊"));

        //返回符合条件的前100条记录
        TopDocs topDocs = indexSearcher.search(query, 100);

        printScoreDoc(topDocs, indexSearcher);
    }


    /**
     * “多条件查询”搜索—BooleanQuery
     * BooleanQuery也是实际开发过程中经常使用的一种Query。
     * 它其实是一个组合的Query，在使用时可以把各种Query对象添加进去并标明它们之间的逻辑关系。
     * 在本节中所讨论的所有查询类型都可以使用BooleanQuery综合起来。
     * BooleanQuery本身来讲是一个布尔子句的容器，它提供了专门的API方法往其中添加子句，
     * 并标明它们之间的关系，以下代码为BooleanQuery提供的用于添加子句的API接口：
     *
     * @throws IOException
     */
    @Test
    public void BooleanQueryTest() throws IOException {

        //上面添加过的内容：  i am peng lei, 世界上没有优秀的理念，只有脚踏实地的结果
        String searchField1 = "title";
        String searchField2 = "content";
        Query query1 = new TermQuery(new Term(searchField1, "我是鹏磊啊"));
        Query query2 = new TermQuery(new Term(searchField2, "peng"));
        BooleanQuery.Builder builder = new BooleanQuery.Builder();

        // BooleanClause用于表示布尔查询子句关系的类，包 括：BooleanClause.Occur.MUST，BooleanClause.Occur.MUST_NOT，BooleanClause.Occur.SHOULD。 必须包含,不能包含,可以包含三种.有以下6种组合：
        //
        // 1．MUST和MUST：取得连个查询子句的交集。
        // 2．MUST和MUST_NOT：表示查询结果中不能包含MUST_NOT所对应得查询子句的检索结果。
        // 3．SHOULD与MUST_NOT：连用时，功能同MUST和MUST_NOT。
        // 4．SHOULD与MUST连用时，结果为MUST子句的检索结果,但是SHOULD可影响排序。
        // 5．SHOULD与SHOULD：表示“或”关系，最终检索结果为所有检索子句的并集。
        // 6．MUST_NOT和MUST_NOT：无意义，检索无结果。


        builder.add(query1, BooleanClause.Occur.MUST);
        builder.add(query2, BooleanClause.Occur.MUST);
        BooleanQuery booleanQuery = builder.build();

        //返回符合条件的前100条记录
        TopDocs topDocs = indexSearcher.search(booleanQuery, 100);

        printScoreDoc(topDocs, indexSearcher);
    }


    /**
     * PrefixQuery用于匹配其索引开始以指定的字符串的文档。就是文档中存在xxx%
     * <p>
     * 对中文 支持不太好，只支持一个汉字， 最好是英文开头
     *
     * @throws IOException
     */
    @Test
    public void prefixQueryTest() throws IOException {

        String searchField = "content";

        //上面添加过的内容：  i am peng lei, 世界上没有优秀的理念，只有脚踏实地的结果
        Term term = new Term(searchField, "peng");
        Query query = new PrefixQuery(term);

        TopDocs topDocs = indexSearcher.search(query, 100);

        printScoreDoc(topDocs, indexSearcher);
    }


    /**
     * 所谓PhraseQuery，就是通过短语来检索，比如我想查“big car”这个短语，
     * 那么如果待匹配的document的指定项里包含了"big car"这个短语，
     * 这个document就算匹配成功。可如果待匹配的句子里包含的是“big black car”，
     * 那么就无法匹配成功了，如果也想让这个匹配，就需要设定slop，
     * 先给出slop的概念：slop是指两个项的位置之间允许的最大间隔距离
     *
     * @throws IOException
     */
    @Test
    public void phraseQueryTest() throws IOException {

        //上面添加过的内容：  i am peng lei, 世界上没有优秀的理念，只有脚踏实地的结果
        String searchField = "content";
        String query1 = "peng";
        String query2 = "lei";
        Term t1 = new Term(searchField, query1);
        Term t2 = new Term(searchField, query2);

        PhraseQuery.Builder builder = new PhraseQuery.Builder();
        builder.add(t1);
        builder.add(t2);
        builder.setSlop(0);
        PhraseQuery query = builder.build();

        TopDocs topDocs = indexSearcher.search(query, 100);

        printScoreDoc(topDocs, indexSearcher);
    }

    /**
     * 相近词语的搜索—FuzzyQuery
     * FuzzyQuery是一种模糊查询，它可以简单地识别两个相近的词语。
     *
     * @throws IOException
     */
    @Test
    public void fuzzyQueryTest() throws IOException {

        String searchField = "content";
        //上面添加过的内容：  i am peng lei, 世界上没有优秀的理念，只有脚踏实地的结果
        Term t = new Term(searchField, "优秀");
        Query query = new FuzzyQuery(t);

        TopDocs topDocs = indexSearcher.search(query, 100);

        //打印查询到的记录数
        printScoreDoc(topDocs, indexSearcher);
    }


    /**
     * 使用通配符搜索—WildcardQuery
     * Lucene也提供了通配符的查询，这就是WildcardQuery。
     * 通配符“?”代表1个字符，而“*”则代表0至多个字符。
     *
     * @throws IOException
     */
    @Test
    public void wildcardQueryTest() throws IOException {

        //上面添加过的内容：  i am peng lei, 世界上没有优秀的理念，只有脚踏实地的结果
        String searchField = "content";
        Term term = new Term(searchField, "p*g");
        Query query = new WildcardQuery(term);

        TopDocs topDocs = indexSearcher.search(query, 100);

        //打印查询到的记录数
        printScoreDoc(topDocs, indexSearcher);
    }


    /**
     * 解析查询表达式
     * QueryParser实际上就是一个解析用户输入的工具，可以通过扫描用户输入的字符串，生成Query对象，以下是一个代码示例：
     *
     * @throws ParseException
     */
    @Test
    public void queryParserTest() throws IOException, ParseException {

        //创建lucene的分词器，主要用于进行分词，比如识别,我是中国人，甚至一些以前没有，但现在出先的词
        //Analyzer analyzer = new StandardAnalyzer(); // 标准分词器，适用于英文
        Analyzer analyzer = new SmartChineseAnalyzer();//中文分词

        //上面添加过的内容：  i am peng lei, 世界上没有优秀的理念，只有脚踏实地的结果

        String searchField = "content";
        String text = "世界上";

        //指定搜索字段和分析器
        QueryParser parser = new QueryParser(searchField, analyzer);

        //用户输入内容
        Query query = parser.parse(text);

        TopDocs topDocs = indexSearcher.search(query, 100);

        //打印查询到的记录数
        printScoreDoc(topDocs, indexSearcher);
    }

    /**
     * 在不同的Field上进行查询
     *
     * @throws IOException
     * @throws ParseException
     */
    @Test
    public void multiFieldQueryParserTest() throws IOException, ParseException {

        //创建lucene的分词器，主要用于进行分词，比如识别,我是中国人，甚至一些以前没有，但现在出先的词
        //Analyzer analyzer = new StandardAnalyzer(); // 标准分词器，适用于英文
        Analyzer analyzer = new SmartChineseAnalyzer();//中文分词

        //上面添加过的内容：  i am peng lei, 世界上没有优秀的理念，只有脚踏实地的结果

        String[] filedStr = new String[]{"title", "content"};

        //指定搜索字段和分析器
        QueryParser queryParser = new MultiFieldQueryParser(filedStr, analyzer);

        //用户输入内容
        Query query = queryParser.parse("没有");

        TopDocs topDocs = indexSearcher.search(query, 100);

        //打印查询到的记录数
        printScoreDoc(topDocs, indexSearcher);

    }

    /**
     * smartcn  中文分词器 SmartChineseAnalyzer  smartcn分词器 需要lucene依赖 且和lucene版本同步
     *
     * @throws IOException
     */
    @Test
    public void smartcnTest() throws IOException {
        //创建lucene的分词器，主要用于进行分词，比如识别,我是中国人，甚至一些以前没有，但现在出先的词
        //Analyzer analyzer = new StandardAnalyzer(); // 标准分词器，适用于英文
        Analyzer analyzer = new SmartChineseAnalyzer();//中文分词
        String text = "i am peng lei, 世界上没有优秀的理念，只有脚踏实地的结果";
        printAnalyzerDoc(analyzer, text);
    }


    /**
     * IKAnalyzer  中文分词器
     *
     * @throws IOException
     */
    @Test
    public void IKAnalyzerTest() throws IOException {
        //创建lucene的分词器，主要用于进行分词，比如识别,我是中国人，甚至一些以前没有，但现在出先的词
        //Analyzer analyzer = new StandardAnalyzer(); // 标准分词器，适用于英文
        Analyzer analyzer = new IKAnalyzer();//中文分词
        String text = "i am peng lei, 世界上没有优秀的理念，只有脚踏实地的结果";
        printAnalyzerDoc(analyzer, text);
    }


    /**
     * MMSeg4j  中文分词器
     *
     * @throws IOException
     */
    @Test
    public void MMSegAnalyzerTest() throws IOException {
        //创建lucene的分词器，主要用于进行分词，比如识别,我是中国人，甚至一些以前没有，但现在出先的词
        //Analyzer analyzer = new StandardAnalyzer(); // 标准分词器，适用于英文
        Analyzer analyzer = new ComplexAnalyzer();//中文分词
        String text = "i am peng lei, 世界上没有优秀的理念，只有脚踏实地的结果";
        printAnalyzerDoc(analyzer, text);
    }

    public void printAnalyzerDoc(Analyzer analyzer, String text) throws IOException {

        TokenStream tokenStream = analyzer.tokenStream("content", new StringReader(text));
        CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
        try {
            tokenStream.reset();
            while (tokenStream.incrementToken()) {
                System.out.println(charTermAttribute.toString());
            }
            tokenStream.end();
        } finally {
            tokenStream.close();
            analyzer.close();
        }
    }

    public void printScoreDoc(TopDocs topDocs, IndexSearcher indexSearcher) throws IOException {
        //打印查询到的记录数
        System.out.println("总共查询到" + topDocs.totalHits + "个文档");
        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {

            //取得对应的文档对象
            Document document = indexSearcher.doc(scoreDoc.doc);
            System.out.println("id：" + document.get("id"));
            System.out.println("title：" + document.get("title"));
            System.out.println("content：" + document.get("content"));
        }
    }


}
