package com.globant.topicfive;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.QueryResults;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

import morphiaentities.Student;

public class Main {

	private static final String MORPHIAENTITIES = "morphiaentities";
	private static final String HIGH_SCHOOL = "high-school";

	public static void main(String args[]) {		

		String dbName = HIGH_SCHOOL;
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB(dbName);		
		DBCollection collection = db.getCollection("students");
		db.getCollection("students").drop();
		Set<String> collections = db.getCollectionNames();

		for (String collectionName : collections) {
			System.out.println(collectionName);
		}
		String json = "[{\"registrationNumber\": 1,\"firstName\": \"andres\",\"lastName\": \"vaninetti\",\"birthDate\": \"1986-12-18\",\"courses\": [{\"courseName\": \"programacion\",	\"hoursByWeek\": \"6\"},{\"courseName\": \"algoritmos\",\"hoursByWeek\": \"6\"}],\"note\": {\"firstNote\": 7,\"secondNote\": 8,\"thirdNote\": 10,\"finalNote\": 8}}]";		
		List<DBObject> dbObject = (List<DBObject>) JSON.parse(json);		
		collection.insert(dbObject.get(0));		
		
		/*DBCursor cursorDocJSON = collection.find();
		while (cursorDocJSON.hasNext()) {
			System.out.println(cursorDocJSON.next());
		}*/
		
		/*BasicDBObject query = new BasicDBObject();
		query.put("firstName", "andres");
		DBCursor cur = collection.find(query);
		while(cur.hasNext()) {
		    System.out.println(cur.next());
		}*/
		
		Morphia morphia = new Morphia();		
		Datastore dataStore = morphia.createDatastore(mongoClient,dbName);
		morphia.mapPackage(MORPHIAENTITIES);
		//dataStore.save(collection);	
		
		StudentDAO studentDao = new StudentDAO(mongoClient, morphia, HIGH_SCHOOL);		
		QueryResults<Student> results = studentDao.getStudents(dataStore, studentDao);		
		
		for (Student students:results) {
			System.out.println(students.getLastName());
		}		
		
	}
}