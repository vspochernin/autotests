import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class OkTest {

    public static final String OK_RU = "https://ok.ru/";
    public static final String LOGIN_ENV = "LOGIN";
    public static final String PASS_ENV = "PASS";
    public static final String CORRECT_NAME = "botS23AT19 botS23AT19";
    public static final String INCORRECT_LOGIN = "+1234567890";
    public static final String INCORRECT_PASS = "qwerty";
    public static final String ERROR_SIGN = "Неправильно указан логин и/или пароль";

    @BeforeAll
    public static void beforeAll() {
        Configuration.browser = "chrome";
    }

    @AfterEach
    public void afterEach() {
        Selenide.closeWindow();
    }

    @Test
    public void correctLogin() {
        String name = open(OK_RU, LoginPage.class)
                .login(System.getenv(LOGIN_ENV), System.getenv(PASS_ENV))
                .getNameSign().getText();
        assertThat(name, equalTo(CORRECT_NAME));
    }

    @Test
    public void incorrectLogin() {
        open(OK_RU, LoginPage.class)
                .login(INCORRECT_LOGIN, INCORRECT_PASS)
                .getFailedLoginSign()
                .shouldHave(text(ERROR_SIGN));
    }
}
