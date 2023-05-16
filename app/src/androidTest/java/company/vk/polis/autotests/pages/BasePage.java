package company.vk.polis.autotests.pages;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.NoMatchingViewException;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.isNotEnabled;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public abstract class BasePage {

    protected void typeTheText(ViewInteraction view, String text) {
        view.perform(typeText(text));
    }

    protected void clickView(ViewInteraction view) {
        view.perform(click());
    }

    protected void checkTextMatches(ViewInteraction view, String expectedText) {
        view.check(matches(withText(expectedText)));
    }

    protected void checkEnabled(ViewInteraction view) {
        view.check(matches(isEnabled()));
    }

    protected void checkDisabled(ViewInteraction view) {
        view.check(matches(isNotEnabled()));
    }

    public abstract void load();

    protected void assertLoaded(ViewInteraction view) {
        try {
            view.check(matches(isEnabled()));
        } catch (NoMatchingViewException e) {
            throw new AssertionError("Page not loaded: " + this.getClass().getName(), e);
        }
    }
}
