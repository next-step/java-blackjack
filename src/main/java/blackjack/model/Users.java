package blackjack.model;

import java.util.ArrayList;
import java.util.List;

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
}
