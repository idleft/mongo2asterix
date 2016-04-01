package edu.mongo2asterix.sys;

import java.io.*;

/**
 * Created by Xikui on 3/31/16.
 */
public class DBConfiguration {


//    private M2AConfig m2AConfig = M2AConfig.getInstance();
    public String dbUser;
    public String dbPass;
    public String dbName;

    public DBConfiguration(String keyName){

        InputStream keyIS = this.getClass().getClassLoader().getResourceAsStream(keyName);
        BufferedReader keyBR = new BufferedReader(new InputStreamReader(keyIS));
        try {
            dbUser = keyBR.readLine().trim();
            dbPass = keyBR.readLine().trim();
            dbName = keyBR.readLine().trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
