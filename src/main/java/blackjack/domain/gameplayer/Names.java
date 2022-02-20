package blackjack.domain.gameplayer;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Names {

    private static final String DELIMITER = ",";
    private static final String DUPLICATE_NAMES = "중복된 이름은 들어올 수 없습니다.";

    private List<Name> names;

    public Names(final String input) {
        this(stringToNames(input));
    }

    public Names(final List<Name> names) {
        validateDuplicateNames(names);
        this.names = names;
    }

    private static List<Name> stringToNames(String input) {
        List<String> names = splitPlayerName(input);

        return names.stream()
            .map(Name::new)
            .collect(Collectors.toList());
    }

    private static List<String> splitPlayerName(String input) {
        String[] split = input.split(DELIMITER);
        return Arrays.stream(split)
            .map(String::trim)
            .filter(name -> !name.isEmpty())
            .collect(Collectors.toList());
    }

    private void validateDuplicateNames(final List<Name> names) {
        final Set<Name> set = new HashSet<>(names);
        if (set.size() != names.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAMES);
        }
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }
}
