package blackJack.domain;

public class UserName {

    private final String userName;

    private UserName(String userName) {
        this.userName = userName;
    }

    public static UserName from(String userName) {
        return new UserName(userName);
    }

    public String getUserName() {
        return userName;
    }
}
