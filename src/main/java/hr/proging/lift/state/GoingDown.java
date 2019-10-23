package hr.proging.lift.state;

import java.util.HashMap;
import java.util.Map;

public class GoingDown extends StateBase implements Moving {

	public GoingDown() {
		super("goingdown", initMap());
	}

	public GoingDown(int destFloor) {
		super("goingdown", initMap());

	}

	static Map<String, StateBase> inputMap = null;

	public static Map<String, StateBase> initMap() {
		if (inputMap == null) {
			inputMap = new HashMap<String, StateBase>();
			inputMap.put("", stillGoing());
			inputMap.put("down", down());
		}
		return inputMap;
	}

	private static StateBase stillGoing() {
		if (StateBase.currentFloor != StateBase.destinationFloor) {
			return new GoingDown();
		} else {
			return new WaitingClosed();
		}
	}

	private static StateBase down() {
		StateBase.decrementFloor();
		return new GoingDown();
	}
}
