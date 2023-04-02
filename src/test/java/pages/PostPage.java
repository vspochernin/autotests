package pages;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import utils.PostData;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class PostPage {

    public static final String URL = "https://ok.ru/post";

    private final By POST_TEXTAREA = By.xpath("//div[@data-module=\"postingForm/mediaText\"]");
    private final By POST_BUTTON = By.xpath("//div[@data-l=\"t,button.submit\"]");
    private final String PROFILE_URL = "https://ok.ru/profile/573415014134";
    private final By POST = By.xpath("//div[@class=\"media-text_cnt_tx emoji-tx textWrap\"]");

    public void createPost(PostData postData) {
        SelenideElement postTextarea = $(POST_TEXTAREA);
        postTextarea.setValue(postData.getText());
        sleep(1000);
        $(POST_BUTTON).click();
    }

    public SelenideElement getLastPostText() {
        sleep(1000);
        open(PROFILE_URL);
        return $$(POST).first();
    }
}
