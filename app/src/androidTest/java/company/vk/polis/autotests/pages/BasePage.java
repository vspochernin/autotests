package company.vk.polis.autotests.pages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.test.espresso.ViewInteraction;
import androidx.test.core.app.ActivityScenario;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;

public abstract class BasePage {

    protected void typeTheText(ViewInteraction view, String text) {
        view.perform(typeText(text));
    }

    protected void clickView(ViewInteraction view) {
        view.perform(click());
    }

    public <A extends AppCompatActivity> void launchActivity(Class<A> activityClass) {
        ActivityScenario.launch(activityClass);
    }
}
