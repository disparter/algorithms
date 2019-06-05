package br.com.github.disparter.study.linkedlists;

public class LinkedListIntegerSum {
	
	public static Integer getValue(LinkedListNode node) {
		if(node == null || node.value == null) {
			return 0;
		}
		return (Integer) node.value;
	}
	
	public static LinkedListNode moveNext(LinkedListNode node) {
		if(node == null || node == null) {
			return null;
		}
		return node.next;
	}
	
	public static LinkedListNode sum(LinkedListNode n1Node, LinkedListNode n2Node, Integer leftover) {
		if(n1Node == null && n2Node == null) {
			if(leftover != null && leftover > 0) {
				return new LinkedListNode(leftover, null);
			}
			return null;
		}
		
		Integer newLeftover = 0;
		Integer value = getValue(n1Node) + getValue(n2Node) + leftover;
		if(value > 9) {
			Integer firstDigit = value % 10;
			newLeftover = value - firstDigit; 
			value = firstDigit;
		}
		
		n1Node = moveNext(n1Node);
		n2Node = moveNext(n2Node);
		
		return new LinkedListNode(value, sum(n1Node, n2Node, newLeftover/10));
	}
	
	private static LinkedListNode sum(LinkedListNode node1, LinkedListNode node2) {
		return reverse(sum(reverse(node1), reverse(node2), 0));
	}
	
	public static LinkedListNode reverse(LinkedListNode current) {
		LinkedListNode previous = null;
		LinkedListNode next;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		return previous;
	}

	public static void main(String[] args) {
		LinkedListNode node1 = LinkedListFiller.randomFulfillIntegers(2, 10);
		LinkedListNode node2 = LinkedListFiller.randomFulfillIntegers(2, 10);
		LinkedListNode test1 = new LinkedListNode(node1.value, node1.next);
		LinkedListNode test2 = new LinkedListNode(node2.value, node2.next);
		LinkedListNode result = null;
		
		System.out.print("Number1: ");
		System.out.print(test1.value);
		while(test1.next != null) {
			test1 = test1.next;
			System.out.print(test1.value);
		}
		
		System.out.print("\nNumber2: ");
		System.out.print(test2.value);
		while(test2.next != null) {
			test2 = test2.next;
			System.out.print(test2.value);
		}
		
		long start = System.currentTimeMillis();
		result = LinkedListIntegerSum.sum(node1, node2);
		long end = System.currentTimeMillis();

		System.out.println("\nLL SUM TIME: " + (end-start));
		System.out.print("SUM VALUE: ");
		while(result.next != null) {
			System.out.print(result.value);
			result = result.next;
		}
		System.out.print(result.value);
	}

}