package hr.proging.lift.state;

import java.util.HashMap;
import java.util.Map;

public class WaitingClosed extends StateBase {

	public WaitingClosed() {
		super("waitingclosed", initMap());
	}

	static Map<String, StateBase> inputMap = null;

	public static Map<String, StateBase> initMap() {
		if (inputMap == null) {
			inputMap = new HashMap<String, StateBase>();
			inputMap.put("", new WaitingClosed());
			inputMap.put("close", new WaitingClosed());
			inputMap.put("open", new WaitingOpen());
			inputMap.put("up", new GoingUp(StateBase.destinationFloor+1));
			inputMap.put("down", new GoingDown().getInputToNextState().get("down"));
		}
		return inputMap;
	}
}
