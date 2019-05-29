package br.com.github.disparter.study.arrays;

public class PalindromePermutationChecker {

	//I gUess this is not a palindrome definition
	public static Boolean isAPalindromePermutation(String s1) {
		char[] chars = s1.toCharArray(); 
		char[] reverseChars = new char[chars.length];
		
		for(int i = 0; i < chars.length; i++) {
			reverseChars[i] = chars[chars.length - i -1];
		}
		
		return new String(chars).equals(new String(reverseChars));

	}
	
	
	public static void main(String[] args) {
		Boolean result = Boolean.FALSE;
		String input = RandomStringGenerator.generateRandomString(1024 * 1000 * 10);
		long start = System.currentTimeMillis();
		result = PalindromePermutationChecker.isAPalindromePermutation(input);
		long end = System.currentTimeMillis();
		System.out.println("IS_PALINDROME_PERMUTATION, " + (end - start) + ", " + result);
	}
	
}
