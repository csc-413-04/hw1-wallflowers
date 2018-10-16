package simpleserver;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class UserProcessor extends Processor {

    public UserProcessor() {
        try {
            db = new Database();

        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String process(String[] ep) {
        UserResponse ur = new UserResponse(db, ep);
        return ur.response();
    }


}
