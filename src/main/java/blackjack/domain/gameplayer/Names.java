package blackjack.domain.gameplayer;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Names {

    private static final String DUPLICATE_NAMES = "중복된 이름은 들어올 수 없습니다.";

    private final List<Name> names;

    public Names(final List<Name> names) {
        validateDuplicateNames(names);
        this.names = names;
    }

    private void validateDuplicateNames(List<Name> names) {
        final Set<Name> set = new HashSet<>(names);
        if (set.size() != names.size()) {
            throw new IllegalArgumentException(DUPLICATE_NAMES);
        }
    }

    public List<Name> getNames() {
        return Collections.unmodifiableList(names);
    }
}
