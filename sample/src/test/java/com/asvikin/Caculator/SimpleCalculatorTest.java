package com.asvikin.Caculator;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.runners.*;

import static org.junit.Assert.assertEquals;
@RunWith(
		MockitoJUnitRunner.class
)
public class SimpleCalculatorTest {
	@InjectMocks
	SimpleCalculator cal;
	@Test
	public void givenEmptyStringWhenAddThenReturn0(){
		String input="";
		int actual = cal.Add(input);
		assertEquals(0,actual);
	}
	@Test
	public void givenValidStringWhenAddThenReturnCrt(){
		String input = "5,6";
		int actual = cal.Add(input);
		assertEquals(11,actual);
	}
	@Test
	public void givenOneNumberWhenAddThenReturnresult(){
		String input = "6";
		int actual = cal.Add(input);
		assertEquals(6,actual);
	}
	@Test(expected = NumberFormatException.class)
	public void givenInvalidNumberThenThrowExpection(){
		String input="ure,9,0";
		int actual = cal.Add(input);
	}
	
	@Test
	public void givenNumberwithNewLineThenAccept(){
		String input = "3,6\n7";
		int actual = cal.Add(input);
		assertEquals(16,actual);
	}
	
	@Test
	public void givenNumberwithMulipleNewLineThenAccept(){
		String input = "3,6\n7\n";
		int actual = cal.Add(input);
		assertEquals(16,actual);
	}
	@Test
	public void givenNumberwithCoustemDelimiterLineThenAccept(){
		String input = "//;\n3;6;7;";
		int actual = cal.Add(input);
		assertEquals(16,actual);
	}
	@Test
	public void givenNumberwithCoustemDelimiterRegxThenAccept(){
		String input = "//.\n3.6.7.";
		int actual = cal.Add(input);
		assertEquals(16,actual);
	}
	@Test(expected = RuntimeException.class)
	public void givenNegativeNumberThenRiseExection(){
		String input = "//.\n3.6.-7.";
		int actual = cal.Add(input);
	}
	@Test
	public void givenNumberGreaterThan1000ThenIgnoreInResult(){
		String input = "//.\n3.6.1003.";
		int actual = cal.Add(input);
		assertEquals(9,actual);
	}
}
