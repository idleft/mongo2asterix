package edu.mongo2asterix.sys;

import edu.mongo2asterix.mongo.MongoDBManager;

/**
 * Created by Xikui on 3/28/16.
 */
public class Main {

    static M2AConfig mc = M2AConfig.getInstance();

    public static void main(String args[]){
        // connect to mongodb
        MongoDBManager mdbm = MongoDBManager.getInstance();
        mdbm.conn(mc.mongo_host, mc.mongo_port);
        // connect to asterix

        // start new thread to port data in mongo to asterix

    }
}
