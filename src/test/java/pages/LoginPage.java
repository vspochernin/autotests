package pages;

import org.openqa.selenium.By;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private static final By FIELD_EMAIL = By.id("field_email");
    private static final By FIELD_PASSWORD = By.id("field_password");
    private static final String LOGIN_ENV = "LOGIN";
    private static final String PASS_ENV = "PASS";

    public MainPage login(String login, String password) {
        $(FIELD_EMAIL)
                .shouldBe(Condition.visible.because("Не найдено поле логина"))
                .setValue(login);
        $(FIELD_PASSWORD)
                .shouldBe(Condition.visible.because("Не найдено поле пароля"))
                .setValue(password)
                .pressEnter();
        return new MainPage();
    }

    public void checkCorrectLogin() {
        this
                .login()
                .getNameSign()
                .should(exist);
    }

    public MainPage login() {
        return login(System.getenv(LOGIN_ENV), System.getenv(PASS_ENV));
    }
}
