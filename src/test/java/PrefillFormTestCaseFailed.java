import org.example.TestsRunner;
import org.example.listeners.AIListener;
import org.example.listeners.TestsResultsListener;
import org.example.pages.SelectStrategy;
import org.example.pages.WebFormPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Listeners( { TestsResultsListener.class} )
public class PrefillFormTestCaseFailed extends TestsRunner {

    @Test
    public void testThatFormCanBePrefilledByUserFailed() {
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


        assertThat("Looks like value in Text input is wrong ",
                webFormPage.getTextInputValue(),
                is("It's ok"));
    
    }
}
