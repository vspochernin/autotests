import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    private static final By FIELD_EMAIL = By.id("field_email");
    private static final By FIELD_PASSWORD = By.id("field_password");

    public MainPage login(String login, String password) {
        $(FIELD_EMAIL).setValue(login);
        $(FIELD_PASSWORD).setValue(password).pressEnter();
        return page(MainPage.class);
    }
}
