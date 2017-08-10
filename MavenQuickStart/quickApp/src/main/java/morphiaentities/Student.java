package morphiaentities;

import java.util.ArrayList;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;

@Entity
public class Student extends BaseEntity{
	
	private int registrationNumber;
	private String firstName;
	private String lastName;
	private String birthDate;
	
	@Embedded
	private ArrayList<Course> courses; 
	
	@Embedded
	private Note note;
	
	
	/**
	 * @return the registrationNumber
	 */
	public int getRegistrationNumber() {
		return registrationNumber;
	}
	
	/**
	 * @param registrationNumber the registrationNumber to set
	 */
	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthDate;
	}
	
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthDate = birthday;
	}

	/**
	 * @return the courses
	 */
	public ArrayList<Course> getCourses() {
		return courses;
	}

	/**
	 * @param courses the courses to set
	 */
	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

}
