package com.wangwenjun.cicd.chapter02;

import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.*;

public class REST_AssuredTest
{

    @Before
    public void setup()
    {
        //指定base uri
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
        //指定端口
        RestAssured.port = 80;
    }

    @Test
    public void testRequestHttpStatus_OK()
    {
        //当通过get方法请求/posts时http得到状态码为200
        when().request("GET", "/posts").then().statusCode(is(200));
    }

    @Test
    public void testListPosts()
    {
        //posts返回的文章数据列表超过10个
        get("/posts").then().assertThat().body("size()", greaterThan(10));
    }

    @Test
    public void testRequestSpecPost()
    {
        get("/posts/1").then().assertThat().body("title", is(equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit")));
    }

    @Test
    public void testRequestPostNotExist()
    {
        get("/posts/12345").then().statusCode(is(404));
    }

    @After
    public void tearDown()
    {
        RestAssured.reset();
    }
}
