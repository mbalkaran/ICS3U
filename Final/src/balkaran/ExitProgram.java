package balkaran;

import lejos.nxt.Button;
import lejos.robotics.subsumption.Behavior;

public class ExitProgram implements Behavior {

	public boolean takeControl() {
		if(Button.ESCAPE.isDown()) {
			return true;
		}
		return false;
	}
	public void action() {
		System.exit(0);
	}
	public void suppress() {
		
	}
}
