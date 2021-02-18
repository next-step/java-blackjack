package blackjack.dto;

import java.util.Objects;

public class NameInfo {

    private final String name;

    public NameInfo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NameInfo nameInfo = (NameInfo) o;
        return Objects.equals(name, nameInfo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
