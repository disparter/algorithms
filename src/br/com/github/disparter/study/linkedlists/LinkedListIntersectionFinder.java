package br.com.github.disparter.study.linkedlists;

public class LinkedListIntersectionFinder {
	
	public static LinkedListNode find(LinkedListNode node1, LinkedListNode node2) {
		LinkedListNode buff1 = new LinkedListNode(node1.value, node1.next);
		LinkedListNode buff2 = new LinkedListNode(node2.value, node2.next);
		Integer node1Length = 0;
		Integer node2Length = 0;
		
		while(buff1.next != null) {
			buff1 = buff1.next;
			node1Length++;
		}
		
		while(buff2.next != null) {
			buff2 = buff2.next;
			node2Length++;
		}
		
		if(!buff2.equals(buff1)) {
			return null;
		}
		
		if(node1Length > node2Length) {
			int excess = node1Length - node2Length;
			for(int i = 0; i < excess; i++) {
				node1 = node1.next;
			}
		}else {
			int excess = node2Length - node1Length;
			for(int i = 0; i < excess; i++) {
				node2 = node2.next;
			}
		}
		
		while(node1.next != null) {
			if(node1.equals(node2)) {
				return node1;
			}
			node1 = node1.next;
			node2 = node2.next;
		}
		
		return null;
	}


	public static void main(String[] args) {
		LinkedListNode l1 = LinkedListFiller.randomFulfillIntegers(100);
		LinkedListNode l2 = createIntersectedList(l1);
		LinkedListNode l3 = LinkedListFiller.randomFulfillIntegers(100);
		LinkedListNode result = null;
		
		long start = System.currentTimeMillis();
		result = LinkedListIntersectionFinder.find(l1, l2);
		long end = System.currentTimeMillis();

		System.out.println("LL_INTERSECTION_FINDER: " + (end-start) + " RESULT: " + result);

		start = System.currentTimeMillis();
		result = LinkedListIntersectionFinder.find(l1, l3);
		end = System.currentTimeMillis();

		System.out.println("LL_INTERSECTION_FINDER: " + (end-start) + " RESULT: " + result);
		
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