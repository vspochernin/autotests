package tests;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import pages.MainPage;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.*;

import com.codeborne.selenide.WebDriverRunner;

import pages.NavigationPage;
import pages.SearchGroupsPage;
import utils.SearchGroupsDataProvider;

public class MainTest {

    public static final String OK_RU = "https://ok.ru/";

    public static final String INCORRECT_LOGIN = "+1234567890";
    public static final String INCORRECT_PASS = "qwerty";

    @BeforeEach
    public void beforeAll() {
        Configuration.browser = "chrome";
    }

    @AfterEach
    public void afterEach() {
        Selenide.closeWindow();
    }

    @Test
    @DisplayName("Тестирование успешной аутентификации.")
    @Timeout(5000)
    public void correctLogin() {
        open(OK_RU);
        LoginPage loginPage = new LoginPage();
        loginPage
                .login()
                .getNameSign()
                .should(exist);
    }

    @Test
    @DisplayName("Тестирование некорректной аутентификации.")
    @Timeout(5000)
    public void incorrectLogin() {
        open(OK_RU);
        LoginPage loginPage = new LoginPage();
        loginPage
                .login(INCORRECT_LOGIN, INCORRECT_PASS)
                .getFailedLoginSign()
                .shouldHave(text(MainPage.ERROR_SIGN));
    }

    @Test
    @DisplayName("Тест навигации по боковому меню.")
    public void sideMenuNavigation() {
        open(OK_RU);
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        NavigationPage navigationPage = new NavigationPage();

        List<String> urls = new LinkedList<>();

        navigationPage.getPhotosTab().click();
        sleep(1000);
        urls.add(WebDriverRunner.getWebDriver().getCurrentUrl());

        navigationPage.getFriendsTab().click();
        sleep(1000);
        urls.add(WebDriverRunner.getWebDriver().getCurrentUrl());

        navigationPage.getGroupsTab().click();
        sleep(1000);
        urls.add(WebDriverRunner.getWebDriver().getCurrentUrl());

        assertAll("Нужно, чтобы было 3 ссылки и они содержали нужные части",
                () -> assertEquals(urls.size(), 3),
                () -> assertTrue(urls.get(0).contains("photos")),
                () -> assertTrue(urls.get(1).contains("friends")),
                () -> assertTrue(urls.get(2).contains("groups"))
        );
    }

    @ParameterizedTest
    @MethodSource("searchKeywordsProvider")
    public void testGroupSearch(String keyword) {
        open(OK_RU);
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
