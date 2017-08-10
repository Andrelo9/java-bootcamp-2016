package morphiaentities;

import org.mongodb.morphia.annotations.Embedded;

/**
 * This class represent a course.
 * 
 * @author andres.vaninetti
 *
 */
@Embedded
public class Course {

	private String courseName;
	private int hoursByWeek;

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName
	 *            the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @return the hoursByWeek
	 */
	public int getHoursByWeek() {
		return hoursByWeek;
	}

	/**
	 * @param hoursByWeek
	 *            the hoursByWeek to set
	 */
	public void setHoursByWeek(int hoursByWeek) {
		this.hoursByWeek = hoursByWeek;
	}

}
