    package com.test;

    import RestAssuredPOJO.ApiResponse;
    import RestAssuredPOJO.WebAutomation;
    import io.restassured.RestAssured;
    import static io.restassured.RestAssured.*;

    import io.restassured.parsing.Parser;
    import io.restassured.path.json.JsonPath;
    import org.testng.Assert;
    import org.testng.annotations.Test;

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.HashMap;
    import java.util.List;

    public class RestAssuredTest {

        String code="4%2F0AdQt8qjipvI_TYRNpQNVT0QKdC_YshyWMj5ysnkzq3S6sgGnGZJO6ULTKDGeSF4izzAfog";
        ApiResponse apiresponse;

        String access_token;

        String[] arr={"Selenium Webdriver Java","Cypress","Protractor"};

        @Test(priority = 0)
        public void getAccessToken(){
            RestAssured.baseURI = "https://www.googleapis.com";
            HashMap<String, Object> m1 = new HashMap<String, Object>();
            m1.put("code",code);
            m1.put("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com");
            m1.put("client_secret","erZOWM9g3UtwNRj340YYaK_W");
            m1.put("redirect_uri","https://rahulshettyacademy.com/getCourse.php");
            m1.put("grant_type","authorization_code");

            String resp = given().urlEncodingEnabled(false).queryParams(m1).when().post("/oauth2/v4/token").then().extract().asString();
            JsonPath js = new JsonPath(resp);
            access_token = js.get("access_token");
            System.out.println(access_token);
        }

        @Test(priority = 1)
        public void getCourses(){
          baseURI = "https://rahulshettyacademy.com";

          apiresponse=given().queryParam("access_token",access_token).expect().defaultParser(Parser.JSON).when().get("/getCourse.php").as(ApiResponse.class);
          System.out.println(apiresponse.getLinkedIn());
          System.out.println(apiresponse.getCourses().getMobile().get(0).getCourseTitle());
        }

        @Test(priority=2)
        public void displayWebAutomationCourseTitleAndPrice(){
            List<WebAutomation> webautomation = apiresponse.getCourses().getWebAutomation();
            ArrayList<Object> courseList = new ArrayList<>();
            for(WebAutomation details:webautomation){
                courseList.add(details.getCourseTitle());
               
            }
            System.out.println();
            List<String> arrayList = Arrays.asList(arr);
            Assert.assertEquals(courseList,arrayList);
        }

    }
