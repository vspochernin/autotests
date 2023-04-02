package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class NavigationPage {

    private static final By PHOTOS_TAB = By.xpath("//a[contains(@href, '/photos')]");
    private static final By FRIENDS_TAB = By.xpath("//a[contains(@href, '/friends')]");
    private static final By GROUPS_TAB = By.xpath("//a[contains(@href, '/groups')]");
    
    public SelenideElement getPhotosTab() {
        return $(PHOTOS_TAB);
    }

    public SelenideElement getFriendsTab() {
        return $(FRIENDS_TAB);
    }

    public SelenideElement getGroupsTab() {
        return $(GROUPS_TAB);
    }
}
