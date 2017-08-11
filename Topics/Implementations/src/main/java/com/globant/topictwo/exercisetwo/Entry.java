package com.globant.topictwo.exercisetwo;

import java.util.Date;

/**
 * This class is used to model an entry, like a news, publication, etc.
 * 
 * @author andres.vaninetti
 *
 */
public class Entry {

	private String title;
	private String category;
	private String paragraph;
	private Date date;

	/**
	 * Default constructor.
	 * 
	 */
	public Entry() {

	}

	/**
	 * Constructor with parameters.
	 * 
	 * @param title
	 * @param category
	 * @param date
	 * @param paragraph
	 */
	public Entry(String title, String category, String paragraph, Date date) {
		this.title = title;
		this.category = category;
		this.date = date;
		this.paragraph = paragraph;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the paragraph
	 */
	public String getParagraph() {
		return paragraph;
	}

	/**
	 * @param paragraph
	 *            the paragraph to set
	 */
	public void setParagraph(String paragraph) {
		this.paragraph = paragraph;
	}

}
