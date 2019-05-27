package br.com.github.disparter.study;

import java.util.Optional;
import java.util.stream.Stream;

//BAD SOLUTION (Does not solve the problem)
public class RottenOrangesCalculator {

	public enum State {
		ROTTEN, EMPTY, FRESH;
	}
	
	public class Orange {
		State state;
		public Orange(State s) {
			this.state = s;
		}
	}
	
	public Orange[][] createStub(){
		Orange[][] input = new Orange[3][3];
		input[0][0] = new Orange(State.FRESH);
		input[0][1] = new Orange(State.FRESH);
		input[0][2] = new Orange(State.FRESH);
		input[1][0] = new Orange(State.FRESH);
		input[1][1] = new Orange(State.ROTTEN);
		input[1][2] = new Orange(State.FRESH);
		input[2][0] = new Orange(State.FRESH);
		input[2][1] = new Orange(State.FRESH);
		input[2][2] = new Orange(State.FRESH);
		return input;
	}
	
	
	private static Integer rotLeft(Orange o, Orange[][] input, int row, int col, Integer dayToRot) {
		if(col-1 > 0 && input[row][col-1].state.equals(State.FRESH)) {
			input[row][col-1].state = State.ROTTEN;
			return rotTomorrow(input[row][col-1], input, row, col-1, dayToRot);
		}
		return 0;
	}
	
	private static Integer rotRight(Orange o, Orange[][] input, int row, int col, Integer dayToRot) {
		if(col+1 < input[0].length && input[row][col+1].state.equals(State.FRESH)) {
			input[row][col+1].state = State.ROTTEN;
			return rotTomorrow(input[row][col+1], input, row, col+1, dayToRot);
		}
		return 0;
	}
	
	private static Integer rotUp(Orange o, Orange[][] input, int row, int col, Integer dayToRot) {
		if(row-1 > 0 && input[row-1][col].state.equals(State.FRESH)) {
			input[row-1][col].state = State.ROTTEN;
			return rotTomorrow(input[row-1][col], input, row-1, col, dayToRot);
		}
		return 0;
	}
	
	private static Integer rotBot(Orange o, Orange[][] input, int row, int col, Integer dayToRot) {
		if(row+1 < input.length && input[row+1][col].state.equals(State.FRESH)) {
			input[row+1][col].state = State.ROTTEN;
			return rotTomorrow(input[row+1][col], input, row+1, col, dayToRot);
		}
		return 0;
	}
	
	private static Integer rotTomorrow(Orange o, Orange[][] input, int row, int col, Integer dayToRot) {
		Integer dL = rotLeft(o, input, row, col, dayToRot+1);
		Integer dU = rotUp(o, input, row, col, dayToRot+1);
		Integer dR = rotRight(o, input, row, col, dayToRot+1);
		Integer dD = rotBot(o, input, row, col, dayToRot+1);
		Optional<Integer> result = Stream.of(dL, dU, dR, dD, dayToRot).max((m, n) -> Integer.compare(m, n));			
		return result.get();
	}
	
	private static Integer calculate(Orange[][] input) {
		Integer numberOfDays = 0;
		
		for(int i = 0; i < input.length; i++) {
			for(int j = 0; j < input[0].length; j++) {
				if(input[i][j].state == State.ROTTEN) {
					Integer max = rotTomorrow(input[i][j], input, i, j, numberOfDays);
					if(max > numberOfDays) {
						numberOfDays = max;
					}
				}
			}
		}
		return numberOfDays;
	}
	
	public static void main(String[] args) {
		Integer result = null;
		Orange[][] input = new RottenOrangesCalculator().createStub();
		
		long start = System.currentTimeMillis();
		result = RottenOrangesCalculator.calculate(input);
		long end = System.currentTimeMillis();
		System.out.println("ROTTEN_ORANGES_CALCULATOR, " + (end - start)+ " NO_DAYS: " + result);
		
		for(int i = 0; i < input.length; i++) {
			for(int j = 0; j < input[0].length; j++) {
				System.out.print(input[i][j].state);
			}
			System.out.println();
		}
		
	}

}
