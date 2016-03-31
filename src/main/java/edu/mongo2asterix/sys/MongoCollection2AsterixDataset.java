package edu.mongo2asterix.sys;

import com.mongodb.Mongo;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import edu.mongo2asterix.asterix.AsterixDatabase;
import edu.mongo2asterix.asterix.AsterixObj;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Xikui on 3/30/16.
 */
public class MongoCollection2AsterixDataset {

    public static MongoCollection2AsterixDataset instance;

    public static MongoCollection2AsterixDataset getInstance(){
        if(instance == null)
            instance = new MongoCollection2AsterixDataset();
        return instance;
    }

    public void testMongoType(MongoDatabase mdb, String tableName){
        MongoCollection<Document> mongoCollection = mdb.getCollection(tableName);
        for (Document doc : mongoCollection.find()){
            for (String attrName : doc.keySet()){
                System.out.println("Attr  "+attrName);
                Object docObj = doc.get(attrName);
                if(docObj instanceof String){
                    System.out.println("Is a string  "+docObj);
                }else if(docObj instanceof Date){
                    System.out.println("Is a date    "+ new SimpleDateFormat("yyyy-MM-dd").format(docObj));
                }else if (docObj instanceof Integer){
                    System.out.println("Is a Integer  "+docObj);
                }else if (docObj instanceof ObjectId){
                    ObjectId objId = (ObjectId)docObj;
                    System.out.println("Is a objId "+ objId);
                }
            }
            break;
        }
    }

    public void transfer(MongoDatabase mdb, AsterixDatabase adb, String tableName){
        // for record in mdb tablename insert into adb
        MongoCollection<Document> mongoCollection = mdb.getCollection(tableName);
        for (Document doc : mongoCollection.find()){
            AsterixObj aobj = new AsterixObj();
            for (String attrName : doc.keySet()){
               aobj.appendAttr(attrName, doc.get(attrName));
            }
        }
    }

}
