package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public static final String URL = "https://ok.ru/";

    private static final By FIELD_EMAIL = By.id("field_email");
    private static final By FIELD_PASSWORD = By.id("field_password");
    private static final String LOGIN_ENV = "LOGIN";
    private static final String PASS_ENV = "PASS";

    public MainPage login(String login, String password) {
        $(FIELD_EMAIL).setValue(login);
        $(FIELD_PASSWORD).setValue(password).pressEnter();
        return new MainPage();
    }

    public MainPage login() {
        return login(System.getenv(LOGIN_ENV), System.getenv(PASS_ENV));
    }
}
