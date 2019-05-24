package br.com.github.disparter.study;

public class UniqueCharactersDeterminator {

	public static Boolean isUniqueCharacters(String s) {
		char[] chars = s.toCharArray();
		for(char c:s.toCharArray()) {
			int i = 0;
			for(char c2:chars) {
				if(c2 == c) {
					i++;
				}
				if(i == 2) {
					return Boolean.FALSE;
				}
			}
			
		}
		return Boolean.TRUE;
	}
	
	
	public static Boolean isUniqueCharactersO1(String s) {
		boolean[] aux = new boolean[Character.MAX_VALUE];
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(aux[c]) {
				return Boolean.FALSE;
			}
			aux[c] = Boolean.TRUE;
		}
		
		return Boolean.TRUE;
	}
	
	public static void main(String[] args) {
		Boolean result = Boolean.FALSE;
		String input = RandomStringGenerator.generateRandomString(1024 * 1000 * 10);
		long start = System.currentTimeMillis();
		result = UniqueCharactersDeterminator.isUniqueCharacters(input);
		long end = System.currentTimeMillis();
		System.out.println("ONLY STRING, " + (end - start) + ", " + result);

		String input2 = RandomStringGenerator.generateRandomString(1024 * 1000 * 10);
		long start2 = System.currentTimeMillis();
		result = UniqueCharactersDeterminator.isUniqueCharactersO1(input2);
		long end2 = System.currentTimeMillis();
		System.out.println("ASCII, " + (end2 - start2)  + ", " + result);
	
	}
	
}
