package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;



public class BaseSelenideTest {
    private static final String GOOGLE_HOME = "https://www.google.com/ncr";

    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-fullscreen");
        Configuration.browserCapabilities = options;
        Selenide.open(GOOGLE_HOME);
    }
}
