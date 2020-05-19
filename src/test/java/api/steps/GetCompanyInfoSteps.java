package api.steps;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

import static api.httpmethods.GET.getWithParams;
import static endpoints.APIEndpoints.getCompanyInfo;
import static org.hamcrest.Matchers.equalTo;

public class GetCompanyInfoSteps {
    private Response response;

    @Step("Для компании-организатора получить ее публичные данные, реквизиты")
    public void getCompanyInfo(){
        HashMap<String, String> params = new HashMap<>();
        params.put("id","220714");


        response = getWithParams(getCompanyInfo, params);
        //Проверяется, что в джейсоне пришел положительный результат
        //и вернулся ответ с нужным идом компании
        response.then().statusCode(200).and().body("success", equalTo("true"))
        .and().body("result.args.id", equalTo("220714"));


    }
}
