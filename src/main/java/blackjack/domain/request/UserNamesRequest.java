package blackjack.domain.request;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserNamesRequest {

    private static final String USER_NAME_DELIMITER = ",";

    private final List<String> userNames;

    private UserNamesRequest(List<String> userNames) {
        this.userNames = userNames;
    }

    public static UserNamesRequest from(String userNames) {
        validateUserNames(userNames);
        List<String> splitUserNames = Arrays.stream(userNames.split(USER_NAME_DELIMITER))
            .map(String::trim)
            .collect(Collectors.toList());
        validateDuplicate(splitUserNames);
        return new UserNamesRequest(splitUserNames);
    }

    public List<String> userNames() {
        return Collections.unmodifiableList(userNames);
    }

    private static void validateUserNames(String userNames) {
        if (userNames == null || userNames.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 이름을 입력해 주세요");
        }
    }

    private static void validateDuplicate(List<String> splitUserNames) {
        Set<String> removeDuplicate = new HashSet<>(splitUserNames);
        if (removeDuplicate.size() != splitUserNames.size()) {
            throw new IllegalArgumentException("[ERROR] 플레이어 이름은 중복될 수 없습니다");
        }
    }
}
