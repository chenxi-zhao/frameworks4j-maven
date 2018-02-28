package com.chenxi.elasticsearch.jest;

import com.google.gson.JsonObject;
import io.searchbox.client.JestResult;
import io.searchbox.client.http.JestHttpClient;
import io.searchbox.cluster.Health;
import io.searchbox.cluster.NodesInfo;
import io.searchbox.cluster.NodesStats;
import io.searchbox.core.*;
import io.searchbox.indices.ClearCache;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.mapping.GetMapping;
import io.searchbox.indices.mapping.PutMapping;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

public class ElasticSearchDaoJestImpl implements ElasticSearchDao {
    @Resource
    private JestHttpClient jestHttpClient;

    public void setJestHttpClient(JestHttpClient jestHttpClient) {
        this.jestHttpClient = BaseJestClient.getJestClient();
    }

    /**
     * 查看集群健康信息
     *
     * @return
     */
    @Override
    public JestResult health() {
        Health health = new Health.Builder().build();
        JestResult result = null;
        try {
            result = jestHttpClient.execute(health);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 查看节点信息
     *
     * @return
     */
    @Override
    public JestResult nodesInfo() {
        NodesInfo nodesInfo = new NodesInfo.Builder().build();
        JestResult result = null;
        try {
            result = jestHttpClient.execute(nodesInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 节点状态
     *
     * @return
     */
    @Override
    public JestResult nodesStats() {
        NodesStats nodesStats = new NodesStats.Builder().build();
        JestResult result = null;
        try {
            result = jestHttpClient.execute(nodesStats);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 清除缓存
     *
     * @return
     */
    @Override
    public JestResult clearCache() {
        ClearCache closeIndex = new ClearCache.Builder().build();
        JestResult result = null;
        try {
            result = jestHttpClient.execute(closeIndex);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 创建索引
     *
     * @param indexName
     * @return
     */
    @Override
    public boolean createIndex(String indexName) {
        JestResult result = null;
        try {
            result = jestHttpClient.execute(new CreateIndex.Builder(indexName).build());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result != null && result.isSucceeded();
    }

    /**
     * Put映射
     *
     * @param indexName
     * @param typeName
     * @param source
     * @return
     */
    @Override
    public boolean createIndexMapping(String indexName, String typeName, String source) {
        PutMapping putMapping = new PutMapping.Builder(indexName, typeName, source).build();
        JestResult result = null;
        try {
            result = jestHttpClient.execute(putMapping);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result != null && result.isSucceeded();
    }

    /**
     * Get映射
     *
     * @param indexName
     * @param typeName
     * @return
     */
    public String getIndexMapping(String indexName, String typeName) {
        GetMapping getMapping = new GetMapping.Builder().addIndex(indexName).addType(typeName).build();
        JestResult result = null;
        try {
            result = jestHttpClient.execute(getMapping);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result != null ? result.getJsonString() : null;
    }

    /**
     * 索引文档
     *
     * @param indexName
     * @param typeName
     * @param obj
     * @return
     */
    @Override
    public boolean indexDocument(String indexName, String typeName, BaseEsDocument obj) {
        Index index = new Index.Builder(obj).index(indexName).type(typeName).id(obj.getId()).build();

        return false;
    }

    /**
     * 批量索引文档
     *
     * @param indexName
     * @param typeName
     * @param objs
     * @return
     */
    @Override
    public boolean bulkIndexDocument(String indexName, String typeName, List<BaseEsDocument> objs) {
        Bulk.Builder bulk = new Bulk.Builder().defaultIndex(indexName).defaultType(typeName);
        for (BaseEsDocument obj : objs) {
            Index index = new Index.Builder(obj).id(obj.getId()).build();
            bulk.addAction(index);
        }
        BulkResult result = null;
        try {
            result = jestHttpClient.execute(bulk.build());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result != null && result.isSucceeded();
    }


    @Override
    public JestResult updateDocument(String script, String index, String type, String id) {
        JestResult result = null;
        Update update = new Update.Builder(script).index(index).type(type).id(id).build();
        try {
            result = this.jestHttpClient.execute(update);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public JestResult deleteDocument(String index, String type, String id) {
        JestResult result = null;
        Delete delete = new Delete.Builder(id).index(index).type(type).build();
        try {
            result = this.jestHttpClient.execute(delete);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public <T> JestResult getDocument(T o, String index, String type, String id) {
        Get get = new Get.Builder("twitter", "1").type("tweet").build();

        JestResult result = null;
        try {
            result = this.jestHttpClient.execute(get);

            o = (T) result.getSourceAsObject(o.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public <T> List<SearchResult.Hit<T, Void>> createSearch(String keyWord, String type, T o, String... fields) {
        return null;
    }

    @Override
    public JsonObject searchEvent(String param) {
        return null;
    }

    @Override
    public List<SuggestResult.Suggestion> suggest() {
        return null;
    }
}
