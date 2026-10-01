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



public class APIUtils{

}
