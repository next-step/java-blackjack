package blackjack.dto;

import java.util.Objects;

public class NameInfo {

    private final String personName;

    public NameInfo(final String personName) {
        this.personName = personName;
    }

    public String getPersonName() {
        return personName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NameInfo nameInfo = (NameInfo) o;
        return Objects.equals(personName, nameInfo.personName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personName);
    }
}
