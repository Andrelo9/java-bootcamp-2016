package com.globant.topicfive;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;

import com.mongodb.MongoClient;

import morphiaentities.Student;

/**
 * DAO Class to map query results of Students.
 * 
 * @author andres.vaninetti
 *
 */
public class StudentDAO extends BasicDAO<Student, String> {

	public StudentDAO(MongoClient mongoClient, Morphia morphia, String dbName) {
		super(mongoClient, morphia, dbName);
	}

	/**
	 * Return students who match with query.
	 * 
	 * @param dataStore
	 * @param studentDao
	 * @return
	 */
	public QueryResults<Student> getStudentsByName(Datastore dataStore, StudentDAO studentDao) {
		Query<Student> query = dataStore.createQuery(Student.class);
		query.field("firstName").equal("andres");
		return this.find(query);
	}
}
