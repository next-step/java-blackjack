package blackJack.util;

import java.util.Arrays;
import java.util.List;

public class Util {

    public static boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static List<String> stringToStringList(String unrefinedString) {
        return Arrays.asList(unrefinedString.split(", "));
    }
}
