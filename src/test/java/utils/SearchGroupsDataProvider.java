package utils;

import java.util.stream.Stream;

public class SearchGroupsDataProvider {

    public static Stream<String> searchKeywords() {
        return Stream.of("Флеш игры", "Животные", "Машины");
    }
}
