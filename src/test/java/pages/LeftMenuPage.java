package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class LeftMenuPage {

    private static final By PHOTOS_TAB = By.xpath("//a[contains(@href, '/photos')]");
    private static final By FRIENDS_TAB = By.xpath("//a[contains(@href, '/friends')]");
    private static final By GROUPS_TAB = By.xpath("//a[contains(@href, '/groups')]");
    private static final By MUSIC_TAB_BUTTON = By.id("hook_Block_MusicToolbarButton");
    private static final By MUSIC_TAB = By.id("music_layer");
    
    public void goToPhotoAndCheckUrl() {
        $(PHOTOS_TAB)
                .shouldBe(Condition.visible.because("Не найдена кнопка фотографий"))
                .click();
        webdriver().shouldHave(urlContaining("photos"));
    }

    public void goToFriendsAndCheckUrl() {
        $(FRIENDS_TAB)
                .shouldBe(Condition.visible.because("Не найдена кнопка друзей"))
                .click();
        webdriver().shouldHave(urlContaining("friends"));
    }

    public void goToGroupsAndCheckUrl() {
        $(GROUPS_TAB)
                .shouldBe(Condition.visible.because("Не найдена кнопка групп"))
                .click();
        webdriver().shouldHave(urlContaining("groups"));
    }

    public void openMusicTabAndCheckUrl() {
        $(MUSIC_TAB_BUTTON)
                .shouldBe(Condition.visible.because("Не найдена кнопка музыки"))
                .click();
    }

    public void checkMusicTab() {
        SelenideElement musicTab = $(MUSIC_TAB)
                .shouldBe(Condition.visible.because("Не найдена кнопка музыки"));
        musicTab.should(Condition.exist);
    }
}
