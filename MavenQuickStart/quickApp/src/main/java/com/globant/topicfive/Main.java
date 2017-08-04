package com.globant.topicfive;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class Main {

	public static void main(String args[]) {

		try {
			// To connect to mongodb server
			MongoClient mongoClient = new MongoClient("localhost", 27017);
			DB database = mongoClient.getDB("HighSchool");
			DBCollection coll = (DBCollection) database.getCollection("highSchoolCollection");		
			BasicDBObject doc = new BasicDBObject("student","MongoDB")
					.append("firstName", "Andres")
					.append("lastName", "Vaninetti");
			coll.insert(doc);
			DBCursor cursor = coll.find();
	         int i = 1;
				
	         while (cursor.hasNext()) { 
	            System.out.println("Inserted Document: "+i); 
	            System.out.println(cursor.next()); 
	            i++;
	         }
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
	}

}
