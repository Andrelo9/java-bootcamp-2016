package com.globant.topiczero.two;

/**
 * Enum class contains DB's used.
 * 
 * @author andres.vaninetti
 *
 */
public enum DataBases {
	SQL("sql"),
	ORACLE("oracle");
	
	private final String value;
	
	private DataBases (String db) {
		this.value = db;
	}
	
	public String getDataBase() {
		return this.value;
	}
}
