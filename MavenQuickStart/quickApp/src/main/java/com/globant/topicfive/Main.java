package com.globant.topicfive;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.QueryResults;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

import morphiaentities.Course;

public class Main {

	private static final String MORPHIAENTITIES = "morphiaentities";
	private static final String HIGH_SCHOOL = "high-school";

	public static void main(String args[]) {		

		String dbName = new String(HIGH_SCHOOL);
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB(dbName);
		DBCollection collection = db.getCollection("courses");
		String json = "[{\"courseName\": \"programacion\",\"hoursByWeek\": \"6\"},{\"courseName\": \"algoritmos\",\"hoursByWeek\": \"6\"},{\"courseName\": \"diseño\",\"hoursByWeek\": \"6\"}]";
		List<DBObject> dbObject = (List<DBObject>) JSON.parse(json);
		collection.insert(dbObject);
		
		DBCursor cursorDocJSON = collection.find();
		while (cursorDocJSON.hasNext()) {
			System.out.println(cursorDocJSON.next());
		}
		
		Morphia morphia = new Morphia();
		Datastore dataStore = morphia.createDatastore(mongoClient,dbName);
		morphia.mapPackage(MORPHIAENTITIES);
		
		CourseDAO coursesDao = new CourseDAO(mongoClient, morphia, HIGH_SCHOOL);
		QueryResults<Course> results = coursesDao.getCourses(dataStore, coursesDao);		
		
		for (Course course:results) {
			System.out.println(course.getHoursByWeek());
		}
		
		
	}
}