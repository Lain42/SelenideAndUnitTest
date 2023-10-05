package ui;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GoogleMainPage extends GoogleSearchPage {
    public static final SelenideElement SEARCH_INPUT = $(byXpath("//*[@name='q']"));

    protected void searchFor(String text) {
        SEARCH_INPUT.setValue(text).pressEnter();
        LOGO_SELECTOR.shouldBe(visible);
    }
}
