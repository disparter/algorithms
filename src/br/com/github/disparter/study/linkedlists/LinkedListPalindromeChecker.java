package br.com.github.disparter.study.linkedlists;

import java.util.ArrayList;
import java.util.List;

public class LinkedListPalindromeChecker {
	
	public static Boolean check(LinkedListNode node) {
		LinkedListNode buff = new LinkedListNode(node.value, node.next);
		
		List<LinkedListNode> array = new ArrayList<>();
		
		while(buff.next != null) {
			array.add(buff);
			buff = buff.next;
		}
		array.add(buff);

		for(int i = array.size()-1; i >= 0; i--) {
			if(!node.value.equals(array.get(i).value)) {
				return Boolean.FALSE;
			}
			node = node.next;
		}
		
		return Boolean.TRUE;
	}

	public static void main(String[] args) {
		LinkedListNode palindrome = createPalindrome();
		LinkedListNode notPalindrome = createNotPalindrome();
		Boolean result = null;
		
		long start = System.currentTimeMillis();
		result = LinkedListPalindromeChecker.check(palindrome);
		long end = System.currentTimeMillis();

		System.out.println("LL_PALINDROME_CHECKER: " + (end-start) + " RESULT: " + result);

		start = System.currentTimeMillis();
		result = LinkedListPalindromeChecker.check(notPalindrome);
		end = System.currentTimeMillis();

		System.out.println("LL_PALINDROME_CHECKER: " + (end-start) + " RESULT: " + result);
		
	}

	private static LinkedListNode createPalindrome() {
		LinkedListNode l3 = new LinkedListNode("S", null);
		LinkedListNode l2 = new LinkedListNode("O", l3);
		return new LinkedListNode("S", l2);
	}
	
	private static LinkedListNode createNotPalindrome() {
		LinkedListNode l3 = new LinkedListNode("S", null);
		LinkedListNode l2 = new LinkedListNode("O", l3);
		return new LinkedListNode("R", l2);
	}

}