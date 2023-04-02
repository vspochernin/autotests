package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;

public class SearchGroupsPage {

    private static final By GROUPS_TAB = By.xpath("//a[contains(@href, '/groups')]");
    private static final By SEARCH_FIELD = By.xpath("//input[@role='search']");
    private static final By SEARCH_RESULTS = By.xpath("//div[@class='ucard-v __h group-big-card __trimmed __flex']");

    public SelenideElement getGroupsTab() {
        return $(GROUPS_TAB);
    }

    public SelenideElement getSearchField() {
        return $(SEARCH_FIELD);
    }

    public ElementsCollection getSearchResults() {
        return $$(SEARCH_RESULTS);
    }

    public SearchGroupsPage search(String query) {
        getSearchField().setValue(query);
        sleep(1000);
        getSearchField().pressEnter();
        return this;
    }
}
