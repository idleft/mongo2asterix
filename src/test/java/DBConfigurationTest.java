import edu.mongo2asterix.sys.DBConfiguration;
import org.junit.Test;

/**
 * Created by Xikui on 3/31/16.
 */
public class DBConfigurationTest {

    @Test
    public void ConfigurationReaderTest(){
        DBConfiguration dbc = new DBConfiguration();
        System.out.println("Username : "+dbc.dbName+" Pass: "+dbc.dbPass);
        assert(dbc.dbPass!=""&&dbc.dbName!="");
    }

}
