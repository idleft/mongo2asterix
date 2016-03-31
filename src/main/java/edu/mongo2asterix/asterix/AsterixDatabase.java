package edu.mongo2asterix.asterix;

import edu.mongo2asterix.sys.M2AConfig;
import org.bson.Document;

import java.util.HashMap;

/**
 * Created by Xikui on 3/30/16.
 */
public class AsterixDatabase {

    private String dbName;
    private M2AConfig mc = M2AConfig.getInstance();
//    private AsterixDBHelper adh = new AsterixDBHelper(mc.asterix_host, mc.asterix_port);

    public AsterixDatabase(String dbName){
        this.dbName = dbName;
        AsterixDBHelper.InitAsterixDBHelper(mc.asterix_host, mc.asterix_port);
    }

    public void createDataverse(String dataverseName){
        AsterixDBHelper.createDataverse(dataverseName);
    }

    public void createDataTypeFromMongoDocument(String dtName, Document mgdoc){
        HashMap<String, String> asterixAttrMap = new HashMap();
        for (String key : mgdoc.keySet()){
            asterixAttrMap.put(key, AsterixDBHelper.castObjectToAsterixString(mgdoc.get(key)));
        }

    }
}
