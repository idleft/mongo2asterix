package edu.mongo2asterix.asterix;

import java.util.HashMap;

/**
 * Created by Xikui on 3/30/16.
 */
public class AsterixDBHelper {

    public static AsterixDBHelper instance;

    public static AsterixDBHelper getInstance(){
        if(instance ==null)
            instance = new AsterixDBHelper();
        return instance;
    }

    public static void createDataverse(String dvName){

    }

    public static void createDataType(String dtName, HashMap<String, String> dataType){

    }

    public static void createDataSet(String dsName, String dtName){
        
    }

}
