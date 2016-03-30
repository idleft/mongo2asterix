package edu.mongo2asterix.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

/**
 * Created by Xikui on 3/28/16.
 */
public class MongoDBManager {

    public static MongoDBManager instance;
    public MongoClient mongoClient;

    public static MongoDBManager getInstance(){
        if(instance == null)
            instance = new MongoDBManager();
        return instance;
    }

    public void conn(String host, Integer port){
        mongoClient = new MongoClient(host, port);
    }

    public MongoDatabase getDB(String dbName){
        return mongoClient.getDatabase(dbName);
    }

}
