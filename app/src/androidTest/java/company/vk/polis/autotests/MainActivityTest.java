package company.vk.polis.autotests;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest extends BaseTest {

    public static final String TEST_TEXT = "Test text";

    @Test
    public void testEditTextAndButtonInteractionUsingPageObject() {
        mainPage.enterText(TEST_TEXT)
                .clickButton()
                .checkTextViewText(TEST_TEXT);
    }

    @Test
    public void testButtonEnabledDisabled() {
        mainPage
                .checkButtonDisabled()
                .enterText(TEST_TEXT)
                .checkButtonEnabled()
                .enterText("")
                .checkButtonDisabled();
    }

}
