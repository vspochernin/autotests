package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private static final By NAME_SIGN = By.xpath("//*[@aria-label=\"botS23AT19 botS23AT19\"]");
    private static final By LOGIN_ERROR = By.className("login_error");

    public static final String ERROR_SIGN = "Неправильно указан логин и/или пароль";

    public SelenideElement getNameSign() {
        return $(NAME_SIGN)
                .shouldBe(Condition.visible.because("Не найдено поле имени"));
    }

    public SelenideElement getFailedLoginSign() {
        return $(LOGIN_ERROR)
                .shouldBe(Condition.visible.because("Не найдена надпись о некорректной аутентификации"));
    }
}
