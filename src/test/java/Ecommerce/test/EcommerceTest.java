package Ecommerce.test;

import ECommercePOJO.CreateorderPojo;
import ECommercePOJO.LoginPojo;
import ECommercePOJO.Orders;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.io.File;
import java.util.*;
import static io.restassured.RestAssured.*;

public class EcommerceTest {

    private String token="";
    private String userId="";
    private String productId="";

    public RequestSpecification returnBaseURI(){
        RequestSpecification baseURI = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/api/ecom").addHeader("Content-Type","application/json").build();
        return baseURI;
    }

    public RequestSpecification returnBaseURLWithAuth(String token,String headerType){
        if(headerType == null){
            return new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/api/ecom")
                    .addHeader("Authorization",token).build();
        }
        else{
            return new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com/api/ecom")
                    .addHeader("Authorization",token).addHeader("Content-Type",headerType).build();
        }

    }

    public JsonPath getJS(String response){
        JsonPath js = new JsonPath(response);
        return js;
    }

    public void LoggerInfo(Object value){
        System.out.println(" Logging the details"+" "+value);
    }


    @Test(priority = 0)
    public void loginTest(){
        LoginPojo lp = new LoginPojo();
        lp.setUserEmail("darshanmesta33@gmail.com");
        lp.setUserPassword("DarshanKA47@");
        String loginResponse = given().log().all().spec(returnBaseURI()).body(lp).when().post("/auth/login").asString();
        JsonPath js = getJS(loginResponse);
        token = js.get("token");
        userId=js.get("userId");
        LoggerInfo(token);
        LoggerInfo(userId);


    }

    @Test(priority = 1,dependsOnMethods = "loginTest")
    public void addProduct(){
        Map<String, Object> hs = new HashMap<String, Object>();
        hs.put("productDescription"," Apple ipad 9th Generation (A13 Bionic chip)");
        hs.put("productFor"," Everyone");
        hs.put("productName","ipad9thGeneration");
        hs.put("productAddedBy",userId);
        hs.put("productCategory"," Electronics");
        hs.put("productSubCategory"," Apple Products");
        hs.put("productPrice"," 30900");

        RequestSpecification baseURI = returnBaseURLWithAuth(token,null);

        String addProductresp = given().log().all().spec(baseURI).params(hs).multiPart("productImage", new File("C:\\Users\\DELL\\Downloads\\ipad9thgen.jpg"))
                .when().post("/product/add-product").then().log().all().extract().response().asString();
        JsonPath js = getJS(addProductresp);
        productId=js.get("productId");
        LoggerInfo(productId);
    }


    @Test(priority = 2,dependsOnMethods = "addProduct")
    public void createOrder(){
        RequestSpecification baseURI = returnBaseURLWithAuth(token,"application/json");
        CreateorderPojo cp = new CreateorderPojo();
        Orders oi = new Orders();
        oi.setCountry("India");
        oi.setProductOrderedId(productId);
        ArrayList<Orders> al = new ArrayList<Orders>();
        al.add(oi);
        cp.setOrders(al);

        given().log().all().spec(baseURI).body(cp).when().post("/order/create-order").then().log().all();
    }


//    @Test
//    public void testM(){
//        OrderInfo oi = new OrderInfo();
//        oi.setCountry("India");
//        oi.setProductOrderedId("");
//        CreateorderPojo cp = new CreateorderPojo();
//        LoggerInfo(cp.getOrders().);
//
//
//
//    }

}
