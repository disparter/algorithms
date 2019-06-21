package br.com.github.disparter.study.stack;

import java.util.Random;
import java.util.Stack;

public class RandomStackCreator {
	
	public static Stack<Integer> create(int size) {
		Stack<Integer> result = new Stack<>();
		
		for(int i = 0; i < size; i++) {
			result.push(new Random().nextInt(size));
		}
		return result;
	}

}
