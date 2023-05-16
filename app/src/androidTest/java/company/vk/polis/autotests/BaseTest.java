package company.vk.polis.autotests;

import androidx.test.core.app.ActivityScenario;

import org.junit.Before;

import company.vk.polis.autotests.pages.MainPage;

public abstract class BaseTest {

    protected MainPage mainPage;

    @Before
    public void setUp() {
        mainPage = new MainPage();
        ActivityScenario.launch(MainActivity.class);
    }
}
