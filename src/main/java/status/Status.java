package status;

public class Status {
	private static Status singleton;
	private Status() {}
	public static Status getInstance() {
		if (singleton == null) singleton = new Status();
		return singleton;
	}

	public boolean warning() {
		return true;
	}
}
