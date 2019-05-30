package br.com.github.disparter.study.linkedlists;

import java.util.Random;

public class LinkedListNthNodeRemover {
	
	public static void remove(LinkedListNode nNode) {
		//The last element cannot be removed
		if(nNode == null || nNode.next == null) {
			throw new NullPointerException();
		}
		nNode.next = nNode.next.next;
		nNode.value = nNode.next.value;
	}
	
	public static void removeEvenTheLast(LinkedListNode firstNode, LinkedListNode nNode) {
		if(nNode != null && nNode.next == null) {
			LinkedListNode buff = new LinkedListNode(firstNode.value, firstNode.next);
			while(buff.next != nNode) {
				buff = buff.next;
			}
			buff.next = null;
		}else {
			remove(nNode);
		}
	}
	
	public static void main(String[] args) {
		LinkedListNode node = LinkedListNode.randomFulfillIntegers(1000);
		LinkedListNode nNode = LinkedListNthFinder.findNthUntilLast(node, new Random().nextInt(1000));

		long start = System.currentTimeMillis();
		LinkedListNthNodeRemover.remove(nNode);
		long end = System.currentTimeMillis();

		int count = 0;
		while(node.next != null) {
			node = node.next;
			count++;
		}
		
		System.out.println("REMOVE_EL TIME: " + (end-start) + " - Number of Elements in LinkedList " +count);

		node = LinkedListNode.randomFulfillIntegers(100);
		nNode = LinkedListNthFinder.findNthUntilLast(node, 100);

		start = System.currentTimeMillis();
		LinkedListNthNodeRemover.removeEvenTheLast(node, nNode);
		end = System.currentTimeMillis();

		count = 0;
		while(node.next != null) {
			node = node.next;
			count++;
		}
		
		System.out.println("REMOVE_EL TIME_SLOW: " + (end-start) + " - Number of Elements in LinkedList " +count);
	}
}