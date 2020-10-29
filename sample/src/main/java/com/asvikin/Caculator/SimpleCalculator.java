package com.asvikin.Caculator;

import java.util.*;
import java.util.regex.*;


public class SimpleCalculator {
	int  Add(String numbers) throws NumberFormatException{
		if(numbers.length()==0)return 0;
		String stringNums[] = tokenize(numbers);
		System.out.println(Arrays.toString(stringNums)+stringNums.length);
		int nums[] = convertToInt(stringNums);
		List<Integer> negativeNums = getAllNeagtive(nums);
		if(negativeNums.size()!=0)throw new RuntimeException("Input Contiains Negative numbers"+negativeNums);
		return sumUp(nums);
	}
	
	private List<Integer> getAllNeagtive(int[] nums) {
		List<Integer> res = new ArrayList<Integer>();
		for(int i:nums)
			if(i<0)res.add(i);
		return res;
	}
	
	private int sumUp(int[] nums) {
		int sum=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]<1001)
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
			return numbers.split(Pattern.quote(delimiter));
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
