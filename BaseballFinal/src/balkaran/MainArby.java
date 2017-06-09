package balkaran;

/**
 * @author 324118041
 *
 */

public class MainArby {

	public static void main(String[] args) {
		Behavior b0 = new ExitProgram();
		Behavior b1 = new Movement();
		Behavior b2 = new Ultrasonic();
		Behavior b3 = new Spin();
		Behavior[] behaviors = {b0, b1, b2, b3};
		
		Arbitrator arby = new Arbitrator(behaviors);
		arby.start();
	}

}
