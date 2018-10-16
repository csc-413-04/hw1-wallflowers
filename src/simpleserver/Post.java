package simpleserver;

public class Post {
    private int userid;
    private int postid;
    private String postContent;

    protected Post(int userid, int postid, String postContent) {
        this.userid = userid;
        this.postid = postid;
        this.postContent = postContent;
    }

    public int getUserId() {
        return userid;
    }

    public int getPostID() {
        return postid;
    }

    public String getPostContent() {
        return postContent;
    }
}