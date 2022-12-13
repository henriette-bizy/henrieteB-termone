package com.learning.eveningClass.serviceImpl;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

public class MathOperatorImplTest {

	MathOperatorImpl service =  new MathOperatorImpl();
	
	@Test
	public void add_success() {
		assertEquals(12, service.doMath(6,6,"+"));
	}
	@Test
	public void subtract_success() {
		assertEquals(12, service.doMath(18,6,"-"));
	}
	@Test
	public void onPower_success() {
		assertEquals(8, service.doMath(2,3,"**"));
	}
	@Test
	public void divide_success() {
		assertEquals(1, service.doMath(6,6,"/"));
	}
	@Test
	public void multiply_success() {
		assertEquals(36, service.doMath(6,6,"*"));
	}

	public void subtract_zero() {
		assertEquals(6, service.doMath(6,0,"-"));
	}
	@Test
	public void subtract_failure() {
		assertNotEquals(6, service.doMath(12,0,"-"));
	}
}
