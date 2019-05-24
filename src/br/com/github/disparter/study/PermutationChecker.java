package br.com.github.disparter.study;

import java.util.Arrays;

public class PermutationChecker {

	public static Boolean isPermutation(String s1, String s2) {
		if(s1.length() != s2.length()) {
			return Boolean.FALSE;
		}
		
		char[] sortedS1 = s1.toCharArray(); 
		Arrays.sort(sortedS1);
		
		char[] sortedS2 = s2.toCharArray();
		Arrays.sort(sortedS2);
		
		return new String(sortedS1).equals(new String(sortedS2));

	}
	
	
	public static void main(String[] args) {
		Boolean result = Boolean.FALSE;
		String input = RandomStringGenerator.generateRandomString(1024 * 1000 * 10);
		String input2 = RandomStringGenerator.generateRandomString(1024 * 1000 * 10);
		long start = System.currentTimeMillis();
		result = PermutationChecker.isPermutation(input, input2);
		long end = System.currentTimeMillis();
		System.out.println("IS_PERMUTATION, " + (end - start) + ", " + result);

	
	}
	
}
