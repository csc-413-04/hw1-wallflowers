//***NOT FINSHED***

package simpleserver;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Database {

    private static Database instance;
    private HashMap<String, User> userHashMap = new HashMap<>(); //<userID, User>
    private HashMap<String, Post> postHashMap = new HashMap<>(); //<postID, Post>

    public Database() throws FileNotFoundException, UnsupportedEncodingException {
        InputStream inputData = new FileInputStream("./data.json");
        JsonParser jParser = new JsonParser();
        JsonObject jObject = (JsonObject) jParser.parse(new InputStreamReader(inputData, "UTF-8"));
        JsonArray userArray = jObject.getAsJsonArray("users");
        JsonArray postArray = jObject.getAsJsonArray("posts");

        for (JsonElement user : userArray) {
            JsonObject jsonUser = user.getAsJsonObject();
            String userName = jsonUser.get("username").getAsString();
            int userID = jsonUser.get("userid").getAsInt();
            String xUserID = Integer.toString(userID);
            User xUser = new User(userID, userName);
            userHashMap.put(xUserID, xUser);

        }

        for (JsonElement post : postArray) {
            JsonObject jsonPost = post.getAsJsonObject();
            int userID = jsonPost.get("userid").getAsInt();
            int postID = jsonPost.get("postid").getAsInt();
            String postData = jsonPost.get("data").getAsString();
            String xPostID = Integer.toString(postID);
            Post xPost = new Post(userID, postID, postData);
            postHashMap.put(xPostID, xPost);
        }
    }


    public User getUser(String userId) {
        //returns desired user
        return userHashMap.get(userId);
    }

    public Post getPost(String postId) {
        // returns desired post
        return postHashMap.get(postId);
    }


    public Post getPostByLength(String postId, String length){
        //enter logic here
        return null;
    }

    public ArrayList<User> getAllUsers(){
        //enter logic here
        return null;
    }



}