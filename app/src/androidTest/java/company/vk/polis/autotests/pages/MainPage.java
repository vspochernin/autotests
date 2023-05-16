package company.vk.polis.autotests.pages;

import androidx.test.espresso.ViewInteraction;

import company.vk.polis.autotests.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class MainPage extends BasePage {

    private final ViewInteraction editText = onView(withId(R.id.editText));
    private final ViewInteraction button = onView(withId(R.id.button));
    private final ViewInteraction textView = onView(withId(R.id.textView));

    public MainPage enterText(String text) {
        typeTheText(editText, text);
        return this;
    }

    public MainPage clickButton() {
        clickView(button);
        return this;
    }

    public MainPage checkTextViewText(String expectedText) {
        checkTextMatches(textView, expectedText);
        return this;
    }

    public MainPage checkButtonEnabled() {
        checkEnabled(button);
        return this;
    }

    public MainPage checkButtonDisabled() {
        checkDisabled(button);
        return this;
    }

    @Override
    public void load() {
        assertLoaded(editText);
        assertLoaded(button);
        assertLoaded(textView);
    }
}
