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
		if (input == null || input.equals("")) {
			StateBase.currentState = StateBase.currentState.getInputToNextState().get("");

		}
	}

	public static void incrementFloor() {
		if (currentFloor < maxFloor && currentFloor < destinationFloor) {
			currentFloor++;
		}
	}

	public static void decrementFloor() {
		if (currentFloor > 0 && currentFloor > destinationFloor) {
			currentFloor--;
		}
	}

	private boolean isInt(String input) {
		try {
			Integer.parseInt(input);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	public Map<String, StateBase> getInputToNextState() {
		return inputToNextState;
	}

	public void setInputToNextState(Map<String, StateBase> inputToNextState) {
		this.inputToNextState = inputToNextState;
	}
}
