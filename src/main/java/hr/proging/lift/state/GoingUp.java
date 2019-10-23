package hr.proging.lift.state;

import java.util.HashMap;
import java.util.Map;

public class GoingUp extends StateBase implements Moving {
	static Map<String, StateBase> inputMap = null;

	public GoingUp() {
		super("goingup", initMap());
	}

	public GoingUp(int destFloor) {
		super("goingup", initMap());
	}

	public static Map<String, StateBase> initMap() {
		if (inputMap == null) {
			inputMap = new HashMap<String, StateBase>();
			inputMap.put("", stillGoing());
			inputMap.put("up", up());
		}
		return inputMap;
	}

	private static StateBase stillGoing() {
		if (StateBase.currentFloor != StateBase.destinationFloor) {
			return new GoingUp();
		} else {
			return new WaitingClosed();
		}
	}

	private static StateBase up() {
		StateBase.incrementFloor();
		return new GoingUp();
	}
}
