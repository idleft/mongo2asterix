package edu.mongo2asterix.sys;

import java.io.*;

/**
 * Created by Xikui on 3/31/16.
 */
public class DBConfiguration {


    private M2AConfig m2AConfig = M2AConfig.getInstance();
    public String dbName;
    public String dbPass;

    public DBConfiguration(){

        InputStream keyIS = this.getClass().getClassLoader().getResourceAsStream(m2AConfig.keyName);
        BufferedReader keyBR = new BufferedReader(new InputStreamReader(keyIS));
        try {
            dbName = keyBR.readLine().trim();
            dbPass = keyBR.readLine().trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
