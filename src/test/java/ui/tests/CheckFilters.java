package ui.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import ui.steps.CheckFiltersSteps;

@Narrative(text="Проверка фильтра работы 'Тип тендера'")
@RunWith(SerenityRunner.class)
@WithTag("ui")
public class CheckFilters {
    @Steps
    private CheckFiltersSteps checkFilters;

    @Test
    @Title("Проверка фильтра работы 'Тип тендера'")
    public void checkFilter(){
        checkFilters.openSite();
        checkFilters.selectTenderType();
        checkFilters.pressShow();
        checkFilters.openFirstTender();
        checkFilters.openGeneralInformation();
        checkFilters.checkTypeTender();
    }
}
