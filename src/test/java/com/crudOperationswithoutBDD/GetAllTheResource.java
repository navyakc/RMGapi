package com.crudOperationswithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllTheResource {

	@Test
	public void getAllData()
	{
		Response response = RestAssured.get("http://localhost:8084/projects");
		System.out.println(response.getContentType());
		System.out.println(response.getTime());
		System.out.println(response.statusCode());
		ValidatableResponse validate = response.then();
		validate.assertThat().contentType("application/json");
		validate.assertThat().statusCode(200);
		validate.log().all();
		
	}
	
	
	
}
