import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pages.MainPage;
import pages.LoginPage;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest {

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
    public void correctLogin() {
        open(OK_RU);
        LoginPage loginPage = new LoginPage();
        loginPage
                .login()
                .getNameSign()
                .should(exist);
    }

    @Test
    public void incorrectLogin() {
        open(OK_RU);
        LoginPage loginPage = new LoginPage();
        loginPage
                .login(INCORRECT_LOGIN, INCORRECT_PASS)
                .getFailedLoginSign()
                .shouldHave(text(MainPage.ERROR_SIGN));
    }
}
