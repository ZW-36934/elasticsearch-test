package com.star.elasticsearch.test;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.io.IOException;

public class CreateIndex_EsTest
{
    public static void main(String[] args) throws IOException {
        // 建立es客户端连接
        RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.56.10",9200,"http")));
        //创建索引
        CreateIndexRequest createIndex = new CreateIndexRequest("user");
        CreateIndexResponse createIndexResponse = esClient.indices().create(createIndex, RequestOptions.DEFAULT);
        // 响应状态
        boolean acknowledged = createIndexResponse.isAcknowledged();
        System.out.println("创建索引"+acknowledged);

        esClient.close();

    }
}
