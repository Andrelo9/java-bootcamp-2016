package com.globant.topicone;

/**
 * This class returns the sum of two integers.
 * 
 * @author andres.vaninetti
 *
 */
public class Adder {
    
	private int a;
	private int b;
	
	public Adder (int x, int y) {
		this.a = x;
		this.b = y;
	}
	
	public int add() {
		return a + b;
	}	
	
}
