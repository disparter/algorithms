package br.com.github.disparter.study;

import java.util.Random;

public class ZeroMatrix {

	public static int[][] zerify(int[][] matrix, int maxCols, int maxRows) {
		boolean[] nulifiedCols = new boolean[maxCols];
		boolean[] nulifiedRows = new boolean[maxRows];
			
		
		for(int col = 0; col < maxCols; col++) {
			
			if(nulifiedCols[col]) {
				continue;
			}
			
			for(int row = 0; row < maxRows; row++) {
				
				int element = matrix[col][row];
				
				if(element == 0) {
					nulifiedCols[col] = true;
					nulifiedRows[row] = true;
				}
			}
		}
		
		for(int col = 0; col < nulifiedCols.length; col++) {
			if(nulifiedCols[col]) {
				for(int row = 0; row < maxRows; row++) {
					matrix[col][row] = 0;
				}
			}
		}
		
		for(int row = 0; row < nulifiedRows.length; row++) {
			if(nulifiedRows[row]) {
				for(int col = 0; col < maxCols; col++) {
					matrix[col][row] = 0;
				}
			}
		}
		
		return matrix;
		
	}
	
	public static void main(String[] args) {
		int n = new Random().nextInt(3) + 1;
		int m = new Random().nextInt(3) + 1;
		int[][] result = null;
		int[][] input = new int[n][m];
		
		for(int col = 0; col < n; col++) {
			for(int row = 0; row < m; row++) {
				input[col][row] = new Random().nextInt(9);
				System.out.print(input[col][row]);
			}
			System.out.println("");
		}
		
		long start = System.currentTimeMillis();
		result = ZeroMatrix.zerify(input, n, m);
		long end = System.currentTimeMillis();
		System.out.println("ZERIFY, " + (end - start) + ", ");
	
		for(int col = 0; col < n; col++) {
			for(int row = 0; row < m; row++) {
				System.out.print(result[col][row]);
			}
			System.out.println("");
		}		
		
	}
	
}
