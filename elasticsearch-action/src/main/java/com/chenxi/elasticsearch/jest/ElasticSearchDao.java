package com.chenxi.elasticsearch.jest;

import com.google.gson.JsonObject;
import io.searchbox.client.JestResult;
import io.searchbox.core.SearchResult;
import io.searchbox.core.SuggestResult;

import java.util.List;

/**
 * ES操作 抽象方法 基本包含所有基本操作
 *
 * @author zhaochenxi1
 */
public interface ElasticSearchDao {
    /*
     * ***************集群操作 start********************************
     */

    /**
     * 查看集群健康信息
     *
     * @return
     */
    public JestResult health();

    /**
     * 查看节点信息
     *
     * @return
     */
    public JestResult nodesInfo();

    /**
     * 节点状态
     *
     * @return
     */
    public JestResult nodesStats();

    /**
     * 清除缓存
     *
     * @return
     */
    public JestResult clearCache();
    /*
     * *****************集群操作 end********************************
     */

    /**
     * 创建索引
     *
     * @param indexName
     * @return
     * @throws Exception
     */
    public boolean createIndex(String indexName);

    /**
     * Put映射
     *
     * @param indexName
     * @param typeName
     * @param source
     * @return
     */
    public boolean createIndexMapping(String indexName, String typeName, String source);

    /**
     * Get映射
     *
     * @param indexName
     * @param typeName
     * @return
     */
    public String getIndexMapping(String indexName, String typeName);


    /**
     * 索引文档
     *
     * @param indexName
     * @param typeName
     * @param obj
     * @return
     */
    public boolean indexDocument(String indexName, String typeName, BaseEsDocument obj);

    /**
     * 批量索引文档
     *
     * @param indexName
     * @param typeName
     * @param objs
     * @return
     */
    public boolean bulkIndexDocument(String indexName, String typeName, List<BaseEsDocument> objs);

    /**
     * 更新Document
     *
     * @param index ：文档在哪存放
     * @param type  ： 文档表示的对象类别
     * @param id    ：文档唯一标识
     */
    public JestResult updateDocument(String script, String index, String type, String id);

    /**
     * 删除Document
     *
     * @param index ：文档在哪存放
     * @param type  ： 文档表示的对象类别
     * @param id    ：文档唯一标识
     * @return
     */
    public JestResult deleteDocument(String index, String type, String id);

    /**
     * 获取Document
     *
     * @param o     ：返回对象
     * @param index ：文档在哪存放
     * @param type  ： 文档表示的对象类别
     * @param id    ：文档唯一标识
     * @return
     */
    public <T> JestResult getDocument(T o, String index, String type, String id);


    /**
     * 搜索
     *
     * @param keyWord ：搜索关键字
     * @return
     */
    public <T> List<SearchResult.Hit<T, Void>> createSearch(String keyWord, String type, T o, String... fields);

    /**
     * 搜索事件流图表数据
     *
     * @param param
     * @return
     */
    public JsonObject searchEvent(String param);


    /**
     * Suggestion
     */

    public List<SuggestResult.Suggestion> suggest();


}
