package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import pages.BasePage;
import pages.LoginPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest {
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
        open(BasePage.OK_URL);
        LoginPage loginPage = new LoginPage();
        loginPage.checkCorrectLogin();
    }

    @Test
    @DisplayName("Тестирование некорректной аутентификации.")
    @Timeout(5000)
    public void incorrectLogin() {
        open(BasePage.OK_URL);
        LoginPage loginPage = new LoginPage();
        String actualErrorSign = loginPage
                .login(INCORRECT_LOGIN, INCORRECT_PASS)
                .getFailedLoginSign();
        Assertions.assertEquals(actualErrorSign, MainPage.ERROR_SIGN);
    }
}
