package com.globant.topictwo;

import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

/**
 * Class container of a battery test to prove the recent file list behavior.
 * 
 * @author andres.vaninetti
 *
 */
public class RecentFileListBehaviorTest {

	private static final String FILE_PATH = "C://Documents";
	private static final int MAX_LIST_CAPACITY = 15;

	/**
	 * This unit test is used to prove if the list is empty when we don't have
	 * any files in the list.
	 * 
	 */
	@Test
	public final void whenProgramIsRunForTheFirstTimeThenTheListIsEmptyTest() {
		FileList myFileList = new FileList();
		
		Assert.assertTrue(myFileList.getRecentFileList().isEmpty());
	}

	/**
	 * This unit test is used to prove if the file is closed by default.
	 * 
	 */
	@Test
	public final void givenANewFileThenIsClosedByDefault() {
		CustomFile customFile = new CustomFile("users", FILE_PATH);
		
		Assert.assertFalse(customFile.isFileOpen());
	}

	/**
	 * This unit test is used to prove if the file is opened correctly.
	 * 
	 */
	@Test
	public final void verifyifFileIsOpenTest() {
		CustomFile customFile = new CustomFile("users", FILE_PATH);
		customFile.openFile();
		
		Assert.assertTrue(customFile.isFileOpen());
	}

	/**
	 * This unit test is used to prove if the file close correctly.
	 * 
	 */
	@Test
	public final void verifyifFileIsClosedTest() {
		CustomFile customFile = new CustomFile("users", FILE_PATH);
		customFile.openFile();
		customFile.closeFile();
		
		Assert.assertFalse(customFile.isFileOpen());
	}

	/**
	 * This test prove if the LAST element of the list is removed when try to
	 * add an element on a complete list.
	 * 
	 * MAX_LIST_CAPACITY == 15
	 * 
	 */
	@Test
	public final void verifyifTheOldestFileOfTheListRemoveWhenIsFullTest() {
		FileList myFileList = new FileList();
		String path = FILE_PATH;
		populateMaxCapacityOfList(myFileList, path);
		CustomFile lastFile = myFileList.getRecentFileList().get(MAX_LIST_CAPACITY - 1);
		myFileList.addCustomFile(new CustomFile("File 16", path));
		List<CustomFile> fileListCopy = myFileList.getRecentFileList();
		boolean exist = false;
		for (CustomFile cf : fileListCopy) {
			if (cf.getFileName().equals(lastFile.getFileName())) {
				exist = true;
			}
		}

		Assert.assertFalse("The file is present at list", exist);

	}

	private void populateMaxCapacityOfList(FileList myFileList, String path) {
		for (int maxListCapacity = 0; maxListCapacity < MAX_LIST_CAPACITY; maxListCapacity++) {
			String filename = String.format("File %d", maxListCapacity);
			myFileList.addCustomFile(new CustomFile(filename, path));
		}
	}

}
