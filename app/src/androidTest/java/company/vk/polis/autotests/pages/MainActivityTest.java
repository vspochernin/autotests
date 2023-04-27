package company.vk.polis.autotests.pages;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import company.vk.polis.autotests.MainActivity;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    private MainPage mainPage;

    @Before
    public void setUp() {
        mainPage = new MainPage();
        mainPage.launchActivity(MainActivity.class);
    }

    @Test
    public void testEditTextAndButtonInteractionUsingPageObject() {
        String inputText = "Test text";
        mainPage.enterText(inputText)
                .clickButton()
                .checkTextViewText(inputText);
    }
}
