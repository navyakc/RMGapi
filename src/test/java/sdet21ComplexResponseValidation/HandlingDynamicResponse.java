package sdet21ComplexResponseValidation;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.util.List;

public class HandlingDynamicResponse {
	@Test
    public void DynamicResponse()
{

		baseURI ="http://localhost";
		port=8084;
		
		String expData="TY_34";
		Response res=when()
				 .get("/projects");
		List<String> pname = res.jsonPath().get("projectName");
		for(String actData:pname)
		{
			if(actData.equalsIgnoreCase(expData))
			{
				Assert.assertEquals(actData, expData);
				System.out.println(actData+ "data present");
				break;
			}
		}
		

		res.then().log().all();
}
}