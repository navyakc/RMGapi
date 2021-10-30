package parametersAndAuthentication;

import org.testng.annotations.Test;

import SDET21POJO.ProjectLibrary;
import genericUtils.JavaUtility;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChainingGet {

	@Test
	public void requestChaining()
	{
		JavaUtility jLib=new JavaUtility();
		baseURI ="http://localhost";
		port=8084;
		
		ProjectLibrary pLib=new ProjectLibrary("nav", "TY", "Completed" + jLib.getRandomNumber(), 15);
		Response res = given()
		.contentType(ContentType.JSON)
		.body(pLib)
		
		.when()
		.post("/addProject");
		
		String pID = res.jsonPath().get("projectId");
		System.out.println(pID);
		
		given()
		.pathParam("proID", pID)
		.when()
		.get("/projects/{proID}")
		.then().assertThat().statusCode(200).log().all();
		
	}

}
