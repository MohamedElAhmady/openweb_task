package com.openweb.test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.openweb.datatransferobject.EmployeeDTO;

public class TestRestAPI {

	public static Response response;
	public static String jsonAsString;

	@BeforeClass
	public static void callRidesAPI() {
		RestAssured.baseURI = "http://localhost:8080";
		RestAssured.basePath = "/api/";
		response = RestAssured.when().get("/employees/").then().contentType(ContentType.JSON).extract().response();
		jsonAsString = response.asString();
	}

	// sample of tests that can be done on the rest service
	@Test
	public void testJSON() {

		Type type = new TypeToken<List<EmployeeDTO>>() {
		}.getType();
		ArrayList<EmployeeDTO> jsonAsArrayList = new Gson().fromJson(jsonAsString, type);

		assertThat(jsonAsArrayList.size(), equalTo(9));

		List<String> images = response.path("profileImageURL");

		assertThat(images.get(0),
				equalTo("https://en.openweb.nl/binaries/teaser/content/gallery/ow/employees/omar.jpg"));

	}
}
