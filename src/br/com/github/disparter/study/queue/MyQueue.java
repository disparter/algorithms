package br.com.github.disparter.study.queue;

import java.util.Stack;

public class MyQueue{
	
	Stack<Integer> stackOldest = new Stack<>();
	Stack<Integer> stackNewest = new Stack<>();
	
	private void sort() {
		while(!stackNewest.isEmpty()) {
			stackOldest.push(stackNewest.pop());
		}
	}
	
	public void add(Integer item) {
		stackNewest.push(item);
	}
	
	public Integer peek() {
		sort();
		return stackOldest.peek();
	}
	
	public Integer remove() {
		sort();
		return stackOldest.pop();
	}
	
	
}
