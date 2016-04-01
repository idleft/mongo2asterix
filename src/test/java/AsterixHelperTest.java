import edu.mongo2asterix.asterix.AsterixDBHelper;
import org.junit.Test;

/**
 * Created by Xikui on 3/31/16.
 */
public class AsterixHelperTest {

    @Test
    public void AsterixConnectionTest(){
        AsterixDBHelper adh = new AsterixDBHelper("localhost",19002);

        adh.putRequest("query","for $ds in dataset Metadata.Dataset return $ds;");
    }

}
