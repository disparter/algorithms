package br.com.github.disparter.study.linkedlists;

public class LinkedListNode {
	
	public LinkedListNode next;
	public Object value;
	
	public LinkedListNode(Object value, LinkedListNode next) {
		this.value = value;
		this.next = next;
	}
	
}