package com.asvikin.Caculator;

import java.util.*;

public class SimpleCalculator {
	int  Add(String numbers) throws NumberFormatException{
		if(numbers.length()==0)return 0;
		if(!numbers.contains(",")){
			return Integer.parseInt(numbers);
		}
		String stringNums[] = numbers.split("\n|,");
		System.out.println(Arrays.toString(stringNums)+stringNums.length);
		int nums[] = convertToInt(stringNums);
		int sum=0;
		for(int i=0;i<nums.length;i++){
			sum+=nums[i];
		}
		return sum;
	}
	
	private int[] convertToInt(String[] stringNums) throws NumberFormatException {
		int res[] = new int[stringNums.length];
		for(int i=0;i<res.length;i++){
			res[i]=Integer.parseInt(stringNums[i]);
		}
		return res;
	}
}
