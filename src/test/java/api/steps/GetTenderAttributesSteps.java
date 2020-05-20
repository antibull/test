package api.steps;

import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

import static api.httpmethods.GET.getWithParams;
import static endpoints.APIEndpoints.getTenderAttributes;
import static org.hamcrest.Matchers.equalTo;

public class GetTenderAttributesSteps {
    private Response response;

    @Step("Для одного из тендеров этого списка получить его описание(атрибуты тендера)")
    public void getTenderAttributes(){
        HashMap<String, String> params = new HashMap<>();

        //Поскольку не было найдено, где получается значение key,
        //оно было взято из примеров
        params.put("_key","1732ede4de680a0c93d81f01d7bac7d1");
        params.put("id","441286");
        params.put("company_id","220714");

        response = getWithParams(getTenderAttributes, params);
        //Проверяется, что в джейсоне пришел положительный результат
        //и вернулось имя нужной нам компании
        response.then().statusCode(200).and().body("success",equalTo("true"))
                .and().body("result.data.company_name", equalTo("Тирвас"));

    }

}
