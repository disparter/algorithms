package br.com.github.disparter.study.arrays;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class FrequencySorter {

	public static void sortByFrequency(List<Integer> arr) {
		Map<Integer, Integer> counters = new HashMap<Integer, Integer>();
		Map<Integer, List<Integer>> frequencies = new HashMap<Integer, List<Integer>>();

		countFrequency(arr, counters);
		assemblyByFrequency(counters, frequencies);

		List<Integer> result = new ArrayList<Integer>();

		revertToSingleSortedArrayList(frequencies, result);

		arr.removeAll(arr);

		for (Integer i : result) {
			arr.add(i);
		}
	}

	//This needs to be improved
	private static void revertToSingleSortedArrayList(Map<Integer, List<Integer>> frequencies, List<Integer> result) {
		frequencies.forEach((frequency, list) -> {
			list.sort(Comparator.naturalOrder());

			list.forEach(i -> {
				result.add(i);
			});
		});
	}

	//(Big O(n²))
	private static void assemblyByFrequency(Map<Integer, Integer> counters, Map<Integer, List<Integer>> frequencies) {
		counters.forEach((key, value) -> {
			List<Integer> numbers = frequencies.get(value);
			if (numbers == null) {
				numbers = new ArrayList<Integer>();
				frequencies.put(value, numbers);
			}
			for (int i = 0; i < value; i++) {
				numbers.add(key);
			}
		});
	}

	//(Big O(n))
	private static void countFrequency(List<Integer> arr, Map<Integer, Integer> counters) {
		for (Integer i : arr) {
			Integer count = counters.get(i);
			if (count == null) {
				count = 1;
			} else {
				count++;
			}

			counters.put(i, count);
		}
	}

	public static void main(String[] args) throws IOException {

		List<Integer> arr = new ArrayList<>();
		Integer maxSize = 1000;
		
		for (int i = 0; i < maxSize; i++) {
			int novoI = new Random().nextInt(maxSize);
			arr.add(novoI);
			System.out.print(novoI + ",");
		}
		System.out.println("---");

		long start = System.currentTimeMillis();
		FrequencySorter.sortByFrequency(arr);
		long end = System.currentTimeMillis();
		System.out.println("Frequency Comparator, "  + (end - start));
		
		for (Integer i : arr) {
			System.out.print(i + ", ");
		}

	}

}