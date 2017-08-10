package morphiaentities;

import org.mongodb.morphia.annotations.Embedded;

/**
 * This class represent a Note.
 * 
 * @author andres.vaninetti
 *
 */
@Embedded
public class Note {
	
	private int firstNote;
	private int secondNote;
	private int thirdNote;
	private int finalNote;
	
	
	/**
	 * @return the firstNote
	 */
	public int getFirstNote() {
		return firstNote;
	}
	
	/**
	 * @param firstNote the firstNote to set
	 */
	public void setFirstNote(int firstNote) {
		this.firstNote = firstNote;
	}

	/**
	 * @return the secondNote
	 */
	public int getSecondNote() {
		return secondNote;
	}

	/**
	 * @param secondNote the secondNote to set
	 */
	public void setSecondNote(int secondNote) {
		this.secondNote = secondNote;
	}

	/**
	 * @return the thirdNote
	 */
	public int getThirdNote() {
		return thirdNote;
	}

	/**
	 * @param thirdNote the thirdNote to set
	 */
	public void setThirdNote(int thirdNote) {
		this.thirdNote = thirdNote;
	}

	/**
	 * @return the finalNote
	 */
	public int getFinalNote() {
		return finalNote;
	}

	/**
	 * @param finalNote the finalNote to set
	 */
	public void setFinalNote(int finalNote) {
		this.finalNote = finalNote;
	}

}
