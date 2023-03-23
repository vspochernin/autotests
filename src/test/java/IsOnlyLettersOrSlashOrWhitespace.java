import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsOnlyLettersOrSlashOrWhitespace extends TypeSafeMatcher<String> {

    public static Matcher<String> onlyLettersOrSlashOrWhitespace() {
        return new IsOnlyLettersOrSlashOrWhitespace();
    }

    @Override
    protected boolean matchesSafely(String item) {
        for (char ch : item.toCharArray()) {
            if (!Character.isLetter(ch) && !(ch == '/') && ! Character.isWhitespace(ch)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("only letters");
    }
}
