package com.star.elasticsearch.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.star.elasticsearch.entity.User;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class BulkRequest_EsTest
{
    public static void main(String[] args) throws IOException {
        // 建立es客户端连接
        RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.56.10",9200,"http")));

        BulkRequest request = new BulkRequest();
        //向ES插入数据，必须将数据转换为JSON格式
        ObjectMapper mapper = new ObjectMapper();

        request.add(new IndexRequest("user").id("1002").source(mapper.writeValueAsString(new User("张三",'女',25)), XContentType.JSON));
        request.add(new IndexRequest("user").id("1003").source(mapper.writeValueAsString(new User("李四",'男',30)), XContentType.JSON));
        request.add(new IndexRequest("user").id("1004").source(mapper.writeValueAsString(new User("王五",'女',30)), XContentType.JSON));
        request.add(new IndexRequest("user").id("1005").source(mapper.writeValueAsString(new User("lisi",'男',30)), XContentType.JSON));
        request.add(new IndexRequest("user").id("1006").source(mapper.writeValueAsString(new User("wangwu",'女',35)), XContentType.JSON));

        BulkResponse bulk = esClient.bulk(request, RequestOptions.DEFAULT);

    }
}
