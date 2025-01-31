import org.apache.log4j.Logger;
import org.example.TestsRunner;
import org.example.pages.SelectStrategy;
import org.example.pages.WebFormPage;
import org.testng.annotations.Test;

public class PrefillFormTestCase extends TestsRunner {

    @Test
    public void testThatFormCanBePrefilledByUser() {
        WebFormPage  webFormPage = new WebFormPage(driver);

        webFormPage.typeTextInput("Hello")
                .typePasswordInput("Hello")
                .typeTextAreaInput("Hello text Area ")
                .selectItemInDropDown("One", SelectStrategy.BY_VISIBLE_TEXT)
                .selectItemInDataListByIndex(1)
                .chooseCheckBox(2)
                .chooseRadioButton(2)
                .selectColorInPicker("#FFEEXX")
                .selectCurrentDateInDatePicker()
                .changeScale(3,true);
    
    }
}
