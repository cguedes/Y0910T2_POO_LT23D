package game;
import console.*;

public class Input {

	private boolean[] keysDown = new boolean[256];
	
	public void update() 
	{
		do 
		{
			ConsoleEvent ce = GraphConsole.readRawEvent();
			//ce.show();
			
			if(ce instanceof ConsoleKeyEvent)
			{
				ConsoleKeyEvent cke = (ConsoleKeyEvent)ce;
				
				//cke.show();
				
				if(cke.keyDown) {
					keysDown[ cke.charCode ] = true;
					break;
				}
				else
					keysDown[ cke.charCode ] = false;
			}
			
		} while(true);
		
	}

	public boolean isKeyDown(char c) 
	{
		if(keysDown[c] == true)
			return true;
		
		return false;
	}
	
	

}
