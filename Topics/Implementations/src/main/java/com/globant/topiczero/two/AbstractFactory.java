package com.globant.topiczero.two;

import java.io.IOException;

/**
 * Abstract creator of specific DB connector.
 * 
 * @author andres.vaninetti
 *
 */
public abstract class AbstractFactory {

	public abstract SQLConnector create(SQLContracts sqlType) throws IOException;

}
