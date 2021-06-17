package blackjack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Users {
    private final List<User> users = new ArrayList<>();

    public void addUser(User user) {
        this.users.add(user);
    }

    public List<User> getUsers() {
        return this.users;
    }

    public List<String> getUserNames() {

        return this.users.stream()
                .map(User::getName)
                .collect(Collectors.toList());
    }
}
