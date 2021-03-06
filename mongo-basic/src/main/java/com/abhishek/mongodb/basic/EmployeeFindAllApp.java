package com.abhishek.mongodb.basic;

import com.abhishek.mongodb.constant.MongoConstant;
import com.abhishek.mongodb.constant.MongoUtil;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Created by Abhishek on 4/22/2016.
 */
public class EmployeeFindAllApp {
    public static void main(String arg[]){

        MongoClient mongo = new MongoClient(MongoConstant.DB_HOST, MongoConstant.DB_PORT);

        MongoDatabase mongoDatabase = mongo.getDatabase("testdb");

        MongoCollection<Document> employeeCollection = mongoDatabase.getCollection("employee");

        System.out.println("Finding all employees");
        FindIterable<Document> allEmployee = employeeCollection.find();
        MongoUtil.printFindIterableDocuments(allEmployee);
        mongo.close();
    }

}
