package edu.mongo2asterix.asterix;

import edu.mongo2asterix.sys.M2AConfig;
import org.bson.types.ObjectId;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Xikui on 3/30/16.
 */
public class AsterixDBHelper {

    //    public static AsterixDBHelper instance;
    Logger LOGGER = Logger.getLogger(AsterixDBHelper.class.getName());
    public String asterixHost;
    public Integer asterixPort;
    private String asterixURL;

    // Might not be necessary to use singleton
//    public static AsterixDBHelper getInstance(){
//        if(instance ==null)
//            instance = new AsterixDBHelper();
//        return instance;
//    }

    public AsterixDBHelper(String asterix_host, Integer asterix_port) {
        asterixHost = asterix_host;
        asterixPort = asterix_port;
        asterixURL = "http://" + asterixHost + ":" + String.valueOf(asterixPort);
    }

    public int putRequest(String requestType, String aql) {
        URL requestURL = null;
        HttpURLConnection conn = null;
        try {
            String requestStr = asterixURL + "/" +requestType+"?"+requestType+"=" + URLEncoder.encode(aql);
            requestURL = new URL(requestStr);
            System.out.println("Request URL: "+requestStr);
            conn = (HttpURLConnection) requestURL.openConnection();
            conn.setRequestMethod("GET");
//            conn.setRequestProperty(requestType, aql);
            conn.connect();
            LOGGER.log(Level.INFO,"Send request to asterix with response {0}",new Object[]{conn.getResponseMessage()});
            return conn.getResponseCode();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }


    public boolean createDataverse(String dvName) {
        String requestAQL = String.format("drop dataverse %s if exists; create dataverse %s", dvName, dvName);
        return putRequest("ddl", requestAQL) == 200;
    }

    public boolean createDataType(String dvName, String dtName, HashMap<String, String> dataTypes) {
        String aqlTemplate = "use dataverse %s; create type %s as open{ %s}";
        List<String> dataTypeList = new ArrayList();
        for (String attrName : dataTypes.keySet()) {
            String attrType = dataTypes.get(attrName);
            dataTypeList.add(attrName + ":" + attrType);
        }
        String requestAQL = String.format(aqlTemplate, dvName, dtName, String.join(",", dataTypeList));
        return putRequest("ddl", requestAQL) == 200;
    }

    public String castObjectToAsterixString(Object obj) {
        return "";
    }

    public void createDataSet(String dvName, String dsName, String dtName, String pkeyName) {
        String aqlTemplate = "use dataverse %s; create dataset %s(%s) primary key %s;";
        String requestAQL = String.format(aqlTemplate, dvName, dsName, dtName, pkeyName);
        putRequest("ddl", requestAQL);
    }

    public String castObjectToAsterixType(Object obj) {
        String typeStr = null;
        if (obj instanceof String) {
            typeStr = "string";
        } else if (obj instanceof Date) {
            typeStr = "datetime";
        } else if (obj instanceof Integer) {
            typeStr = "int32";
        } else if (obj instanceof ObjectId) {
            typeStr = "int32";
        } else
            typeStr = "null";
        return typeStr;
    }
}
