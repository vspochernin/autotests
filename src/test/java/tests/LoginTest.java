package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;


import pages.BasePage;
import pages.LoginPage;
import pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class LoginTest extends BaseTest {
    public static final String INCORRECT_LOGIN = "+1234567890";
    public static final String INCORRECT_PASS = "qwerty";

    @Test
    @DisplayName("Тестирование успешной аутентификации.")
    @Timeout(5000)
    public void correctLogin() {
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
