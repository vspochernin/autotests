package tests;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;

import pages.BasePage;
import pages.LoginPage;
import pages.LeftMenuPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NavigationTest {

    @BeforeEach
    public void beforeAll() {
        Configuration.browser = "chrome";
    }

    @AfterEach
    public void afterEach() {
        Selenide.closeWindow();
    }

    @Test
    @DisplayName("Тест навигации по боковому меню.")
    public void sideMenuNavigation() {
        open(BasePage.OK_URL);
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        LeftMenuPage leftMenuPage = new LeftMenuPage();

        List<String> urls = new LinkedList<>();

        leftMenuPage.getPhotosTab().click();
        sleep(1000);
        urls.add(WebDriverRunner.getWebDriver().getCurrentUrl());

        leftMenuPage.getFriendsTab().click();
        sleep(1000);
        urls.add(WebDriverRunner.getWebDriver().getCurrentUrl());

        leftMenuPage.getGroupsTab().click();
        sleep(1000);
        urls.add(WebDriverRunner.getWebDriver().getCurrentUrl());

        assertAll("Нужно, чтобы было 3 ссылки и они содержали нужные части",
                () -> assertEquals(urls.size(), 3),
                () -> assertTrue(urls.get(0).contains("photos")),
                () -> assertTrue(urls.get(1).contains("friends")),
                () -> assertTrue(urls.get(2).contains("groups"))
        );
    }

    @Test
    @DisplayName("Тест открытия окна с музыкой")
    public void openMusicTab() {
        open(BasePage.OK_URL);
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        LeftMenuPage leftMenuPage = new LeftMenuPage();
        leftMenuPage.openMusicTab();
        leftMenuPage.checkMusicTab();
    }
}
