package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import pages.BasePage;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {


    @BeforeEach
    public void beforeEach() {
        Configuration.browser = "chrome";
        open(BasePage.OK_URL);
    }

    @AfterEach
    public void afterEach() {
        Selenide.closeWindow();
    }
}
