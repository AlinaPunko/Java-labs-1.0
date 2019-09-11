public class User {
    String login;
    String password;
    String role;

    @Override
    public String toString() {
        return "User{" +
                "login=" + login +
                ", password=" + password +
                ", role=" + role +
                '}';
    }
}
