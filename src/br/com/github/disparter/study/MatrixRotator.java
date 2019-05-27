package br.com.github.disparter.study;

///1,1,1,1
///2,2,2,2
///3,3,3,3
///4,4,4,4
//--rotate 90--
///4,3,2,1  
///4,3,2,1 
///4,3,2,1
///4,3,2,1
public class MatrixRotator {
	
	//Perhaps incorrect? Execution time Big O(n²)
	//Space, Big O(n²) - this can be optimized
	private static byte[][] rotate(byte[][] input) {
		byte[][] result = new byte[input.length][input[0].length];
		
		for(int row = 0; row < input.length; row++) {
			for(int col = 0; col < input[0].length; col++) {
				result[col][input.length-row-1] = input[row][col];
			}
		}
		
		return result;
	}
	

	private static byte[][] createStub() {
		byte[][] input = new byte[4][4];
	
		for(int i = 0; i < input.length; i++) {
			for(int j = 0; j < input.length; j++) {
				input[i][j] = (byte) i;
				System.out.print(input[i][j] + ", ");
			}
			System.out.println();
		}
		return input;
	}

	public static void main(String[] args) {
		byte[][] result = null;
		byte[][] input = MatrixRotator.createStub();
		
		long start = System.currentTimeMillis();
		result = MatrixRotator.rotate(input);
		long end = System.currentTimeMillis();
		System.out.println("MATRIX_ROTATOR, " + (end - start));
		
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[0].length; j++) {
				System.out.print(result[i][j] + ", ");
			}
			System.out.println();
		}
		
	}
}