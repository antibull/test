package api.httpmethods;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;

import java.util.HashMap;

public class GET {
    public static Response getWithParams(String path, HashMap<String, String> params) {
        return SerenityRest.given().header("Accept","application/json").params(params).get(path);
    }
}
