package br.com.github.disparter.study;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SetOfStacks{

	private List<Stack<Integer>> stacks;
	private Integer threshold;
	private Integer index = 0;
	
	public SetOfStacks(Integer threshold) {
		this.threshold = threshold;
		stacks = new ArrayList<Stack<Integer>>();
	}
	
	public Integer pop() {
		Stack<Integer> stack = getLastStack();
		if(stack.isEmpty()) {
			stacks.remove(stack);
			stack = getLastStack();
		}
		Integer plate = stack.pop();
		index--;
		return plate;
	}
	
	public void push(Integer plate) {
		if(index + 1 > (threshold * stacks.size())) {
			createNewStack();
		}
		Stack<Integer> stack = getLastStack();
		stack.push(plate);
		index++;
	}
	
	public Integer popAt(Integer stackNumber) {
		return stacks.get(stackNumber).pop();
	}

	private Stack<Integer> getLastStack() {
		return stacks.get(stacks.size()-1);
	}

	private void createNewStack() {
		stacks.add(new Stack<Integer>());
	}
	
}
