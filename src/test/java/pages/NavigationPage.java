package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NavigationPage {

    private static final By PHOTOS_TAB = By.xpath("//a[contains(@href, '/photos')]");
    private static final By FRIENDS_TAB = By.xpath("//a[contains(@href, '/friends')]");
    private static final By GROUPS_TAB = By.xpath("//a[contains(@href, '/groups')]");
    private static final By MUSIC_TAB_BUTTON = By.id("hook_Block_MusicToolbarButton");
    private static final By MUSIC_TAB = By.id("music_layer");
    
    public SelenideElement getPhotosTab() {
        return $(PHOTOS_TAB)
                .shouldBe(Condition.visible.because("Не найдена кнопка фотографий"));
    }

    public SelenideElement getFriendsTab() {
        return $(FRIENDS_TAB)
                .shouldBe(Condition.visible.because("Не найдена кнопка друзей"));
    }

    public SelenideElement getGroupsTab() {
        return $(GROUPS_TAB)
                .shouldBe(Condition.visible.because("Не найдена кнопка групп"));
    }

    public void openMusicTab() {
        $(MUSIC_TAB_BUTTON)
                .shouldBe(Condition.visible.because("Не найдена кнопка музыки"))
                .click();
    }

    public SelenideElement getMusicTab() {
        return $(MUSIC_TAB)
                .shouldBe(Condition.visible.because("Не найдена кнопка музыки"));
    }
}
