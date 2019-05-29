package br.com.github.disparter.study.arrays;

public class URLifier {

	//https://stackoverflow.com/questions/4378455/what-is-the-complexity-of-regular-expression
	public static void urlify(String s1) {
		final String P = "%20";
		s1.replace(" ", P);
	}

	//O(n)
	public static String urlifyOptmal(String s1) {
		char[] str = s1.toCharArray();
		int spaceCount = 0, index, i = 0;
		
		for (i = 0; i < str.length; i++) {
			if (str[i] == ' ') {
				spaceCount++;
			}
		}
		index = str.length + (spaceCount * 2);
		char[] newStr = new char[index];
		
		
		for (i = str.length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				newStr[index - 1] = '0';
				newStr[index - 2] = '2';
				newStr[index - 3] = '%';
				index = index - 3;
			} else {
				newStr[index - 1] = str[i];
				index--;
			}
		}		
		return new String(newStr);
	}

	public static void main(String[] args) {
		String input = RandomStringGenerator.generateRandomString(1024 * 1000 * 10);
		long start = System.currentTimeMillis();
		URLifier.urlify(input);
		long end = System.currentTimeMillis();
		System.out.println("urlify, " + (end - start));

		start = System.currentTimeMillis();
		URLifier.urlifyOptmal(input);
		end = System.currentTimeMillis();
		System.out.println("urlifyOptmal, " + (end - start) + ", ");
	}

}
