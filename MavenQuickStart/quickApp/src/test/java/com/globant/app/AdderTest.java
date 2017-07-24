package com.globant.app;

import org.junit.Ignore;
import org.junit.Test;

import junit.framework.Assert;

/**
 * Unit test for simple App.
 */
public class AdderTest {	
	
	@Test
	public void unitTestForAdder() {
		Assert.assertEquals("Expected result 7", 7, new Adder(3, 4).add());
	}
}
