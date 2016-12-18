/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restMongo;

import com.mongodb.DB;
import com.mongodb.MongoClient;

/**
 *
 * @author Abdallah
 */
public class MongoDBSingleton {
   private static MongoDBSingleton mDbSingleton;
  
    private static MongoClient mongoClient;
     
    private static DB db ;
  
  
    private static final String dbHost = "localhost";
    private static final int dbPort = 27017;
    private static final String dbName = "isitcom";
    

    private MongoDBSingleton(){}
  
    public static MongoDBSingleton getInstance(){
        if(mDbSingleton == null){
        mDbSingleton = new MongoDBSingleton();
    }
    return mDbSingleton;
    } 
  
    public DB getTestdb(){
    if(mongoClient == null){
        mongoClient = new MongoClient(dbHost , dbPort);
    }
    if(db == null)
   db = mongoClient.getDB(dbName);
    return db;
 }
} 

