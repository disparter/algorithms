package br.com.github.disparter.study;

public class StringRotationChecker {

	// Wrost case - Big O(n²) -> Strings has just one char different (for ex)
	// Best case - Big O(1) -> Strings are length different
	// Avarage - Big O(n) -> This case is when is a rotate and the String has a lot
	// of different chars
	public static Boolean checkRotation(String s1, String s2) {

		if (s1 == null || s2 == null || s1.length() != s2.length()) {
			return Boolean.FALSE;
		}

		char[] s1Chars = s1.toCharArray();
		char[] s2Chars = s2.toCharArray();

		for (int i = 0; i < s2Chars.length; i++) {
			char c = s2Chars[i];
			if (c == s1Chars[s1Chars.length - 1]) {
				for (int j = 1; j <= i; j++) {
					if (s2Chars[i - j] != s1Chars[s1Chars.length - 1 - j]) {
						return Boolean.FALSE;
					}
				}
				for (int j = 1; j <= i; j++) {
					if (s2Chars[i + j] != s1Chars[j]) {
						return Boolean.FALSE;
					}
				}
				return Boolean.TRUE;
			}
		}

		return Boolean.FALSE;
	}

	//This guy is a genius
	public static Boolean isRotationPerfect(String s1, String s2) {
		int len = s1.length();
		/* Check that sl and s2 are equal length and not empty */
		if (len == s2.length() && len > 0) {
			/* Concatenate sl and sl within new buffer */
			String s1s1 = s1 + s1;
			return s1s1.contains(s2);
		}
		return Boolean.FALSE;
	}

	public static void main(String[] args) {
		Boolean result = null;

		String s1T = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		String s2T = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

		String s1Random = RandomStringGenerator.generateRandomString(1024 * 1000 * 10);
		String s2Random = RandomStringGenerator.generateRandomString(1024 * 1000 * 10);

		long start = System.currentTimeMillis();
		result = StringRotationChecker.checkRotation(s1T, s2T);
		long end = System.currentTimeMillis();
		System.out.println("CHECK ROTATION, " + (end - start) + ", Resultado " + result);

		start = System.currentTimeMillis();
		result = StringRotationChecker.isRotationPerfect(s1T, s2T);
		end = System.currentTimeMillis();
		System.out.println("CHECK ROTATION PERFECT, " + (end - start) + ", Resultado " + result);

		start = System.currentTimeMillis();
		result = StringRotationChecker.checkRotation(s1Random, s2Random);
		end = System.currentTimeMillis();
		System.out.println("CHECK ROTATION WITH RANDOM STRINGS, " + (end - start) + ", Resultado " + result);

		//Why this is failing?
		start = System.currentTimeMillis();
		result = StringRotationChecker.isRotationPerfect(s1Random, s1Random);
		end = System.currentTimeMillis();
		System.out.println("CHECK ROTATION PERFECT WITH RANDOM STRINGS, " + (end - start) + ", Resultado " + result);

	}

}
