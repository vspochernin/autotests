package utils;

import java.util.Date;

public class PostData {

    private static final String INTRO = "Всем привет! Сегодня " + new Date();

    private final String text;

    public PostData(String text) {
        this.text = text;
    }

    public String getText() {
        return INTRO + ". " + text;
    }
}
