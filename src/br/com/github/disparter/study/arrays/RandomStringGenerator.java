package br.com.github.disparter.study.arrays;

import java.util.Random;

public class RandomStringGenerator {

	public static String generateRandomString(int charTotal) {
		Random random = new Random();
		String alphabet = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnO oPpQqRrSsTtUuVvWwXxYyZz";
		int alphabetLength = alphabet.length();
		StringBuilder writeBuilder = new StringBuilder();
		for (int i = 0; i < charTotal; i++) {
			writeBuilder.append(alphabet.charAt(random.nextInt(alphabetLength)));
		}
		return writeBuilder.toString();
	}

}
