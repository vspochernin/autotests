package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    private static final By NAME_SIGN = By.xpath("//*[@id=\"hook_Block_Navigation\"]/div/div/div[1]/a/div");
    private static final By LOGIN_ERROR = By.className("login_error");
    public static final String ERROR_SIGN = "Неправильно указан логин и/или пароль";
    public static final String CORRECT_NAME = "Владислав Почернин";
    private static final By FIELD_EMAIL = By.id("field_email");
    private static final By FIELD_PASSWORD = By.id("field_password");
    public static final String LOGIN_ENV = "LOGIN";
    public static final String PASS_ENV = "PASS";

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
