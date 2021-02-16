package blackjack.dto;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PlayersInfo {
    private final List<PersonInfo> playersInfo;

    public PlayersInfo(List<PersonInfo> playersInfo) {
        this.playersInfo = playersInfo;
    }

    public List<PersonInfo> getPeopleInfo() {
        return playersInfo;
    }

    public List<NameInfo> getNameInfo() {
        return playersInfo.stream().map(PersonInfo::getNameInfo).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayersInfo that = (PlayersInfo) o;
        return Objects.equals(playersInfo, that.playersInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playersInfo);
    }
}
