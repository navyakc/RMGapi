package EndtoEnd;

import org.testng.Assert;
import org.testng.annotations.Test;

import SDET21POJO.ProjectLibrary;
import genericUtils.BaseClassUtility;
import genericUtils.EndPoints;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.response.ValidatableResponseOptions;

public class createProjectnVerifyinDatabase extends BaseClassUtility {

	@Test
	public void createprojectVerifyDatabase ()
	{
		ProjectLibrary pLib = new ProjectLibrary("Praveen", "chrome" + jLib.getRandomNumber(), "Created", 34);
		Response res = given()
		.contentType(ContentType.JSON)
		.body(pLib)
		.when()
		.post(EndPoints.addProject);
		res.then().log().all();
		
		// capture the expected data
		String expData = rLib.getJsonData(res, "projectName");
		System.out.println(expData);
		
		// verify it in database
		String query = "select * from project";
		String actData = dLib.executeQueryAndGetData(query, 4, expData);
		
		// validate
		Assert.assertEquals(actData, expData);
		System.out.println("Successfull");
	}

	private ValidatableResponseOptions<ValidatableResponse, Response> given() {
		// TODO Auto-generated method stub
		return null;
	}
}
