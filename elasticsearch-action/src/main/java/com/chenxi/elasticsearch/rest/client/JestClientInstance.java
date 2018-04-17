package com.chenxi.elasticsearch.rest.client;

import com.google.gson.GsonBuilder;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhaochenxi1 in 2018/1/23
 */
public class JestClientInstance {
    private static ThreadLocal<JestClient> localClient = new ThreadLocal<>();

    private JestClientFactory jestClientFactory;

    private String serverUris;

    public void setServerUris(String serverUris) {
        this.serverUris = serverUris;
    }

    /**
     * 获取JestClient对象
     *
     * @return
     */
    JestClient getJestClient() {
        JestClient jestClient = localClient.get();
        try {
            if (jestClient == null) {
                synchronized (this) {
                    if (this.jestClientFactory == null) {
                        this.jestClientFactory = new JestClientFactory();

                        HttpClientConfig.Builder builder = new HttpClientConfig
                                    .Builder(Arrays.asList(serverUris.split(";")));

                        builder.gson(new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create());
                        builder.connTimeout(5000);
                        builder.readTimeout(15000);
                        builder.defaultMaxTotalConnectionPerRoute(2);
                        builder.maxTotalConnection(30);
                        builder.multiThreaded(true);

                        this.jestClientFactory.setHttpClientConfig(builder.build());
                    }
                }
                jestClient = this.jestClientFactory.getObject();
                localClient.set(jestClient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jestClient;
    }

    /**
     * 关闭JestClient客户端
     *
     * @param jestClient
     * @throws Exception
     */
    public void closeJestClient(JestClient jestClient) throws Exception {
        localClient.remove();
        if (jestClient != null) {
            jestClient.shutdownClient();
        }
    }
}
