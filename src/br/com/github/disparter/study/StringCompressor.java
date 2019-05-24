package br.com.github.disparter.study;

import java.util.Arrays;

public class StringCompressor {

	public static String compress(String s1) {
		char[] chars = s1.toCharArray();
		char[] resultLetter = new char[chars.length];
		int[] resultCount = new int[chars.length];

		Arrays.sort(chars);

		char lastLetter = 0;
		int index = -1;
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (lastLetter != c) {
				index++;
				lastLetter = c;
				resultLetter[index] = c;
				resultCount[index] = 1;
			} else {
				resultCount[index]++;
			}
		}

		if (index * 2 < chars.length) {
			StringBuilder str = new StringBuilder(index * 2);
			for (int i = 0; i <= index; i++) {
				str.append(resultLetter[i]).append(resultCount[i]);
			}
			return str.toString();
		}

		return s1;
	}

	public static String compressWithStrings(String str) {
		StringBuilder compressed = new StringBuilder();
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;
		
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.length() < str.length() ? compressed.toString() : str;
	}

	public static void main(String[] args) {
		String result = "";
		String input = RandomStringGenerator.generateRandomString(1024 * 1000 * 10);

		long start = System.currentTimeMillis();
		StringCompressor.compress(input);
		long end = System.currentTimeMillis();
		System.out.println("COMPRESS, " + (end - start));

		start = System.currentTimeMillis();
		StringCompressor.compressWithStrings(input);
		end = System.currentTimeMillis();
		System.out.println("COMPRESS WITH STRINGS, " + (end - start));
		
		
		start = System.currentTimeMillis();
		result = StringCompressor
				.compress("O Felipe é um cara muito engraçado iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		end = System.currentTimeMillis();
		System.out.println("COMPRESS CORRETO, " + (end - start) + ", " + result);

	}

}
