package com.chenxi.elasticsearch.jest;

import com.google.gson.GsonBuilder;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.client.http.JestHttpClient;

import java.util.LinkedList;
import java.util.List;

public class BaseJestClient {
    private static JestClientFactory jestClientFactory = new JestClientFactory();

    private static ThreadLocal<JestHttpClient> jestClientThreadLocal = new ThreadLocal<>();

    //ip:port集合，es的集群全部节点
    private String nodeIpPortList;
    //es集群名称
    private String clusterName;

    private void init() {
        String[] nodes = nodeIpPortList.split(",");
        List<String> nodeList = new LinkedList<>();

        for (String node : nodes) {
            if (node != null && !node.equals("")) {
                nodeList.add("http://" + node);
            }
        }

        HttpClientConfig httpClientConfig = new HttpClientConfig.Builder(nodeList)
                .multiThreaded(true)
                .gson(new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create())
                .readTimeout(6000)
                .connTimeout(10000)
                .build();
        jestClientFactory.setHttpClientConfig(httpClientConfig);
    }

    static synchronized JestHttpClient getJestClient() {
        JestHttpClient jestHttpClient = jestClientThreadLocal.get();
        if (jestHttpClient == null) {
            jestHttpClient = (JestHttpClient) jestClientFactory.getObject();
            jestClientThreadLocal.set(jestHttpClient);
        }
        return jestHttpClient;
    }


    public String getNodeIpPortList() {
        return nodeIpPortList;
    }

    public String getClusterName() {
        return clusterName;
    }

    /**
     * 关闭JestClient客户端
     *
     * @param jestClient
     * @throws Exception
     */
    public static void closeJestClient(JestClient jestClient) throws Exception {

        if (jestClient != null) {
            jestClient.shutdownClient();
        }
    }
}
