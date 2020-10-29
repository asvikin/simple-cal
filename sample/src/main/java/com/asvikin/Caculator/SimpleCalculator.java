package com.asvikin.Caculator;

import java.util.*;
import java.util.regex.*;

public class SimpleCalculator {
	int  Add(String numbers) throws NumberFormatException{
		if(numbers.length()==0)return 0;
		String stringNums[] = tokenize(numbers);
		System.out.println(Arrays.toString(stringNums)+stringNums.length);
		int nums[] = convertToInt(stringNums);
		return sumUp(nums);
	}
	
	private int sumUp(int[] nums) {
		int sum=0;
		for(int i=0;i<nums.length;i++){
			sum+=nums[i];
		}
		return sum;
	}
	
	private String[] tokenize(String text){
		if(text.startsWith("//")){
			Matcher match = Pattern.compile("//(.)\n(.*)").matcher(text);
			match.matches();
			String delimiter = match.group(1);
			String numbers = match.group(2);
			return numbers.split(delimiter);
		}
		return text.split("\n|,");
	}
	
	private int[] convertToInt(String[] stringNums) throws NumberFormatException {
		int res[] = new int[stringNums.length];
		for(int i=0;i<res.length;i++){
			res[i]=Integer.parseInt(stringNums[i]);
		}
		return res;
	}
}
