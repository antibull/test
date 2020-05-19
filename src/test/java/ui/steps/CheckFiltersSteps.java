package ui.steps;

import com.codeborne.selenide.Condition;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static endpoints.UIEndpoints.procurementTenders;
import static ui.Locators.*;

public class CheckFiltersSteps {


    @Step("Открыть страницу 'Закупки и тендеры")
    public void openSite(){
        open(procurementTenders);
    }

    @Step("Выбрать значение фильтра 'Тип тендера'- Запрос котировок")
    public void selectTenderType(){
        $(By.xpath(tenderTypeFilter)).click();
        $(By.xpath(tenderTypeOpntion)).click();
    }

    @Step("Нажать 'Показать'")
    public void pressShow(){
        $(By.xpath(sendForm)).click();
    }

    @Step("Открыть первый конкурс")
    public void openFirstTender(){
        $(By.xpath(firstResult)).click();
    }

    @Step("Перейти во вкладку 'Общая информация'")
    public void openGeneralInformation(){
        $(By.xpath(generalInformation)).click();
    }

    @Step("Проверить, что 'Вид конкурса'- Запрос котировок")
    public void checkTypeTender(){
        $(By.xpath(tenderTypeString)).shouldHave(Condition.exactText("запрос котировок"));
    }
}
