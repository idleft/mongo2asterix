import com.mongodb.Mongo;
import com.mongodb.client.MongoDatabase;
import edu.mongo2asterix.mongo.MongoDBManager;
import edu.mongo2asterix.sys.DBConfiguration;
import edu.mongo2asterix.sys.MongoCollection2AsterixDataset;
import org.junit.Test;

/**
 * Created by Xikui on 3/30/16.
 */
public class MongoDBTest {



    @Test
    public void mongoObjectExtractionTest(){
        MongoCollection2AsterixDataset mcad = MongoCollection2AsterixDataset.getInstance();
        DBConfiguration dbc = new DBConfiguration();
        MongoDBManager mdm = MongoDBManager.getInstance();
        mdm.conn("tippersweb.ics.uci.edu",27017,dbc.dbName,dbc.dbPass,"tippers");
        MongoDatabase mdb = mdm.getDB("tippers");
        mcad.testMongoType(mdb,"wifi_observations");
    }
}
