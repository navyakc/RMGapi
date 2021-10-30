package parametersAndAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class pathParameter {

	@Test
	public void pathparameter()
	{
		baseURI ="http://localhost";
		port=8084;
		
		given()
		.pathParam("projID", "TY_PROJ_616")
		
		.when()
		.get("/projects/projID")
		
		.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}
}
