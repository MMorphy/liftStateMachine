package hr.proging.lift.state;

import java.util.Map;

public abstract class StateBase {

	private String stateName;

	public static int currentFloor = 0;

	public static int maxFloor = 5;

	public static int destinationFloor = 0;

	public static StateBase currentState = new WaitingOpen();

	private Map<String, StateBase> inputToNextState;

	public StateBase(String stateName, Map<String, StateBase> inputToNextState) {
		super();
		this.stateName = stateName;
		this.inputToNextState = inputToNextState;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public static void handleInput(String input) {
		if (StateBase.currentFloor != StateBase.destinationFloor && (input == null || input.equals(""))) {
			handleIntegerInput(StateBase.destinationFloor);
		} else if (StateBase.isInt(input)) {
			handleIntegerInput(Integer.parseInt(input));
		} else if (StateBase.currentState.getInputToNextState().containsKey(input)) {
			StateBase.currentState = StateBase.currentState.getInputToNextState().get(input);
		} else {
			System.out.println("Invalid input for this state!");
			System.out.println("Valid states:");
			if (!(StateBase.currentState instanceof WaitingOpen)) {
				for (int i = 0; i <= StateBase.maxFloor; i++) {
					System.out.println(i);
				}
			}
			for (String key : currentState.getInputToNextState().keySet()) {
				System.out.println(key);
			}
		}
	}

	public static void incrementFloor() {
		if (currentFloor < maxFloor && currentFloor < destinationFloor) {
			StateBase.currentFloor++;
		}
	}

	public static void decrementFloor() {
		if (currentFloor > 0 && currentFloor > destinationFloor) {
			StateBase.currentFloor--;
		}
	}

	public static void incrementDestinationFloor() {
		if (StateBase.destinationFloor < StateBase.maxFloor) {
			StateBase.destinationFloor++;
		}
	}

	public static void decrementDestinationFloor() {
		if (StateBase.destinationFloor > 0) {
			StateBase.destinationFloor--;
		}
	}

	private static boolean isInt(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	private static void handleIntegerInput(int input) {
		StateBase.destinationFloor = input;
		if (StateBase.currentState instanceof GoingDown || StateBase.currentState instanceof GoingUp
				|| StateBase.currentState instanceof WaitingClosed) {
			// Goes down
			if (StateBase.destinationFloor < StateBase.currentFloor) {
				StateBase.destinationFloor = Math.max(input, 0);
				StateBase.currentState = new GoingDown();
				StateBase.decrementFloor();
			}
			// Goes up
			else if (StateBase.destinationFloor > StateBase.currentFloor) {
				StateBase.destinationFloor = Math.min(input, StateBase.maxFloor);
				StateBase.currentState = new GoingUp();
				StateBase.incrementFloor();
			}
			// Stays put
			else {
				StateBase.currentState = new WaitingClosed();
			}
		} else {
			StateBase.currentState = new WaitingClosed();
		}
	}

	public Map<String, StateBase> getInputToNextState() {
		return inputToNextState;
	}

	public void setInputToNextState(Map<String, StateBase> inputToNextState) {
		this.inputToNextState = inputToNextState;
	}
}
