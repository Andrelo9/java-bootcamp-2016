package com.globant.topicfive;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;

import com.mongodb.MongoClient;

import morphiaentities.Course;

public class CourseDAO extends BasicDAO<Course, ObjectId> {

	public CourseDAO(MongoClient mongoClient, Morphia morphia, String dbName) {
		super(mongoClient, morphia, dbName);
	}

	public QueryResults<Course> getCourses(Datastore dataStore, CourseDAO coursesDao) {
		Query<Course> query = dataStore.createQuery(Course.class);
		query.criteria("courseName").equal("algoritmos");
		return coursesDao.find(query);
	}

}
