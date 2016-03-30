package edu.mongo2asterix.asterix;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Xikui on 3/30/16.
 */
public class AsterixObj {

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public ArrayList<String> attrList;

    public AsterixObj() {
        attrList = new ArrayList();
    }

    public void appendAttr(String attrName, Object obj) {
        if (obj instanceof String) {
            attrList.add(String.format("\"%s\" : \"%s\"", attrName, (String) obj));
        } else if (obj instanceof Integer) {
            attrList.add(String.format("\"%s\" : int32(%d)", attrName, (Integer) obj));
        } else if (obj instanceof Date){
            attrList.add(String.format("\"%s\" : datetime(\"%s\")", attrName, sdf.format((Date)obj)));
        }
    }

}
