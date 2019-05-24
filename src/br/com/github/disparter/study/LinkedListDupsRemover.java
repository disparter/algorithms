package br.com.github.disparter.study;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

public class LinkedListDupsRemover {

	public static void remove(LinkedList<Integer> list) {
		HashSet<Integer> set = new HashSet<Integer>();
		
		for(int i = 0; i < list.size(); i++) {
			Integer el = list.get(i);
			if(set.contains(el)) {
				list.remove(i);
			}else {
				set.add(el);	
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> input = new LinkedList<>();
		Integer maxSize = new Random().nextInt(100);
		
		for(int i = 0; i < maxSize; i++) {
			int novoI = new Random().nextInt(maxSize);
			input.add(novoI);
			System.out.print(novoI + ",");
		}
		
		long start = System.currentTimeMillis();
		LinkedListDupsRemover.remove(input);
		long end = System.currentTimeMillis();
		System.out.println("\nLL_REMOVE_DUPS, " + (end - start));

		input.stream().sorted().forEach(i -> System.out.print(i+","));
		
	}
	
}
