package com.asvikin.Caculator;

import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.runners.*;

import static org.junit.Assert.assertEquals;

@RunWith(
		MockitoJUnitRunner.class
)
public class AppTest {
	@InjectMocks
	App app;
	@Test
	public void givenEmptyStringWhenAddThenReturn0(){
		String input="";
		int actual = app.Add(input);
		assertEquals(0,actual);
	}
	@Test
	public void givenValidStringWhenAddThenReturnCrt(){
		String input = "5,6";
		int actual = app.Add(input);
		assertEquals(11,actual);
	}
}
