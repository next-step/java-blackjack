package oilinjection.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import oilinjection.domain.vo.RentInfo;

public class Parser {

    private static final String RESERVATION_DELIMITER = ",";
    private static final String INFO_DELIMITER = ":";
    private static final int TYPE = 0;
    private static final int TRIP_DISTANCE = 1;
    private static final String INPUT_FORMAT_REGEX = "[a-zA-z0-9]+:[0-9]+";
    private static final String INVALID_FORMAT_EXCEPTION_MESSAGE = "[ERROR] 입력 형식이 맞지 않습니다(eg.${carType}:${tripDistance})";

    public static List<RentInfo> parse(final String input) {

        final String[] rentInfo = input.split(RESERVATION_DELIMITER);

        return Collections.unmodifiableList(
            Arrays.stream(rentInfo)
                .map(rent -> {
                    validateInfoFormat(rent);
                    final String[] split = rent.split(INFO_DELIMITER);
                    return new RentInfo(split[TYPE], Double.parseDouble(split[TRIP_DISTANCE]));
                })
                .collect(Collectors.toList()));
    }

    private static void validateInfoFormat(final String rent) {
        if (!rent.matches(INPUT_FORMAT_REGEX)) {
            throw new IllegalArgumentException(INVALID_FORMAT_EXCEPTION_MESSAGE);
        }
    }
}
