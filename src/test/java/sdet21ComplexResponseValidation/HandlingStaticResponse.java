package sdet21ComplexResponseValidation;



import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class HandlingStaticResponse {

	@Test
	public void staticResponse()
	{
		baseURI ="http://localhost";
		port=8084;
		
		String expData="TY_PROJ_001";
		 Response res=when()
				 .get("/projects");
		 String actData=res.jsonPath().get("[0].projectId");
		 System.out.println(actData);
		 
		 Assert.assertEquals(actData, expData);
		 System.out.println(actData+" verified");
		 res.then().log().all();
		 
	}
}
