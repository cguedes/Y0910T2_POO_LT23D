package console;

public abstract class ConsoleEvent {
	public static final int KEY_EVENT=1;
	public static final int MOUSE_EVENT=2;
	
	public final int type;		// type of event
	
	
	protected ConsoleEvent(int eventType) {
		this.type = eventType;
	}
	
	public abstract void show();
	
		
}

