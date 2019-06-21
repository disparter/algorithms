package br.com.github.disparter.study.stack;

import java.util.Stack;

public class SortStack {
	
	private Stack<Integer> sort(Stack<Integer> input) {
		Stack<Integer> aux = new Stack<>();
		aux.push(input.pop());
		while(!input.isEmpty()) {
			if(input.peek() >= aux.peek()) {
				aux.push(input.pop());
			}else {
				Integer el = input.pop();
				while(!aux.isEmpty() && el < aux.peek()) {
					input.push(aux.pop());
				}
				aux.push(el);
			}
		}
		
		while(!aux.isEmpty()) {
			input.push(aux.pop());
		}
		
		return input;
		
	}
	
	public static void main(String[] args) {
		Stack<Integer> input = RandomStackCreator.create(1000);
		
		long start = System.currentTimeMillis();
		input = new SortStack().sort(input);
		long end = System.currentTimeMillis();
		System.out.println("SORT_STACK, " + (end - start));
		
		StackPrinter.print(input);
		
	}

}
