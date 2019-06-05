package br.com.github.disparter.study.linkedlists;

import java.util.Random;

public class LinkedListFiller {

	public static LinkedListNode randomFulfillIntegers(int maxIndex) {
		 return new LinkedListNode(0, getNewUntilMax(0, maxIndex, 100));
	}
	
	public static LinkedListNode randomFulfillIntegers(int maxIndex, int maxSize) {
		 return new LinkedListNode(0, getNewUntilMax(0, maxIndex, maxSize));
	}
	
	private static LinkedListNode getNewUntilMax(int index, int maxIndex, int maxSize) {
		Integer value = new Random().nextInt(maxSize);
		if(index < maxIndex) {
			return new LinkedListNode(value, getNewUntilMax(index+1, maxIndex, maxSize));
		}
		return new LinkedListNode(value, null);
	}
	
}