package edu.mongo2asterix.asterix;

import edu.mongo2asterix.sys.M2AConfig;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.HashMap;

/**
 * Created by Xikui on 3/30/16.
 */
public class AsterixDatabase {

    private String dvName;
    private HashMap<String, String> primaryKeyMap;
    private M2AConfig mc = M2AConfig.getInstance();
    private AsterixDBHelper adh = new AsterixDBHelper(mc.asterix_host, mc.asterix_port);

    public AsterixDatabase(String dvName) {
        this.dvName = dvName;
        primaryKeyMap = new HashMap();

    }

    public boolean createDataverse(String dataverseName) {
        return adh.createDataverse(dataverseName);
    }

    public boolean createDataTypeFromMongoDocument(String dtName, Document mgdoc) {
        HashMap<String, String> asterixTypes = new HashMap();
        for (String key : mgdoc.keySet()) {
            asterixTypes.put(key, adh.castObjectToAsterixType(mgdoc.get(key)));
            if(mgdoc.get(key) instanceof ObjectId)
                primaryKeyMap.put(dtName,key);
        }
        return adh.createDataType(dvName, dtName, asterixTypes);
    }
}
