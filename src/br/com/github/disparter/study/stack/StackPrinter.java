package br.com.github.disparter.study.stack;

import java.util.Stack;

public class StackPrinter {
	
	public static void print(Stack<Integer> input) {
		while(!input.isEmpty()) {
			System.out.print(input.pop() + ", ");
		}
	}

}
