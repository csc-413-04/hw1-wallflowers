package simpleserver;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.HashMap;

public class Database {

    private HashMap<Integer, User> userHashMap = new HashMap<>(); //<username, user>
    private HashMap<Integer, Post> postHashMap = new HashMap<>();

    public Database() throws FileNotFoundException, UnsupportedEncodingException {
        InputStream inputData = new FileInputStream("./data.json");
        JsonParser jParser = new JsonParser();
        JsonObject jObject = (JsonObject) jParser.parse(new InputStreamReader(inputData, "UTF-8"));
        JsonArray userArray = jObject.getAsJsonArray("users");
        JsonArray postArray = jObject.getAsJsonArray("posts");

        for(JsonElement user : userArray){
            JsonObject jsonUser = user.getAsJsonObject();
            String userName = jsonUser.get("username").getAsString();
            int userID = jsonUser.get("userid").getAsInt();
            User xUser = new User(userID, userName);
            userHashMap.put(userID, xUser);


        }

        for(JsonElement post : postArray){
            JsonObject jsonPost = post.getAsJsonObject();
            int userID = jsonPost.get("userid").getAsInt();
            int postID = jsonPost.get("data").getAsInt();
            String postData = jsonPost.get("data").getAsString();
            Post xPost = new Post(userID, postID, postData);
            postHashMap.put(postID, xPost);
        }
    }


    public User getUser(int userID){
        return userHashMap.get(userID);
    }




}