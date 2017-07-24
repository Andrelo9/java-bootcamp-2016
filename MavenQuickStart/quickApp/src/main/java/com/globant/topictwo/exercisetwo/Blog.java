package com.globant.topictwo.exercisetwo;

import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * This class represents the features and behavior of our blog, and use Entry to
 * post new information.
 * 
 * @author andres.vaninetti
 *
 */
public class Blog {

	private static final int PAGINATION = 10;
	private static final Logger LOGGER = Logger.getLogger(Blog.class.getName());

	private String name;
	private String owner;
	private String theme;
	private List<Entry> entries;

	/**
	 * Deafult constructor.
	 * 
	 * @author andres.vaninetti
	 *
	 */
	public Blog() {

	}

	/**
	 * Class constructor with parameters.
	 * 
	 * @param name
	 * @param owner
	 * @param theme
	 * @param entries
	 */
	public Blog(String name, String owner, String theme, LinkedList<Entry> entries) {
		this.name = name;
		this.owner = owner;
		this.theme = theme;
		this.entries = entries;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner
	 *            the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the theme
	 */
	public String getTheme() {
		return theme;
	}

	/**
	 * @param theme
	 *            the theme to set
	 */
	public void setTheme(String theme) {
		this.theme = theme;
	}

	/**
	 * @return the entries
	 */
	public List<Entry> getEntries() {
		return entries;
	}

	/**
	 * @param entries
	 *            the entries to set
	 */
	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}

	/**
	 * This method is used to post a new entry in the blog.
	 * 
	 * @param myEntry
	 */
	public void post(Entry myEntry) {
		this.entries.add(myEntry);
	}

	/**
	 * Delete an entry from the blog
	 * 
	 * @param entryToDelete
	 */
	public void deleteEntry(Entry entryToDelete) {
		for (Entry entry : this.entries) {
			if (entry.getTitle().equals(entryToDelete.getTitle())) {
				entries.remove(entryToDelete);
			}
		}

	}

	/**
	 * Show the last 10 entries posted in the blog.
	 * 
	 */
	public void showEntries() {
		List<Entry> subList = this.getEntries().subList(this.getEntries().size() - PAGINATION, this.getEntries().size());
		for (Entry entry : subList) {
			LOGGER.debug(entry.getTitle());
		}

	}

}
