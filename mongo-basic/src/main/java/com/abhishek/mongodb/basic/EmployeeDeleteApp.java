package com.abhishek.mongodb.basic;

import com.abhishek.mongodb.constant.MongoConstant;
import com.abhishek.mongodb.constant.MongoUtil;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * Created by Abhishek on 4/17/2016.
 */
public class EmployeeDeleteApp {

    public static void main(String arg[]){
        MongoClient mongo = new MongoClient(MongoConstant.DB_HOST, MongoConstant.DB_PORT);

        MongoDatabase mongoDatabase = mongo.getDatabase("testdb");

        MongoCollection<Document> employeeCollection = mongoDatabase.getCollection("employee");

        MongoUtil.printFindIterableDocuments(employeeCollection.find());

        System.out.println("Deleting document by First Name");
        DeleteResult deleteResult = employeeCollection.deleteOne(new Document("_id", new ObjectId("571a3e0422a4791c747f72cd")));
        System.out.println("Total Delete documents:"+deleteResult.getDeletedCount());

        MongoUtil.printFindIterableDocuments(employeeCollection.find());

        mongo.close();


    }


}
