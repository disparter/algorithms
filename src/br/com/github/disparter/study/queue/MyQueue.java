package br.com.github.disparter.study.queue;

import java.util.Random;
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
	
	public static MyQueue getRandom(int size) {
		MyQueue q = new MyQueue();
		for(int i = 0; i < size; i++) {
			q.add(i);
		}
		return q;
	}
	
	public static void main(String[] args) {
		MyQueue input = getRandom(new Random().nextInt(1000));
		Integer result = 0;
		long start = System.currentTimeMillis();
		result = input.peek();
		result = input.remove();
		result = input.peek();
		long end = System.currentTimeMillis();
		System.out.println("MyQueque, " + (end - start) + ", SEEK NUMBER: " + result);
		
	}
	
	
}
