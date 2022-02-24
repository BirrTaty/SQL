package netology.data;

import lombok.Value;

public class DBUser {
    private DBUser() {}

    @Value
    public static class User {
        private String login;
        private String password;
    }

    public static User getUser() {
        return new User("vasya", "qwerty123");
    }
}
