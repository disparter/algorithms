package br.com.github.disparter.study.linkedlists;

public class LinkedListIntersectionChecker {
	
	public static Boolean check(LinkedListNode node1, LinkedListNode node2) {
		while(node1.next != null) {
			if(node1.equals(node2)) {
				return Boolean.TRUE;
			}
			node1 = node1.next;
		}
		
		while(node2.next != null) {
			if(node2.equals(node1)) {
				return Boolean.TRUE;
			}
			node2 = node2.next;
		}
		
		return node1.equals(node2);
		
	}

	public static void main(String[] args) {
		LinkedListNode l1 = LinkedListFiller.randomFulfillIntegers(100);
		LinkedListNode l2 = createIntersectedList(l1);
		LinkedListNode l3 = LinkedListFiller.randomFulfillIntegers(100);
		Boolean result = null;
		
		long start = System.currentTimeMillis();
		result = LinkedListIntersectionChecker.check(l1, l2);
		long end = System.currentTimeMillis();

		System.out.println("LL_INTERSECTION_CHECKER: " + (end-start) + " RESULT: " + result);

		start = System.currentTimeMillis();
		result = LinkedListIntersectionChecker.check(l1, l3);
		end = System.currentTimeMillis();

		System.out.println("LL_INTERSECTION_CHECKER: " + (end-start) + " RESULT: " + result);
		
	}

	private static LinkedListNode createIntersectedList(LinkedListNode l1) {
		LinkedListNode node = LinkedListFiller.randomFulfillIntegers(100);
		LinkedListNode buff = new LinkedListNode(node.value, node.next);
		
		for(int i = 0; i < 50; i++) {
			buff = buff.next;
		}
		buff.next = l1;

		return node;
	}

}