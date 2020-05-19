package api.tests;

import api.steps.GetTenderAttributesSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;

@Narrative(text="Информация о тендере")
@RunWith(SerenityRunner.class)
@WithTag("api")
public class GetTenderAttributes {
    @Steps
    private GetTenderAttributesSteps getTenderAttributes;

    @Test
    @Title("Для одного из тендеров этого списка получить его описание(атрибуты тендера)")
    public void getTenderAttributes(){
        getTenderAttributes.getTenderAttributes();
    }
}
