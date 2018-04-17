package com.chenxi.elasticsearch.rest.client;

import com.chenxi.elasticsearch.rest.BaseEsPO;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.*;
import io.searchbox.params.Parameters;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhaochenxi1 in 2018/1/23
 */
public class ElasticSearchJestUtil {
    private final static Log log = LogFactory.getLog(ElasticSearchJestUtil.class);

    /**
     * 指定路由属性
      */
    private final String ROUTING_KEY = Parameters.ROUTING;

    /**
     * 指定是否版本属性
     */
    private final String VERSION_KEY = Parameters.VERSION;

    private JestClientInstance jestClientInstance;

    public void setJestClientInstance(JestClientInstance jestClientInstance) {
        this.jestClientInstance = jestClientInstance;
    }

    /**
     * 索引文档
     *
     * @param objs
     * @return
     * @throws Exception
     */
    public boolean batchIndexDocument(String indexName, String typeName, List<? extends BaseEsPO> objs) throws Exception {
        JestClient jestClient = null;
        try {
            Bulk.Builder bulk = new Bulk.Builder().defaultIndex(indexName).defaultType(typeName);
            bulk.refresh(true);
            for (BaseEsPO obj : objs) {
                bulk.addAction(generateDocumentIndex(indexName, typeName, obj));
            }
            // 获取客户端
            jestClient = jestClientInstance.getJestClient();

            BulkResult br = jestClient.execute(bulk.build());

            return br.isSucceeded();
        } catch (Exception e) {
            jestClientInstance.closeJestClient(jestClient);
            throw e;
        }
    }

    /**
     * 生成Index索引类
     *
     * @param indexName
     * @param typeName
     * @param obj
     * @return
     */
    private Index generateDocumentIndex(String indexName, String typeName, BaseEsPO obj) {
        Index.Builder builder = new Index.Builder(obj).index(indexName).type(typeName);
        if (obj.getEsRouteId() != null) {
            builder.setParameter(ROUTING_KEY, obj.getEsRouteId());
        }
        if (obj.getVersion() != null) {
            builder.setParameter(VERSION_KEY, obj.getVersion());
        }

        return builder.build();
    }

    public boolean indexDocument(String indexName, String typeName, BaseEsPO obj) throws Exception {
        JestClient jestClient = null;
        try {
            // 获取客户端
            jestClient = jestClientInstance.getJestClient();

            JestResult jr = jestClient.execute(generateDocumentIndex(indexName, typeName, obj));

            return jr.isSucceeded();
        } catch (Exception e) {
            e.printStackTrace();
            jestClientInstance.closeJestClient(jestClient);
            throw e;
        }
    }

    /**
     * Delete文档
     *
     * @param id
     * @return
     * @throws Exception
     */
    public boolean deleteDocument(String indexName, String typeName, String id, String route) throws Exception {
        JestClient jestClient = null;
        try {
            Delete delete = new Delete.Builder(id).index(indexName).type(typeName)
                    .setParameter(ROUTING_KEY, route).build();

            // 获取客户端
            jestClient = jestClientInstance.getJestClient();

            JestResult jr = jestClient.execute(delete);
            return jr.isSucceeded();
        } catch (Exception e) {
            jestClientInstance.closeJestClient(jestClient);
            throw e;
        }
    }

    public boolean batchDeleteDocument(String indexName, String typeName, Map<String, String> videoId2Routes) throws Exception {
        JestClient jestClient = null;
        try {
            Bulk.Builder bulk = new Bulk.Builder().defaultIndex(indexName).defaultType(typeName);

            for (Map.Entry<String, String> entry : videoId2Routes.entrySet()) {

                log.info("SynEsVideoInfoMsgListener 删除索引： id " + entry.getKey() + " - route " + entry.getValue());
                Delete delete = new Delete.Builder(entry.getKey())
                        .setParameter(ROUTING_KEY, entry.getValue()).build();
                bulk.addAction(delete);
            }

            // 获取客户端
            jestClient = jestClientInstance.getJestClient();

            BulkResult br = jestClient.execute(bulk.build());
            return br.isSucceeded();
        } catch (Exception e) {
            jestClientInstance.closeJestClient(jestClient);
            throw e;
        }
    }

    public boolean deleteByQuery(String indexName, String typeName, String query, String route) throws Exception {
        JestClient jestClient = null;
        try {

            DeleteByQueryExtend.Builder builder = new DeleteByQueryExtend.BuilderExtend(query).addIndex(indexName).addType(typeName);
            if (route != null) {
                builder.setParameter(ROUTING_KEY, route);
            }
            DeleteByQuery deleteByQuery = builder.build();

            // 获取客户端
            jestClient = jestClientInstance.getJestClient();

            JestResult jr = jestClient.execute(deleteByQuery);

            return jr.isSucceeded();
        } catch (Exception e) {
            jestClientInstance.closeJestClient(jestClient);
            throw e;
        }
    }


    /**
     * Get文档
     *
     * @param id
     * @return
     * @throws Exception
     */
    public JestResult getDocument(String indexName, String typeName, String id, String route) throws Exception {
        JestClient jestClient = null;
        try {
            Get.Builder builder = new Get.Builder(indexName, id).type(typeName);
            if (route != null) {
                builder.setParameter(ROUTING_KEY, route);
            }
            Get get = builder.build();

            // 获取客户端
            jestClient = jestClientInstance.getJestClient();

            return jestClient.execute(get);
        } catch (Exception e) {
            jestClientInstance.closeJestClient(jestClient);
            throw e;
        }

    }

    /**
     * 搜索文档
     *
     * @param query
     * @return
     * @throws Exception
     */
    public SearchResult searchDocument(String indexName, String typeName, String query, String route) throws Exception {
        JestClient jestClient = null;
        try {

            Search.Builder builder = new Search.Builder(query).addIndex(indexName).addType(typeName);
            if (route != null) {
                builder.setParameter(ROUTING_KEY, route);
            }
            builder.setParameter(VERSION_KEY, true);

            Search search = builder.build();

            // 获取客户端
            jestClient = jestClientInstance.getJestClient();

            return jestClient.execute(search);
        } catch (Exception e) {
            jestClientInstance.closeJestClient(jestClient);
            throw e;
        }
    }

    /**
     * Count文档
     *
     * @param query
     * @return
     * @throws Exception
     */
    public Double countDocument(String indexName, String typeName, String query, String route) throws Exception {
        JestClient jestClient = null;
        try {
            // 获取客户端
            jestClient = jestClientInstance.getJestClient();

            Count.Builder builder = new Count.Builder().addIndex(indexName).addType(typeName);
            if (route != null) {
                builder.setParameter(ROUTING_KEY, route);
            }
            Count count = builder.query(query).build();


            CountResult results = jestClientInstance.getJestClient().execute(count);

            return results.getCount();
        } catch (Exception e) {
            jestClientInstance.closeJestClient(jestClient);
            throw e;
        }

    }

    /*
     ********************************************************************************************************
     */


    /***************************************自定义扩展***********************************************************/
    static class DeleteByQueryExtend extends DeleteByQuery {
        DeleteByQueryExtend(Builder builder) {
            super(builder);
        }

        @Override
        public String getRestMethodName() {
            return "POST";
        }

        @Override
        protected String buildURI() {
            return super.buildURI().replace("_query", "_delete_by_query");
        }

        public static class BuilderExtend extends DeleteByQuery.Builder {
            BuilderExtend(String query) {
                super(query);
            }

            @Override
            public DeleteByQuery build() {
                return new DeleteByQueryExtend(this);
            }
        }
    }
}
