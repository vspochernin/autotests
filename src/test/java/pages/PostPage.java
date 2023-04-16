package pages;

import org.openqa.selenium.By;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import utils.PostData;
import utils.TestConfig;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class PostPage {

    private final By POST_TEXTAREA = By.xpath("//div[@data-module=\"postingForm/mediaText\"]");
    private final By POST_BUTTON = By.xpath("//div[@data-l=\"t,button.submit\"]");
    private final String PROFILE_URL = "https://ok.ru/profile/" + TestConfig.BOT_ID;
    private final By POST = By.xpath("//div[@class=\"media-text_cnt_tx emoji-tx textWrap\"]");

    public void createPost(PostData postData) {
        $(POST_TEXTAREA)
                .shouldBe(Condition.visible.because("Не найдено поле ввода поста"))
                .setValue(postData.getText());
        $(POST_BUTTON)
                .shouldBe(Condition.visible.because("Не найдена кнопка создания поста"))
                .click();
    }

    public SelenideElement getLastPostText() {
        sleep(1000);
        open(PROFILE_URL);
        return $$(POST)
                .shouldBe(CollectionCondition.sizeGreaterThan(0).because("Пустой список постов"))
                .first();
    }
}
