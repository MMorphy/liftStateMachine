package hr.proging.lift.state;

import java.util.HashMap;
import java.util.Map;

public class GoingUp extends StateBase implements Moving {
	static Map<String, StateBase> inputMap = null;

	public GoingUp() {
		super("goingup", initMap());
		StateBase.destinationFloor++;
		StateBase.incrementFloor();
	}

	public GoingUp(int destFloor) {
		super("goingup", initMap());
		StateBase.destinationFloor  = destFloor;
		StateBase.incrementFloor();
	}

	public static Map<String, StateBase> initMap() {
		if (inputMap == null) {
			inputMap = new HashMap<String, StateBase>();
			inputMap.put("", new GoingUp());
			inputMap.put("up", new GoingUp());
		}
		return inputMap;
	}
}
