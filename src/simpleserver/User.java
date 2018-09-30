package simpleserver;

public class User {

    private int userID;
    private String userName;

    public User(int userID, String userName){
        this.userID = userID;
        this.userName = userName;
    }

    public int getUserId(){
        return userID;
    }

    public String getUserName(){
        return userName;
    }
}
