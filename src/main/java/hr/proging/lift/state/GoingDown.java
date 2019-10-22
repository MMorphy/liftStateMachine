package hr.proging.lift.state;

import java.util.HashMap;
import java.util.Map;

public class GoingDown extends StateBase implements Moving {

	public GoingDown() {
		super("goingdown", initMap());
		StateBase.destinationFloor--;
		StateBase.decrementFloor();
	}

	public GoingDown(int destFloor) {
		super("goingdown", initMap());
		StateBase.destinationFloor = destFloor;
		StateBase.decrementFloor();

	}
	static Map<String, StateBase> inputMap = null;

	public static Map<String, StateBase> initMap() {
		if (inputMap == null) {
			inputMap = new HashMap<String, StateBase>();
			inputMap.put("", new GoingDown());
			inputMap.put("down", new GoingDown());
		}
		return inputMap;
	}
}
