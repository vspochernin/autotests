package tests;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import pages.BasePage;
import pages.LoginPage;
import pages.SearchGroupsPage;
import utils.SearchGroupsDataProvider;

import static com.codeborne.selenide.Selenide.open;

public class SearchTest {

    @BeforeEach
    public void beforeAll() {
        Configuration.browser = "firefox";
    }

    @AfterEach
    public void afterEach() {
        Selenide.closeWindow();
    }

    @ParameterizedTest
    @MethodSource("searchKeywordsProvider")
    @DisplayName("Тест поиска групп.")
    public void testGroupSearch(String keyword) {
        open(BasePage.OK_URL);

        LoginPage loginPage = new LoginPage();
        loginPage.login();

        SearchGroupsPage searchGroupsPage = new SearchGroupsPage();
        searchGroupsPage.getGroupsTab().click();
        searchGroupsPage.search(keyword);

        searchGroupsPage.getSearchResults().shouldHave(CollectionCondition.sizeGreaterThan(0));
    }

    static Stream<String> searchKeywordsProvider() {
        return SearchGroupsDataProvider.searchKeywords();
    }
}
