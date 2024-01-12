package com.star.elasticsearch.test;

import org.apache.http.HttpHost;
import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.MaxAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

import java.io.IOException;
import java.util.List;

public class QueryEs_EsTest {

    public static void main(String[] args) throws IOException {
        // 建立es客户端连接
        RestHighLevelClient esClient = new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.56.10",9200,"http")));

        // 1、查询索引中全部数据
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        //sourceBuilder.query(QueryBuilders.matchQuery("name","张三"));
//        sourceBuilder.query(QueryBuilders.matchAllQuery());
//        request.source(sourceBuilder);
//        SearchResponse search = esClient.search(request, RequestOptions.DEFAULT);
//        SearchHit[] hits = search.getHits().getHits();
//        for (SearchHit hit : hits) {
//            System.out.println("结果为:"+hit.getSourceAsString());
//        }

        // 2、高亮查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//         //TermsQueryBuilder termsQueryBuilder = QueryBuilders.termsQuery("name", "李四");
//        TermsQueryBuilder termsQueryBuilder = QueryBuilders.termsQuery("name", "lisi");
//
//        //构建高亮显示的前后缀
//        HighlightBuilder highlightBuilder = new HighlightBuilder();
//        highlightBuilder.field("name");
//        highlightBuilder.preTags("<font color='red'>");
//        highlightBuilder.postTags("</font>");
//
//        sourceBuilder.highlighter(highlightBuilder);
//        sourceBuilder.query(termsQueryBuilder);
//
//        request.source(sourceBuilder);
//        SearchResponse search = esClient.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = search.getHits();
//
//        System.out.println(search.getTook());
//
//        for (SearchHit hit : hits) {
//            System.out.println("结果为:"+hit.getSourceAsString());
//            System.out.println("显示的高亮数据为:"+hit.getHighlightFields().get("name"));
//        }

        // 3、分页查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        // (当前页码-1)*每页显示数据条数
//        builder.from(2);
//        builder.size(2);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        // 4、查询排序
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        builder.query(QueryBuilders.matchAllQuery());
//        builder.sort("age", SortOrder.DESC);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        for ( SearchHit hit : hits ) {
//            System.out.println(hit.getSourceAsString());
//        }

        // 5、过滤字段
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//
//        String[] includes = {};
//        String[] excludes = {"age"};
//        builder.fetchSource(includes, excludes);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        for ( SearchHit hit : hits ) {
//            System.out.println(hit.getSourceAsString());
//        }

        // 6、组合查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
//
//        //boolQuery.must(QueryBuilders.matchQuery("age", 20));
//        boolQuery.should(QueryBuilders.matchQuery("age", 40));
//
//        builder.query(boolQuery);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for ( SearchHit hit : hits ) {
//            System.out.println(hit.getSourceAsString());
//        }

        // 7. 范围查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("age");
//
//        rangeQuery.gte(30);
//        rangeQuery.lt(50);
//
//        builder.query(rangeQuery);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for ( SearchHit hit : hits ) {
//            System.out.println(hit.getSourceAsString());
//        }

        // 8. 模糊查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        builder.query(QueryBuilders.matchQuery("name", "lisi"));
//        //builder.query(QueryBuilders.fuzzyQuery("name", "lis").fuzziness(Fuzziness.ONE));
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//
//        System.out.println(hits.getTotalHits());
//        System.out.println(response.getTook());
//
//        for ( SearchHit hit : hits ) {
//            System.out.println(hit.getSourceAsString());
//        }

        // 9. 聚合查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//
//        MaxAggregationBuilder aggregationBuilder = AggregationBuilders.max("maxAge").field("age");
//        builder.aggregation(aggregationBuilder);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        Aggregations aggregations = response.getAggregations();
//
//        SearchHits hits = response.getHits();
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }

        // 10、分组查询
//        SearchRequest request = new SearchRequest();
//        request.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        TermsAggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("ageGroup").field("age");
//
//        builder.aggregation(termsAggregationBuilder);
//
//        request.source(builder);
//        SearchResponse response = esClient.search(request, RequestOptions.DEFAULT);
//
//        SearchHits hits = response.getHits();
//        for (SearchHit hit : hits) {
//            System.out.println(hit);
//        }


    }




}
