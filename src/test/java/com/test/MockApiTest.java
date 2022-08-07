package com.test;

import io.restassured.RestAssured;
import static  io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class MockApiTest {

    @Test(priority = 0)
    public void testMockApi(){
        RestAssured.baseURI="https://run.mocky.io";
        given().when().get("/v3/2feb3abe-e65c-42ea-8ed8-a6df6cf39930").then().log().all().assertThat().statusCode(200);
    }
}
