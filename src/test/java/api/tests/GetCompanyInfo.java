package api.tests;

import api.steps.GetCompanyInfoSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;

@Narrative(text="Реквизиты компании")
@RunWith(SerenityRunner.class)
@WithTag("api")
public class GetCompanyInfo {
    @Steps
    private GetCompanyInfoSteps getCompanyInfo;

    @Test
    @Title("Для компании-организатора получить ее публичные данные, реквизиты")
    public void getCompanyReq(){
        getCompanyInfo.getCompanyInfo();
    }
}
