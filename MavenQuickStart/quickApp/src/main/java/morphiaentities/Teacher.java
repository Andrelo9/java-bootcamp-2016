package morphiaentities;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;

@Entity
public class Teacher extends BaseEntity {

	private String firstName;
	private String lastName;
	private String birthDate;

	@Embedded
	private List<Course> courses;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
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
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the birthDate
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate
	 *            the birthDate to set
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the courses
	 */
	public List<Course> getCourses() {
		return courses;
	}

	/**
	 * @param courses
	 *            the courses to set
	 */
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}
