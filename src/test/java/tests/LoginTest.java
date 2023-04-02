package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import pages.LoginPage;
import pages.MainPage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
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
        open(LoginPage.URL);
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
        open(LoginPage.URL);
        LoginPage loginPage = new LoginPage();
        loginPage
                .login(INCORRECT_LOGIN, INCORRECT_PASS)
                .getFailedLoginSign()
                .shouldHave(text(MainPage.ERROR_SIGN));
    }
}
