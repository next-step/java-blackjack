package blackJack.util;

import java.util.Arrays;
import java.util.List;

public class Util {

    public static List<String> stringToStringList(String unrefinedString) {
        return Arrays.asList(unrefinedString.split(", "));
    }
}
