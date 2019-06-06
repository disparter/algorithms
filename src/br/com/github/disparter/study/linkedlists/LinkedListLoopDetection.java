package br.com.github.disparter.study.linkedlists;

import java.util.HashMap;

public class LinkedListLoopDetection {
	

	public static LinkedListNode getBrokenNode(LinkedListNode node) {
		LinkedListNode head = node;
		HashMap<LinkedListNode, Integer> existingNodes = new HashMap<>();
		
		while(node.next != null) {
			Integer value = existingNodes.get(node);
			
			if(value == null) {
				value = 1;
			}else if(value > 1) {
				if(node.equals(head)) {
					return null;
				}
				return node;
			}else {
				value++;	
			}
			
			existingNodes.put(node, value);
			node = node.next;
		}
		
		return null;
	}

	
	public static void main(String[] args) {
		LinkedListNode circularList = LinkedListFiller.randomCircularListFulfillIntegers(10);
		LinkedListNode brokenCircular = createBrokenList();
		LinkedListNode result = null;
		
		long start = System.currentTimeMillis();
		result = LinkedListLoopDetection.getBrokenNode(circularList);
		long end = System.currentTimeMillis();
		System.out.println("LL_LOOP_DETECTION: " + (end-start) + " NODE: "+ result);
		
		start = System.currentTimeMillis();
		result = LinkedListLoopDetection.getBrokenNode(brokenCircular);
		end = System.currentTimeMillis();
		System.out.println("LL_LOOP_DETECTION_WITH_LOOP: " + (end-start) + " NODE: "+ result);
	}

	private static LinkedListNode createBrokenList() {
		LinkedListNode node = LinkedListFiller.randomCircularListFulfillIntegers(10);
		LinkedListNode result = new LinkedListNode(node.value, node.next);
		
		
		for(int i = 0; i < 5; i++) {
			result = result.next;
		}
		
		LinkedListNode earlierNode = result;
		
		while(result.next != null) {
			result = result.next;
		}
		
		result.next = earlierNode;
		
		return node;
	}

}