package br.com.github.disparter.study.stack;

import java.util.Stack;

public class StackWithMin extends Stack<Integer>{

	private static final long serialVersionUID = 1L;

	private Stack<Integer> min = new Stack<>();
	
	@Override
	public Integer push(Integer item) {
		if(min.isEmpty() || item <= min()) {
			min.push(item);
		}
		return super.push(item);
	}
	
	
	@Override
	public synchronized Integer pop() {
		Integer el = peek();
		if(el.equals(min())) {
			min.pop();
		}
		return super.pop();
	}
	
	public Integer min() {
		return min.peek();
	}
	
}
