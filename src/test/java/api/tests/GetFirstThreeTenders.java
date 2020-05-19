package api.tests;

import api.steps.GetFirstThreeTendersSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.junit.Test;
import org.junit.runner.RunWith;

@Narrative(text="Первые 3 тендера в состоянии Открыто")
@RunWith(SerenityRunner.class)
@WithTag("api")
public class GetFirstThreeTenders {
    @Steps
    private GetFirstThreeTendersSteps getFirstThreeTenders;

    @Test
    @Title("Получить список первых 3 тендеров в состоянии открыт для любой компании-организатора ")
    public void getFirstThreeTenders(){
        getFirstThreeTenders.getFirstThreeTenders();
    }
}
