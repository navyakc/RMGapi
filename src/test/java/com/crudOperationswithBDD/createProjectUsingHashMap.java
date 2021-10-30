package com.crudOperationswithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class createProjectUsingHashMap {
	
	@Test
	
	public void createProjectUsingHashMap()
	{
		HashMap map = new HashMap();
		map.put("createdBy", "Navya");
		map.put("projectName", "SDET21");
		map.put("status", "Completed");
		map.put("teamSize", 23);
		
		given()
		.contentType(ContentType.JSON)
		.body(map)
		
		.when()
		.post("http://localhost:8084/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.log().all();
	}

}
