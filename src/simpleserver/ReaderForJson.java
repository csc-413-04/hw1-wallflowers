/*

package simpleserver;
        import com.google.gson.*;

        import java.io.FileReader;
        import java.io.BufferedReader;
        import java.net.URL;
        import java.util.ArrayList;
        import java.util.Map;
        import java.util.HashMap;

// This is a java class that reads the Json file
// Not complete


class ReadUser { //Class for users
    private  static Map<Integer, ReadUser> useridMap = new HashMap<>();
    private static ArrayList<ReadUser> allUsers = new ArrayList<ReadUser>();

    private  String userName;

    public void setUserName(String userName) {
        this.userName = userName;
        System.out.println(userName);
    }

    private  int userID;

    public void setUserid(int userID) {
        this.userID = userID;
        System.out.println(userID);
    }


    public ReadUser(){
        allUsers.add(this);
    }

    public ReadUser(String userName, int userID){
        this.userName = userName;
        this.userID = userID;
        allUsers.add(this);
        useridMap.put(userID, this);
    }

    public static ReadUser getUser(int userID){
        return useridMap.get(userID);
    }

    public void register(){
        useridMap.put(userID, this);
    }

    public static void loadAll(){
        for(int i = 0 ; i < allUsers.size(); i++){
            allUsers.get(i).register();
        }
    }
}

class ReadPosts {  //Reading the posts
    private static Map <Integer, ReadPosts> postMap = new HashMap<>();
    private static ArrayList<ReadPosts> allPosts = new ArrayList<>();

    private int postID;

    public void setPostID(int postID) {
        this.postID = postID;
        System.out.println(postID);
    }

    private int userID;
    public void setUserID(int userID) {
        this.userID = userID;
        System.out.println(userID);
    }

    private String data;
    public void setData(String data) {
        this.data = data;
        System.out.println(data);
    }

    public  ReadPosts () {
        allPosts.add(this);
    }

    public static ReadPosts getPost (int postID) {
        return postMap.get(postID);
    }
    public void register(){
        postMap.put(postID, this);
    }

    public static void loadAllPosts(){
        for (int i=0; i<allPosts.size(); i++) {
            allPosts.get(i).register();
        }
    }


}

public class ReaderForJson {
    private ReadUser[] users;
    private ReadPosts[] posts;

    private Gson gson;
    static ReaderForJson staticReaderForJson;

    static {
        try {
            staticReaderForJson = new ReaderForJson();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadAllData() throws Exception {

        Gson gson = new Gson();

        BufferedReader br = new BufferedReader(new FileReader("./src/simpleserver/data.json"));

        JsonParser jsonParser = new JsonParser();
        JsonObject asJsonObject = jsonParser.parse(br).getAsJsonObject();

        //
        users = gson.fromJson(asJsonObject.get("users"), ReadUser[].class);
        posts = gson.fromJson(asJsonObject.get("posts"), ReadPosts[].class);

        ReadUser.loadAll();
        ReadPosts.loadAllPosts();

    }

    ReaderForJson() throws Exception {
        gson = new Gson();
        this.loadAllData();
    }

    public String getUser(int userId) {
        return gson.toJson(ReadUser.getUser(userId));
    }

    public String getPost(int postId) {
        return gson.toJson(ReadPosts.getPost(postId));
    }

    public static void main(String[] args) throws Exception {

        //testing that the updates still retrieve the data
        System.out.println(ReaderForJson.staticReaderForJson.getUser(11));
        System.out.println(ReaderForJson.staticReaderForJson.getPost(15));

        //constructing a URL object for each of the endpoints
        URL user = new URL("http://localhost:1299/user");
        URL userWithId = new URL("http://localhost:1299/user?userid=7");
        URL postsWithId = new URL("http://localhost:1299/posts?postid=12");
        URL postsWithIdAndMaxLength = new URL("http://localhost:1299/posts?postid=11&maxlength=6");
        URL invalidPathRequest = new URL("http://localhost:1299/index.html");

    }
}

*/