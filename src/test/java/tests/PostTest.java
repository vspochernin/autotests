package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import pages.LoginPage;
import pages.PostPage;
import utils.PostData;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class PostTest {

    @BeforeEach
    public void beforeAll() {
        Configuration.browser = "firefox";
    }

    @AfterEach
    public void afterEach() {
        Selenide.closeWindow();
    }

    @Test
    @DisplayName("Тест публикации поста.")
    public void postTest() {
        open(LoginPage.URL);

        LoginPage loginPage = new LoginPage();
        loginPage.login();

        sleep(1000);
        open(PostPage.URL);

        PostPage postPage = new PostPage();

        PostData postData = new PostData("Тестовый пост");

        postPage.createPost(new PostData("Тестовый пост"));

        String postText = postPage.getLastPostText().text();
        assertEquals(postText, postData.getText());
    }
}
