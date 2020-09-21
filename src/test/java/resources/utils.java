package resources;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class utils {

	public static String getJsonPath(Response response, String key ) {
		// TODO Auto-generated method stub
		String resp = response.asString();
	    JsonPath jp =new JsonPath(resp);
	    return jp.get(key).toString();
	}

}
