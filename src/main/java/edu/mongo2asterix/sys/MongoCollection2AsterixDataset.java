package edu.mongo2asterix.sys;

import com.mongodb.Mongo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.mongo2asterix.asterix.AsterixDatabase;
import org.bson.Document;

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
        // for record in mdb tablename insert into adb
        MongoCollection<Document> mongoCollection = mdb.getCollection(tableName);
        for (Document doc : mongoCollection.find()){
            AsterixObj aobj = new AsterixObj();
            for (String attrName : doc.keySet()){
                Object keyObj = doc.get(attrName);
                if(keyObj instanceof String){

                }
            }
        }
    }

}
