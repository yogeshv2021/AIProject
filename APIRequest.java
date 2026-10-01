package configs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

import org.json.JSONArray;
import org.json.JSONObject;
import com.opencsv.*;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import static io.restassured.RestAssured.*;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

import io.restassured.response.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.ValidatableResponse;

import org.testng.asserts.SoftAssert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.junit.jupiter.api.*;
import org.testng.annotations.Test;
import java.util.Properties;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



@Test
public class APIRequest{

   Properties properties;
   private ExtentReports extent;
   private ExtentTest test;

   @BeforeAll
   public void readproperties(){ 
      String Filepath ="";
      try{
          Filepath = "Configuration.properties";
          Properties properties= new Properties();
          FileReader getFile = new FileReader(Filepath);
          BufferedReader getObject = new BufferedReader(getFile);
          properties.load(getObject);
          getObject.close();
          getFile.close();

          ExtentSparkReporter htmlreporter = new ExtentSparkReporter("path");
          extent = new ExtentReports();
          extent.attachReporter(htmlreporter);

       }
      catch(IOException e){
          e.printStackTrace();
      } 
   }

   
   @Test
   public Map<String,Object> stringtoMap(String header){

        Map<String,Object> HeaderContent = new HashMap<String,Object>();
 
        String[] getelement = header.split(",");
        for (int i=0;i<getelement.length;i++){
                String element = getelement[i];
                System.out.println(element.split(":"));
                String key = element.split(":")[0];
                String value = element.split(":")[1];
                HeaderContent.put(key,value);
        } 
        return HeaderContent;
    }

    
    @Test
    public Response SendgetMethod(String uri,String path,Map<String,Object> header,String body){
            RequestSpecBuilder specbuilder = new RequestSpecBuilder().setUrlEncodingEnabled(false);
            RequestSpecification requestspec = specbuilder.build();
            Response response = given()
            .spec(requestspec)
            .baseUri(properties.getProperty("Nginx_uri"))
            .basePath(path)
            .contentType(ContentType.JSON)
            .headers(header)
            .when().get();

            return response;
    }

    @Test
    public Response SendpostMethod(String uri,String path,Map<String,Object> header,String body,LinkedHashMap<String,String> responsebody){
            RequestSpecBuilder specbuilder = new RequestSpecBuilder().setUrlEncodingEnabled(false);
            RequestSpecification requestspec = specbuilder.build();
            Response response = given()
            .spec(requestspec)
            .baseUri(uri)
            .basePath(path)
            .contentType(ContentType.JSON)
            .headers(header)
            .body(body)
            .when().post();

            return response;
    }

    @Test
    public LinkedHashMap<String,String> responsebody(){

           LinkedHashMap<String,String> bodymap = new LinkedHashMap<String,String>();
           bodymap.put("code","50136");
           bodymap.put("message","Already Flow Execution for the combination of given Virtual Number and User Number");
           return bodymap;
    }

    @AfterAll
    public void tearDown() {
        extent.flush();
    }
}
