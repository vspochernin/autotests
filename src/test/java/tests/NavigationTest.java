package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import pages.BasePage;
import pages.LoginPage;
import pages.LeftMenuPage;

import static com.codeborne.selenide.Selenide.open;

public class NavigationTest  extends BaseTest {

    @Test
    @DisplayName("Тест навигации по боковому меню.")
    public void sideMenuNavigation() {
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        LeftMenuPage leftMenuPage = new LeftMenuPage();

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
