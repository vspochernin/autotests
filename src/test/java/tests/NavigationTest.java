package tests;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import pages.BasePage;
import pages.LoginPage;
import pages.LeftMenuPage;

import static com.codeborne.selenide.Selenide.open;
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

        leftMenuPage.goToPhotoAndCheckUrl();
        leftMenuPage.goToFriendsAndCheckUrl();
        leftMenuPage.goToGroupsAndCheckUrl();
    }

    @Test
    @DisplayName("Тест открытия окна с музыкой")
    public void openMusicTab() {
        open(BasePage.OK_URL);
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        LeftMenuPage leftMenuPage = new LeftMenuPage();
        leftMenuPage.openMusicTabAndCheckUrl();
        leftMenuPage.checkMusicTab();
    }
}
