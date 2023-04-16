package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import pages.BasePage;
import pages.LoginPage;
import pages.PostPage;
import utils.PostData;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class PostTest extends BaseTest {

    @Test
    @DisplayName("Тест публикации поста.")
    public void postTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.login();

        sleep(1000);
        open(BasePage.POST_URL);

        PostPage postPage = new PostPage();

        PostData postData = new PostData("Тестовый пост");

        postPage.createPost(new PostData("Тестовый пост"));

        String postText = postPage.getLastPostText().text();
        assertEquals(postText, postData.getText());
    }
}
