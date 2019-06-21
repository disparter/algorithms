package br.com.github.disparter.study.stack;

import java.util.Random;

public class ArrayStack {
	
	
	private int[] fillRandom(int size) {
		if(size < 1) {
			throw new NegativeArraySizeException();
		}
		int[] result = new int[size];
		for(int i = 0; i< result.length; i++) {
			result[i] = i + 1;
		}
		return result;
	}
	
	private int getLastIndex(int[] input) {
		int lastIndex = 0;
		for(int i = 0; i < input.length; i++) {
			lastIndex = i;
			if(input[i] == 0) {
				break;
			}
		}
		return lastIndex;
	}
	
	private int pop(int[] input) {
		int lastIndex = getLastIndex(input);
		int pop = input[lastIndex];
		input[lastIndex] = 0;
		return pop;
	}
	
	private int[] push(int[] input, int value) {
		int lastIndex = getLastIndex(input);
		
		if(input[lastIndex] == 0) {
			input[lastIndex] = value;
		}else {
			if(lastIndex + 1 >= input.length) {
				input = doubleSize(input);
			}
			
			input[lastIndex+1] = value;
		}
		
		return input;
		
	}

	private int[] doubleSize(int[] input) {
		int[] result = new int[input.length * 2];
		
		for(int i = 0; i < input.length; i++) {
			result[i] = input[i];
		}
		
		return result;
	}
	

	private void print(int[] input) {
		int lastIndex = getLastIndex(input);
		for(int i = 0; i <= lastIndex; i++) {
			System.out.print(", " + input[i]);
		}
	}



	public static void main(String[] args) {
		int[] input = new ArrayStack().fillRandom(new Random().nextInt(1000));
		int pop = 0;
		
		long start = System.currentTimeMillis();
		pop = new ArrayStack().pop(input);
		long end = System.currentTimeMillis();
		System.out.println("ARRAY_STACK, " + (end - start) + ", POP NUMBER: " + pop);
		
		start = System.currentTimeMillis();
		input = new ArrayStack().push(input, 666);
		end = System.currentTimeMillis();
		System.out.println("ARRAY_STACK_PUSH, " + (end - start));
		
		new ArrayStack().print(input);
		
	}

}
