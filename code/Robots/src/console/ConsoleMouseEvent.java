package console;

public class ConsoleMouseEvent extends ConsoleEvent {
	public static final int LEFT_BUTTON_PRESSED=0x0001;
	public static final int MIDDLE_BUTTON_PRESSED=0x0004;
	public static final int RIGHT_BUTTON_PRESSED=0x0002;
  
 
	/* mouse event attributes */
	public final int buttons;		// pressed buttons mask
	public final int  xPos;			// mouse x position
	public final int  yPos;			// mouse y position
	
	public ConsoleMouseEvent(int buttons, int xPos, int yPos) {
		super(MOUSE_EVENT);
		this.buttons = buttons;
		this.xPos = xPos;
		this.yPos = yPos;
	 
	}
 
	
	public void show() {
		System.out.println("Mouse Event:");
		System.out.println("\tbuttons ="+ buttons);
		System.out.println("\txPos    ="+ xPos);
		System.out.println("\tyPos    ="+ yPos);
	}
	
}
		