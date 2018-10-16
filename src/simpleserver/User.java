package simpleserver;

public class User {
    private int userid;
    private String username;

    protected User(int userid, String username) {
        this.userid = userid;
        this.username = username;
    }

    public int getUserID() {
        return userid;
    }

    public String getUsername() {
        return username;
    }
}