package br.com.github.disparter.study.linkedlists;

public class LinkedListNthNodePartitioner {
	
	public static LinkedListNode partition(LinkedListNode node, Integer value) {
		LinkedListNode bRight = null;
		LinkedListNode right = null;

		LinkedListNode bLeft = null;
		LinkedListNode left = null;
		
		
		while(node.next != null) {
			if((Integer)node.value < value) {
				if(bLeft == null) {
					bLeft = new LinkedListNode(node.value, null);
					left = bLeft;
				}else if(bLeft.next == null) {
					bLeft.next = new LinkedListNode(node.value, null);
					left = bLeft.next;
				}else {
					left.next = new LinkedListNode(node.value, null);
					left = left.next;
				}
			}else {
				if(bRight == null) {
					bRight = new LinkedListNode(node.value, null);
					right = bRight;
				}else if(bRight.next == null) {
					bRight.next = new LinkedListNode(node.value, null);
					right = bRight.next;
				}else {
					right.next = new LinkedListNode(node.value, null);
					right = right.next;
				}
			}
			node = node.next;
		}
		
		left.next = bRight;
		return bLeft;
	}
	
	public static LinkedListNode partitionBetterSpace(LinkedListNode node, Integer value) {
		LinkedListNode head = node;
		LinkedListNode tail = node;
		
		while(node != null) {
			LinkedListNode next = node.next;
			if((Integer)node.value < value) {
				node.next = head;
				head = node;
			}else {
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		
		return head;
	}
	
	public static void main(String[] args) {
		LinkedListNode node = LinkedListFiller.randomFulfillIntegers(100);
		LinkedListNode testNode = new LinkedListNode(node.value, node.next);
		LinkedListNode testNode2 = new LinkedListNode(node.value, node.next);


		while(testNode.next != null) {
			System.out.print(testNode.value + ", ");
			testNode = testNode.next;
		}

		long start = System.currentTimeMillis();
		node = LinkedListNthNodePartitioner.partition(node, 20);
		long end = System.currentTimeMillis();

		System.out.println("PARTITION TIME: " + (end-start));

		while(node.next != null) {
			System.out.print(node.value + ", ");
			node = node.next;
		}
		
		start = System.currentTimeMillis();
		node = LinkedListNthNodePartitioner.partitionBetterSpace(testNode2, 20);
		end = System.currentTimeMillis();

		System.out.println("PARTITION TIME IMPROVE: " + (end-start));

		while(node.next != null) {
			System.out.print(node.value + ", ");
			node = node.next;
		}
	}
}