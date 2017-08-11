package morphiaentities;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;

/**
 * This class represent a Student.
 * 
 * @author andres.vaninetti
 *
 */
@Entity
public class Student extends BaseEntity{
	
	private int registrationNumber;
	private String firstName;
	private String lastName;
	private String birthDate;
	
	@Embedded
	private List<Course> courses; 
	
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
	public List<Course> getCourses() {
		return courses;
	}

	/**
	 * @param courses2 the courses to set
	 */
	public void setCourses(List<Course> courses2) {
		this.courses = courses2;
	}

	/**
	 * @return the note
	 */
	public Note getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(Note note) {
		this.note = note;
	}

}
