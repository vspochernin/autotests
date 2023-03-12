import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private static final By NAME_SIGN = By.xpath("//*[@id=\"hook_Block_Navigation\"]/div/div/div[1]/a/div");
    private static final By LOGIN_ERROR = By.className("login_error");

    public SelenideElement getNameSign() {
        return $(NAME_SIGN);
    }

    public SelenideElement getFailedLoginSign() {
        return $(LOGIN_ERROR);
    }
}
