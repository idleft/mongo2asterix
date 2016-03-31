package edu.mongo2asterix.asterix;

import edu.mongo2asterix.sys.M2AConfig;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Xikui on 3/30/16.
 */
public class AsterixDBHelper {

    //    public static AsterixDBHelper instance;
    public String asterixHost;
    public Integer asterixPort;
    private String asterixURL;

    // Might not be necessary to use singleton
//    public static AsterixDBHelper getInstance(){
//        if(instance ==null)
//            instance = new AsterixDBHelper();
//        return instance;
//    }

    public void AsterixDBHelper(String asterix_host, Integer asterix_port) {
        asterixHost = asterix_host;
        asterixPort = asterix_port;
        asterixURL = "http://" + asterixHost + ":" + String.valueOf(asterixPort);
    }

    public int putRequest(String requestType, String aql) {
        URL requestURL = null;
        HttpURLConnection conn = null;
        try {
            requestURL = new URL(asterixURL);
            conn = (HttpURLConnection) requestURL.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty(requestType, aql);
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


    public void createDataverse(String dvName) {
        String requestAQL = String.format("drop dataverse %s if exists; create dataverse %s", dvName, dvName);
        putRequest("ddl", requestAQL);
    }

    public void createDataType(String dvName, String dtName, HashMap<String, String> dataTypes) {
        String aqlTemplate = "use dataverse %s; create type %s as open{ %s}";
        List<String> dataTypeList = new ArrayList();
        for (String attrName : dataTypes.keySet()) {
            String attrType = dataTypes.get(attrName);
            dataTypeList.add(attrName + ":" + attrType);
        }
        String requestAQL = String.format(aqlTemplate, dvName, dtName, String.join(",", dataTypeList));
        putRequest("ddl", requestAQL);
    }

    public String castObjectToAsterixString(Object obj) {
        return "";
    }

    public void createDataSet(String dvName, String dsName, String dtName, String pkeyName) {
        String aqlTemplate = "use dataverse %s; create dataset %s(%s) primary key %s;";
        String requestAQL = String.format(aqlTemplate, dvName, dsName, dtName, pkeyName);
        putRequest("ddl", requestAQL);
    }

}
