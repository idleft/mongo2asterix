import com.mongodb.client.MongoCollection;
import edu.mongo2asterix.asterix.AsterixDatabase;
import edu.mongo2asterix.mongo.MongoDBManager;
import edu.mongo2asterix.sys.M2AConfig;
import org.bson.Document;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Created by Xikui on 3/31/16.
 */
public class AsterixDBTest {

    MongoDBManager mdm = MongoDBManager.getInstance();
    M2AConfig mc = M2AConfig.getInstance();
    AsterixDatabase ad = new AsterixDatabase(mc.mgName);

    public AsterixDBTest(){
        mdm.conn(mc.mongo_host, mc.mongo_port,mc.mgUser, mc.mgPass,mc.mgName);
    }

    @Test
    public void createDataverse(){
        assert (ad.createDataverse(mc.mgName) == true);
    }

    @Ignore
    public void createDatatype(){
        MongoCollection mgc = mdm.getCollection("wifi_observations");
        Document initDoc = (Document) mgc.find().limit(1).first();
        ad.createDataTypeFromMongoDocument("wifi_observatons_type",initDoc);
    }
}
