package parametersAndAuthentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class BearerToken {

	@Test
	public void bearerToken()
	{
		HashMap map=new HashMap();
		map.put("name","REST-SDET21-BEARER-TOKEN");
		given()
		.auth()
		.oauth2("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")
		.body(map)
		.when()
		.post("https://api.github.com")
		.then().log().all();
	}
}
