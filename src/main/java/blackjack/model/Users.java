package blackjack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private final List<User> users = new ArrayList<>();

    public Users(List<String> users) {
        for (String user : users) {
            this.users.add(new User(user));
        }
    }

    public List<User> getUser() {
        return users;
    }

    public List<String> getUserNames() {

        return users.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }
}
