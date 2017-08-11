package com.globant.topicfour;

import java.io.IOException;

/**
 * Main class for perform sql scripts.
 * 
 * @author andres.vaninetti
 *
 */
public class EntryPointClass {	

	public static void main(String[] args) throws IOException {
		SingletonDBConnection singletonDBConnection =
				SingletonDBConnection.getInstance();

	}

}
