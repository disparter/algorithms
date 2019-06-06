package br.com.github.disparter.study.linkedlists;

import java.util.Random;

public class LinkedListFiller {

	private static LinkedListNode head;

	public static LinkedListNode randomFulfillIntegers(int maxIndex) {
		head = new LinkedListNode(0, getNewUntilMax(0, maxIndex, 100, Boolean.FALSE));
		return head;
	}

	public static LinkedListNode randomFulfillIntegers(int maxIndex, int maxSize) {
		head = new LinkedListNode(0, getNewUntilMax(0, maxIndex, maxSize, Boolean.FALSE));
		return head;
	}

	public static LinkedListNode randomFulfillIntegers(int maxIndex, int maxSize, Boolean isCircular) {
		head = new LinkedListNode(0, getNewUntilMax(0, maxIndex, maxSize, isCircular));
		return head;
	}
	
	public static LinkedListNode randomCircularListFulfillIntegers(int maxIndex) {
		head = new LinkedListNode(0, getNewUntilMax(0, maxIndex, 100, Boolean.TRUE));
		return head;
	}

	private static LinkedListNode getNewUntilMax(int index, int maxIndex, int maxSize, Boolean isCircular) {
		Integer value = new Random().nextInt(maxSize);
		if (index < maxIndex) {
			return new LinkedListNode(value, getNewUntilMax(index + 1, maxIndex, maxSize, isCircular));
		}
		if (Boolean.TRUE.equals(isCircular)) {
		}
		return new LinkedListNode(value, head);
	}

}