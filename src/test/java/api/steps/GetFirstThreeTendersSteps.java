package api.steps;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

import static api.httpmethods.GET.getWithParams;
import static endpoints.APIEndpoints.getFirstThreeTenders;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class GetFirstThreeTendersSteps {
    private Response response;

    @Step("Получить первые 3 тендера в состоянии Открыт")
    public void getFirstThreeTenders(){
        HashMap<String, String> params = new HashMap<>();

        params.put("_key","1732ede4de680a0c93d81f01d7bac7d1");
        params.put("set_type_id","1");
        params.put("set_id","220714");
        params.put("max_rows","3");
        params.put("open_only","true");

        response = getWithParams(getFirstThreeTenders, params);
        //Проверяется, что в джейсоне пришел положительный результат
        //и принят верный параметр на кол-во строк
        response.then().statusCode(200).and().body("success", equalTo("true"))
        .and().body("result.args.max_rows", equalTo("3"));
    }

}
