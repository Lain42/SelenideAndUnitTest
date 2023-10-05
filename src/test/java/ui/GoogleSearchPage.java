package ui;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GoogleSearchPage extends BaseSelenideTest {
    public static final SelenideElement SEARCH_INPUT = $(byXpath("//*[@name='q']"));
    public static final SelenideElement LOGO_SELECTOR = $(byXpath("//*[@id='logo']"));
    public static final ElementsCollection SEARCH_h3_RESULT = $$(byXpath("//span/a/h3"));

    protected void searchFor(String text) {
        SEARCH_INPUT.setValue(text).pressEnter();
        LOGO_SELECTOR.shouldBe(visible);
    }

    protected void goToGoogleHome() {
        LOGO_SELECTOR.click();
        SEARCH_INPUT.shouldBe(visible);
    }

    protected void checkSearchResult(String testValue) {
        for (String toTest: SEARCH_h3_RESULT.texts()) {
            Assert.assertTrue(toTest.toLowerCase().contains(testValue.toLowerCase()), toTest +
                    " header h3 doesn't contain " + testValue);
        }
    }
}
