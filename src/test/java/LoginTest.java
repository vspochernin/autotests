import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pages.MainPage;

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
        MainPage loginPage = new MainPage();
        loginPage
                .login()
                .getNameSign()
                .shouldHave(text(MainPage.CORRECT_NAME));
    }

    @Test
    public void incorrectLogin() {
        open(OK_RU);
        MainPage loginPage = new MainPage();
        loginPage
                .login(INCORRECT_LOGIN, INCORRECT_PASS)
                .getFailedLoginSign()
                .shouldHave(text(MainPage.ERROR_SIGN));
    }
}
