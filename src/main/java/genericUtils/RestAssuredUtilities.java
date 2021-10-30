package genericUtils;

public class RestAssuredUtilities {

	public String getJsonData(Response res, String jsonPath) {
		String value = res.jsonPath().get(jsonPath);
		return value;
	}
}
