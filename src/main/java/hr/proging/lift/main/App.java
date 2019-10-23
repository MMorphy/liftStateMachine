package hr.proging.lift.main;

import java.util.Scanner;

import hr.proging.lift.state.StateBase;

public class App {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		String currentInput;
		while (true) {
			System.out.println("Current state: " + StateBase.currentState.getStateName());
			System.out.println("Current floor: " + StateBase.currentFloor);
			System.out.println("Current destination: " + StateBase.destinationFloor);
			System.out.print("Input: ");
			currentInput = input.nextLine();
			StateBase.handleInput(currentInput);
		}
	}

}
