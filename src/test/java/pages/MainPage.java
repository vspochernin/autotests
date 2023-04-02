package pages;

import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private static final By NAME_SIGN = By.xpath("//*[@aria-label=\"botS23AT19 botS23AT19\"]");
    private static final By LOGIN_ERROR = By.className("login_error");
    private static final By FIELD_EMAIL = By.id("field_email");
    private static final By FIELD_PASSWORD = By.id("field_password");

    private static final String LOGIN_ENV = "LOGIN";
    private static final String PASS_ENV = "PASS";

    public static final String ERROR_SIGN = "Неправильно указан логин и/или пароль";


    public SelenideElement getNameSign() {
        return $(NAME_SIGN);
    }

    public SelenideElement getFailedLoginSign() {
        return $(LOGIN_ERROR);
    }

    public MainPage login(String login, String password) {
        $(FIELD_EMAIL).setValue(login);
        $(FIELD_PASSWORD).setValue(password).pressEnter();
        return this;
    }

    public MainPage login() {
        return login(System.getenv(LOGIN_ENV), System.getenv(PASS_ENV));
    }
}
