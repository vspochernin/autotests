package tests;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.codeborne.selenide.CollectionCondition;

import pages.LoginPage;
import pages.SearchGroupsPage;
import utils.SearchGroupsDataProvider;

public class SearchTest extends BaseTest {

    @ParameterizedTest
    @MethodSource("searchKeywordsProvider")
    @DisplayName("Тест поиска групп.")
    public void testGroupSearch(String keyword) {
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
