package console;


import java.io.IOException;


public class GraphConsole {
	//Native method declaration
	public native static ConsoleEvent peekRawEvent();	/* non blocking event read */
	public native static ConsoleEvent readRawEvent();	/* blocking version */
	
	public native static void setBackgroundColor(int color);
	public native static void setForegroundColor(int color);
	public native static void gotoXY(int x, int y);
	public native static void writeAt(int x, int y, String buf);	
	public native static void write(String buf);
	public native static void clearScreen();	


	public final static int FOREGROUND_BLUE  = 0x0001;   //	Text color contains blue.
	public final static int FOREGROUND_GREEN = 0x0002;   // Text color contains green.
	public final static int FOREGROUND_RED   = 0x0004;   // Text color contains red.
	public final static int FOREGROUND_WHITE = 0x0007;   // Text color contains white.
	public final static int FOREGROUND_BLACK = 0x0000;   // Text color contains black.


	public final static int FOREGROUND_INTENSITY=0x0008; // Text color is intensified.
	 
	public final static int BACKGROUND_BLUE=0x0010;		 // Background color contains blue.
	public final static int BACKGROUND_GREEN=0x0020;  	 // Background color contains green.
	public final static int BACKGROUND_RED=0x0040;		 // Background color contains red.
	public final static int BACKGROUND_WHITE=0x0070;	 // Background color contains white.
	public final static int BACKGROUND_BLACK=0x0000;	 // Background color contains black.
	 
	public final static int  BACKGROUND_INTENSITY=0x0080;//Background color is intensified.
	

	//Load the library
	static {
		System.loadLibrary( "GraphCons");
		GraphConsole.setBackgroundColor(BACKGROUND_BLACK);
		GraphConsole.setForegroundColor(FOREGROUND_WHITE);
		GraphConsole.clearScreen();
	}

	
	public static void xmain(String[] args) throws  IOException {
	//	GraphConsole.setBackgroundColor(GraphConsole.BACKGROUND_WHITE);
	//	GraphConsole.setForegroundColor(GraphConsole.FOREGROUND_WHITE);
		GraphConsole.clearScreen();
		GraphConsole.writeAt(0,0,"Hello");
		while (true) {
		 readRawEvent().show();
		}
		/*
		ConsoleEvent event;
		int buttonPressed = 0;
		int oldX = -1, oldY=-1;
	    
		while(true) {
			event = readRawEvent();
			/*
			while (true) {
				try {
					if (System.in.read()==1) break;
				}
				catch(IOException e) {}
			}
		    
			if (event.type == ConsoleEvent.KEY_EVENT) {
				ConsoleKeyEvent ke = (ConsoleKeyEvent) event;
				if (ke.keyDown) System.out.println("key pressed");
				else System.out.println("key released");
			}
			else if (event.type == ConsoleEvent.MOUSE_EVENT) {
				ConsoleMouseEvent me = (ConsoleMouseEvent) event;
				if (me.buttons != buttonPressed) {
					if (me.buttons > buttonPressed) 
						System.out.println("mouse button pressed");
					else
						System.out.println("mouse button released");
					buttonPressed = me.buttons;
				}
				if (oldX != -1 && oldY != -1) {
					if (me.xPos != oldX || 	me.yPos != oldY) {
						System.out.println("mouse move");
					}
				}
				oldX = me.xPos; oldY = me.yPos;
			 
			}
		}
		 */
			
	}

}

