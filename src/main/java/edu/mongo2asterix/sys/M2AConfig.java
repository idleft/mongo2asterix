package edu.mongo2asterix.sys;

/**
 * Created by Xikui on 3/28/16.
 */
public class M2AConfig {

    public static M2AConfig instance;

    public String mongo_host;
    public Integer mongo_port;
    public String asterix_host;
    public Integer asterix_port;
    public String keyName;

    public static M2AConfig getInstance(){
        if(instance == null)
            instance = new M2AConfig();
        return instance;
    }

    public M2AConfig(){
        mongo_host = "localhost";
        mongo_port = 27017;

        asterix_host = "localhost";
        asterix_port = 190002;

        keyName = "dbpass.key";
    }
}
