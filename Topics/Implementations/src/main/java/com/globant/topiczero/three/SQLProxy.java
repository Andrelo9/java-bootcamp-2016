package com.globant.topiczero.three;

import com.globant.topiczero.two.AbstractFactory;

/**
 * This proxy try to add five seconds of wait to connect to a DB.
 * 
 * @author andres.vaninetti
 *
 */
public class SQLProxy {

	private AbstractFactory abstractFactory;

	public SQLProxy(AbstractFactory factoryBuilder) {
		try {
			System.out.println("Your connection starts at 5 seconds");
			Thread.sleep(5000);
			this.abstractFactory = factoryBuilder;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns an abstract factory through a Proxy time.
	 * 
	 * @return AbstractFactory
	 */
	public AbstractFactory getFactoryBuilderProxy() {
		return this.abstractFactory;
	}
}
