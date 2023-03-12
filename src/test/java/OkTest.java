import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class OkTest {

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
        open("https://ok.ru/", LoginPage.class)
                .login(System.getenv("LOGIN"), System.getenv("PASS"))
                .getNameSign()
                .shouldHave(text("Владислав Почернин"));
    }

    @Test
    public void incorrectLogin() {
        open("https://ok.ru/", LoginPage.class)
                .login("+1234567890", "qwerty")
                .getFailedLoginSign()
                .shouldHave(text("Неправильно указан логин и/или пароль"));
    }
}