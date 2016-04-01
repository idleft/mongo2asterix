package edu.mongo2asterix.mongo;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Xikui on 3/28/16.
 */
public class MongoDBManager {

    private static Logger LOGGER = Logger.getLogger(MongoDBManager.class.getName());

    public static MongoDBManager instance;
    public MongoClient mongoClient;
    private String dbName;
    public  MongoDatabase db;

    public static MongoDBManager getInstance(){
        if(instance == null)
            instance = new MongoDBManager();
        return instance;
    }

    public void conn(String host, Integer port){
        mongoClient = new MongoClient(host, port);
    }

    public void conn(String host, Integer port, String uname, String pass, String dbName){
        MongoCredential credential = MongoCredential.createCredential(uname,dbName,pass.toCharArray());
        LOGGER.log(Level.INFO,"Connect as |"+uname+"|"+pass+"|");
        mongoClient = new MongoClient(new ServerAddress(host,port), Arrays.asList(credential));
        this.dbName = dbName;
        this.db = mongoClient.getDatabase(dbName);
    }

    public MongoCollection getCollection(String collectionName){
        return this.db.getCollection(collectionName);
    }

}
