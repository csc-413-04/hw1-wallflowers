package simpleserver;

import com.google.gson.*;
import java.io.*;
import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;

public class Database {
    User[] users = null;
    Post[] posts = null;
    protected static HashMap<String, User> userHashMap = new HashMap<>();
    protected static HashMap<String, Post> postsHashMap = new HashMap<>();

    public Database() throws FileNotFoundException, UnsupportedEncodingException {

        Gson gson = new Gson();
        BufferedReader br;
        br = new BufferedReader(new FileReader("./src/simpleserver/data.json"));
        JsonParser jsonParser = new JsonParser();
        JsonObject obj = jsonParser.parse(br).getAsJsonObject();

        users = gson.fromJson(obj.get("users"), User[].class);
        posts = gson.fromJson(obj.get("posts"), Post[].class);

        for (User u : users) {
            String UserIDString = Integer.toString(u.getUserID());
            userHashMap.put(UserIDString, u);
        }

        for (Post p : posts) {
            String PostIDString = Integer.toString(p.getPostID());
            postsHashMap.put(PostIDString, p);
        }
    }

    private static Post errorPost = new Post(-1, -1, "Error");
    private static User errorUser = new User(-1, "Error");
    static Collection<Post> postsCollection = postsHashMap.values();
    static ArrayList<Post> postsArrayList = new ArrayList<>(postsCollection);

    public User[] returnAllUsers() {
        return users;
    }


    public User getUserbyID(int UserID) {
        User user = errorUser;
        if (userHashMap.containsKey(Integer.toString(UserID))) {
            user = userHashMap.get(Integer.toString(UserID));
        }
        return user;
    }

    public Post getPostbyID(int postID) {
        Post post = errorPost;
        if (postsHashMap.containsKey(Integer.toString(postID))) {
            post = postsHashMap.get(Integer.toString(postID));
        }
        return post;
    }

    public Post getPostbyLength(int maxLength) {
        Post post = errorPost;
        for (Post testPost : postsArrayList) {
            char[] postContentArray = (testPost.getPostContent()).toCharArray();
            if (postContentArray.length < maxLength) {
                post = testPost;
                break;
            }
        }
        return post;
    }

}
