import com.mongodb.client.MongoDatabase;
import edu.mongo2asterix.mongo.MongoDBManager;
import edu.mongo2asterix.sys.M2AConfig;
import edu.mongo2asterix.sys.Mongo2AsterixDataset;
import org.junit.Test;

/**
 * Created by Xikui on 3/30/16.
 */
public class MongoDBTest {

    M2AConfig mc = M2AConfig.getInstance();

    @Test
    public void mongoObjectExtractionTest(){
        Mongo2AsterixDataset mcad = Mongo2AsterixDataset.getInstance();
        MongoDBManager mdm = MongoDBManager.getInstance();
        mdm.conn("tippersweb.ics.uci.edu",27017,mc.mgUser,mc.mgPass,mc.mgName);
        MongoDatabase mdb = mdm.db;
        mcad.testMongoType(mdb,"wifi_observations");
    }
}
