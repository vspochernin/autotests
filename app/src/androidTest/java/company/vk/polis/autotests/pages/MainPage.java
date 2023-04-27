package company.vk.polis.autotests.pages;

import androidx.test.espresso.ViewInteraction;

import company.vk.polis.autotests.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class MainPage extends BasePage {

    private ViewInteraction editText = onView(withId(R.id.editText));
    private ViewInteraction button = onView(withId(R.id.button));

    public MainPage enterText(String text) {
        typeTheText(editText, text);
        return this;
    }

    public MainPage clickButton() {
        clickView(button);
        return this;
    }

    private ViewInteraction textView = onView(withId(R.id.textView));

    public MainPage checkTextViewText(String expectedText) {
        textView.check(matches(withText(expectedText)));
        return this;
    }
}
