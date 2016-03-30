package edu.mongo2asterix.sys;

import com.mongodb.Mongo;
import com.mongodb.client.MongoDatabase;

/**
 * Created by Xikui on 3/30/16.
 */
public class MongoCollection2AsterixDataset {

    public static MongoCollection2AsterixDataset instance;

    public MongoCollection2AsterixDataset getInstance(){
        if(instance == null)
            instance = new MongoCollection2AsterixDataset();
        return instance;
    }

    public void transfer(MongoDatabase mdb, AsterixDatabase adb, String tableName){

    }

}
