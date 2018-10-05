package simpleserver;

public class Post {


    private int userID;
    private int postID;
    private String postData;


    public Post (int userID, int postID, String postData){
        this.userID = userID;
        this.postID = postID;
        this.postData = postData;
    }

    public int getUserID(){
        return userID;
    }

    public int getPostID(){
        return postID;
    }

    public String getPostData(){
        return postData;
    }

}