package hr.proging.lift.state;

import java.util.HashMap;
import java.util.Map;

public class WaitingOpen extends StateBase {

	public WaitingOpen() {
		super("waitingopen", initMap());
		// TODO Auto-generated constructor stub
	}

	static Map<String, StateBase> inputMap = null;

	public static Map<String, StateBase> initMap() {
		if (inputMap == null) {
			inputMap = new HashMap<String, StateBase>();
			inputMap.put("", new WaitingOpen());
			inputMap.put("close", new WaitingClosed());
			inputMap.put("open", new WaitingOpen());
		}
		return inputMap;
	}
}
