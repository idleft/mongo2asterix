import edu.mongo2asterix.sys.DBConfiguration;
import edu.mongo2asterix.sys.M2AConfig;
import org.junit.Test;

/**
 * Created by Xikui on 3/31/16.
 */
public class DBConfigurationTest {

    @Test
    public void ConfigurationReaderTest(){
        M2AConfig mc = M2AConfig.getInstance();
//        DBConfiguration dbc = new DBConfiguration();
        System.out.println("Username : "+mc.mgUser+" Pass: "+mc.mgPass);
        assert(mc.mgName!=""&&mc.mgPass!="");
    }

}
