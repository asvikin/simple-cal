package com.asvikin.Caculator;

public class App {
	public static void main(String args[]){
		String input="1,2";
		System.out.println(new App().Add(input));
	}
	
	
	int  Add(String numbers){
		if(numbers.length()==0)return 0;
		String stringNums[] = numbers.split(",");
		int nums[]= new int[stringNums.length];
		int sum=0;
		for(int i=0;i<nums.length;i++){
			nums[i]=Integer.parseInt(stringNums[i]);
			sum+=nums[i];
		}
		return sum;
	}
}
