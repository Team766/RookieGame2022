package com.team766.robot;

import com.team766.framework.Procedure;
import com.team766.framework.Context;
import com.team766.hal.JoystickReader;
import com.team766.hal.RobotProvider;
import com.team766.logging.Category;
import com.team766.robot.mechanisms.Drive;
import com.team766.robot.procedures.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the code that allow control of the robot.
 */
public class OI extends Procedure {
	private JoystickReader joystick0;
	private JoystickReader joystick1;
	
	public OI() {
		loggerCategory = Category.OPERATOR_INTERFACE;

		joystick0 = RobotProvider.instance.getJoystick(0); //Ryder's ghost in hell is asking you to add the other joystick
		joystick1 = RobotProvider.instance.getJoystick(1);	
	}
	
	public void run(Context context) {
		while (true) {
			// Add driver controls here - make sure to take/release ownership
			// of mechanisms when appropriate.
			context.takeOwnership(Robot.drive);
			Robot.drive.setArcadeDrivePower(joystick0.getAxis(1), joystick1.getAxis(0));


			context.waitFor(() -> RobotProvider.instance.hasNewDriverStationData());
		}
	}
}
