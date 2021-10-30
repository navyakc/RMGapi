package com.crudOperationswithBDD;

import org.testng.annotations.Test;

import SDET21POJO.ProjectLibrary;
import genericUtils.JavaUtility;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingPOJO {

	@Test
	
	public void createProjectUsingPOJO()
	{
		JavaUtility jLib= new JavaUtility();
		baseURI ="http://localhost";
		port=8084;
		
		ProjectLibrary pLib= new ProjectLibrary("Navya k c","TY"+jLib.getRandomNumber() , "Completed",12);
		
		given()
		.contentType(ContentType.JSON)
		.body(pLib)
		
		.when()
		.post("/addProject")
		
		.then()
		.statusCode(201)
		.log().all();
	}
}
