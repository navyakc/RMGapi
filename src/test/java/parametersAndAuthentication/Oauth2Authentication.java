package parametersAndAuthentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class Oauth2Authentication {

	@Test
	public void oauth2Authentication()
	{
		Response res = given()
				.formParam("client_id", "SDET21")
				.formParam("client_secret", "0ae32b9b249a69df6af29c251d4ac893")
				.formParam("grant_type ", "client_credentials ")
				.formParam("redirect_uri", "http://example.com")
				.formParam("code ", "authorization_code")
				.when()
				.post("http://coop.apps.symfonycasts.com");
				String Token=res.jsonPath().get("http://coop.apps.symfonycasts.com/token");
				System.out.println(Token);
				
				given()
				.auth()
				.oauth2(Token)
				.pathParam("USER_ID", "2423")
				
				.when()
				.post("http://coop.apps.symfonycasts.com/{USER_ID}")
				.then().log().all();
				
	}
}
