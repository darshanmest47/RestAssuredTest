package com.test;

import POJO.Main;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestPOJO {

    @Test
    public void testMethod(){
        RestAssured.baseURI = "https://run.mocky.io";

        Main response = given().when().get("/v3/eac55dba-f4f3-4f06-83dc-e4a5869cf4a7").as(Main.class);
        System.out.println(response.getAge());   //27
        System.out.println(response.getName());  //abcd
        System.out.println(response.getEmail()); //abcd@example.com
        System.out.println(response.getCountry().get(1).getDistrict()); //d1
        System.out.println(response.getCountry().get(1).getStatename()); //null
        System.out.println(response.getCountry().get(0).getDistrict()); //null
        System.out.println(response.getCountry().get(0).getStatename()); //abcd2
        System.out.println(response.getProfessional_details().get(1).getOrganizations().get(0).getOrg_name()); //xyz
        System.out.println(response.getProfessional_details().get(0).getTotal_workduration()); //7 years


    }
}
