package com.globant.topicfive;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.QueryResults;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

import morphiaentities.Course;
import morphiaentities.Note;
import morphiaentities.Student;

public class Main {

	private static final String MORPHIAENTITIES = "morphiaentities";
	private static final String HIGH_SCHOOL = "high-school";

	public static void main(String args[]) {		

		String dbName = HIGH_SCHOOL;
		MongoClient mongoClient = new MongoClient("localhost", 27017);
		DB db = mongoClient.getDB(dbName);		
		DBCollection collection = db.getCollection("students");
		/*db.getCollection("students").drop();
		Set<String> collections = db.getCollectionNames();

		for (String collectionName : collections) {
			System.out.println(collectionName);
		}
		/*String json = "[{\"registrationNumber\": 1,\"firstName\": \"andres\",\"lastName\": \"vaninetti\",\"birthDate\": \"1986-12-18\",\"courses\": [{\"courseName\": \"programacion\",	\"hoursByWeek\": \"6\"},{\"courseName\": \"algoritmos\",\"hoursByWeek\": \"6\"}],\"note\": {\"firstNote\": 7,\"secondNote\": 8,\"thirdNote\": 10,\"finalNote\": 8}}]";		
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
		
		Course algoritmos = new Course();
		algoritmos.setCourseName("algoritmos");
		algoritmos.setHoursByWeek(6);
		
		Course programacion = new Course();
		programacion.setCourseName("programacion");
		programacion.setHoursByWeek(6);
		
		List<Course> courses = new ArrayList();
		courses.add(programacion);
		courses.add(algoritmos);
		
		Note notesAndres = new Note();
		notesAndres.setFirstNote(7);
		notesAndres.setSecondNote(8);
		notesAndres.setThirdNote(10);
		notesAndres.setFinalNote(9);
		
		Student student1 = new Student();
		student1.setBirthday("1986-02-18");
		student1.setFirstName("andres");
		student1.setLastName("vaninetti");
		student1.setRegistrationNumber(1);
		student1.setNote(notesAndres);
		student1.setCourses(courses);
		
		Morphia morphia = new Morphia();		
		Datastore dataStore = morphia.createDatastore(mongoClient,dbName);
		morphia.mapPackage(MORPHIAENTITIES);
		dataStore.save(student1);	
		
		StudentDAO studentDao = new StudentDAO(mongoClient, morphia, HIGH_SCHOOL);		
		QueryResults<Student> results = studentDao.getStudentsByName(dataStore, studentDao);		
		
		for (Student students:results) {
			System.out.println(students.getLastName());
		}	
		
		
	}
}