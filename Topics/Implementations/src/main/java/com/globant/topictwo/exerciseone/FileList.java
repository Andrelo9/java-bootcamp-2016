package com.globant.topictwo.exerciseone;

import java.util.LinkedList;
import java.util.List;

/**
 * This class manage the function of recent file list behavior.
 * 
 * @author andres.vaninetti
 *
 */
public class FileList {
	
	private static final int MAX_LIST_CAPACITY = 15;
	private List<CustomFile> recentFileList;
	
	
	public FileList() {
		this.recentFileList = new LinkedList<CustomFile>();
		// LinkedList is faster than the other imp of list for
		// add and remove elements.
	}


	/**
	 * @return the recentFileList
	 */
	public List<CustomFile> getRecentFileList() {
		return recentFileList;
	}
	
	public void addCustomFile(CustomFile myFile) {
		if (this.recentFileList.size() < MAX_LIST_CAPACITY) {
		this.recentFileList.add(myFile);
		} else {
			recentFileList.remove(MAX_LIST_CAPACITY - 1);
			recentFileList.add(myFile);
		}
	}
	
}
