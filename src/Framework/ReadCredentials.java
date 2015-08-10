package Framework;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;

/**
 * Created by Marcelo Ferrufino on 8/10/2015.
 */
public class ReadCredentials {
    private String userName;
    private String password;

    public  ReadCredentials(){
        getCredentials();
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    private void getCredentials(){
        JSONParser parser = new JSONParser();
        try {
            String path = new File("src/Config/Credentials.json").getAbsolutePath();
            Object obj = parser.parse(new FileReader(path));

            JSONObject jsonObject = (JSONObject) obj;

            userName = (String) jsonObject.get("UserName");
            password = (String) jsonObject.get("Password");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
