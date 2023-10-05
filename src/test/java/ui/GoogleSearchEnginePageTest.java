package ui;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleSearchEnginePageTest extends GoogleMainPage {

    private static final String TEST_VALUE = "Fallout";

    @Test(testName = "GoogleSearchEnginePageTest : Search by: Name, full name",
            description = "Valid search is based on the current output of your search query.")
    public void searchByValue() {
        searchFor(TEST_VALUE);
        checkSearchResult(TEST_VALUE);
    }

    @Test(testName = "GoogleSearchEnginePageTest : check tooltip",
            description = "When you hover the mouse over the input field, " +
                    "the corresponding tooltip is displayed (in google this is the word 'Search'")
    public void checkCorrespondingTooltip() {
        Assert.assertEquals(SEARCH_INPUT.getAttribute("title"), "Search",
                "Tooltip with 'Search' word didn't appear on the google.com page");
    }

    @Test(testName = "GoogleSearchEnginePageTest : check redirect to the index",
            description = "After clicking on the logo in the upper left side, an empty results area is displayed.")
    public void testLogoClickResultsArea() {
        searchFor(TEST_VALUE);
        goToGoogleHome();
        Assert.assertEquals(SEARCH_INPUT.getOwnText(), "", "Search field wasn't empty");
    }
}
