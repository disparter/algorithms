package br.com.github.disparter.study.arrays;

public class OneAwayChecker {

	public static Boolean isOneAway(String s1, String s2) {
		if(s1.length() > s2.length()) {
			return isOneAwayOrdered(s1, s2);
		}
		
		return isOneAwayOrdered(s2, s1);
	}
	
	public static Boolean isOneAwayOrdered(String s1, String s2) {
		if(s1.length() - s2.length() >= 2) {
			return Boolean.FALSE;
		}
		
		char[] charsS1 = s1.toCharArray(); 
		char[] charsS2 = s2.toCharArray();

		int changes = 0;
		if(charsS1.length == charsS2.length) {
			for(int i = 0; i < charsS1.length; i++) {
				if(charsS1[i] != charsS2[i]) {
					changes++;
				}
			}
		} else {
			boolean indexChanged = false;
			for(int i = 0; i < charsS2.length; i++) {
				if(indexChanged) {
					if(charsS1[i+1] != charsS2[i]) {
						changes++;
					}
				}else {
					if(charsS1[i] != charsS2[i]) {
						changes++;
						indexChanged = true;
					}
				}
			}
		}
		
		return changes < 2;
	} 
	
	
	public static void main(String[] args) {
		Boolean result = Boolean.FALSE;
		String input = RandomStringGenerator.generateRandomString(1024 * 1000 * 10);
		String input2 = RandomStringGenerator.generateRandomString(1024 * 1000 * 10);

		long start = System.currentTimeMillis();
		result = OneAwayChecker.isOneAway(input, input2);
		long end = System.currentTimeMillis();
		System.out.println("IS_ONE_AWAY, " + (end - start) + ", " + result);

		start = System.currentTimeMillis();
		result = OneAwayChecker.isOneAway("Felipe é um grande programador", "Felipe é um grand programador");
		end = System.currentTimeMillis();
		System.out.println("IS_ONE_AWAY, " + (end - start) + ", " + result);

	}
	
}
