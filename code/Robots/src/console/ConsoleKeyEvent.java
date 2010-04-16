package console;

public class ConsoleKeyEvent extends ConsoleEvent {

	public final boolean keyDown;	// true if key down, false if key released
	public final int repeatCount; 	// related to how much time key is down
	public final int keyCode;		// A virtual-key code that identifies the given key  
	public final char charCode;		// Unicode character pressed
 
	
	public ConsoleKeyEvent(boolean keyDown, int repeatCount, int keyCode, char charCode) {
		super(KEY_EVENT);
		this.keyDown = keyDown;
		this.repeatCount = repeatCount;
		this.keyCode = keyCode;
		this.charCode = charCode;
	}
	
	 
	public void show() {
		System.out.println("Key Event:");
		System.out.println("\tkeyDown    ="+ keyDown);
		System.out.println("\trepeatCount="+ repeatCount);
		System.out.println("\tkeyCode    ="+ keyCode);
		System.out.println("\tcharCode   ="+ charCode);
	}
}
		