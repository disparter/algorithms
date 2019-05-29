package br.com.github.disparter.study.linkedlists;

public class LinkedListNthFinder {
	
	public static LinkedListNode findNthUntilLast(LinkedListNode firstNode, Integer n) {
		LinkedListNode nNode = firstNode;
		while(nNode.next != null && n > 0) {
			nNode = nNode.next;
			n--;
		}
		return nNode.next;
	}
	
	public static void main(String[] args) {
		LinkedListNode node = LinkedListNode.randomFulfillIntegers(1000);
		
		long start = System.currentTimeMillis();
		LinkedListNode nNode = LinkedListNthFinder.findNthUntilLast(node, 999);
		long end = System.currentTimeMillis();
		System.out.print("FIND_NTH, " + (end - start));

		int count = 0;
		while(nNode.next != null) {
			nNode = nNode.next;
			count++;
		}
		
		System.out.println(", Number of EL " +count);
		
	}
	
}
