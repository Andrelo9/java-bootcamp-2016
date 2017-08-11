package com.globant.topictwo;

/**
 * This class represent a basic behavior of a file.
 * 
 * @author andres.vaninetti
 *
 */
public class CustomFile {
	
	private String fileName;
	private String filePath;
	
	private boolean isOpen;
	
	public CustomFile(String name, String path) {
		this.setFileName(name);
		this.setFilePath(path);
		this.isOpen = false;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	/**
	 *  Returns the status of our file
	 * 
	 * @return isOpen
	 */
	public boolean isFileOpen() {
		return this.isOpen;
	}
	
	/**
	 * Used to open a file.
	 * 
	 */
	public void openFile() {
		if (!isOpen) {
			isOpen = true;
		}		
	}
	
	/**
	 * Used to close a file.
	 * 
	 */
	public void closeFile() {
		if (isOpen) {
			isOpen = false;
		}
	}
	
	

}
