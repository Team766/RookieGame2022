package com.team766.robot;

import com.team766.framework.Procedure;
import com.team766.framework.Context;
import com.team766.hal.JoystickReader;
import com.team766.hal.RobotProvider;
import com.team766.logging.Category;
import com.team766.robot.procedures.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the code that allow control of the robot.
 */
public class OI extends Procedure {
	private JoystickReader joystick0;

	
	public OI() {
		loggerCategory = Category.OPERATOR_INTERFACE;

		joystick0 = RobotProvider.instance.getJoystick(0);

	}
	//to get button: joystick0.getButton(button number);
	public void run(Context context) {
		context.takeOwnership(Robot.drive);
		context.takeOwnership(Robot.intake);
		context.takeOwnership(Robot.elevator);
		while (true) {
			// Add driver controls here - make sure to take/release ownership
			// of mechanisms when appropriate.
			Robot.drive.setArcadeDrivePower(joystick0.getAxis(3)-joystick0.getAxis(2), joystick0.getAxis(0));
			Robot.intake.setIntakePower(joystick0.getAxis(5)/3);
			log("intake power: "+joystick0.getAxis(5));
			log("1: "+joystick0.getButton(1));
			log("2: "+joystick0.getButton(2));
			log("3: "+joystick0.getButton(3));
			log("4: "+joystick0.getButton(4));
			log("5: "+joystick0.getButton(5));
			log("6: "+joystick0.getButton(6));
			log("7: "+joystick0.getButton(7));
			log("8: "+joystick0.getButton(8));
			if(joystick0.getButton(5)){
				Robot.elevator.setElevatorPower(0.2);
				//might change motor power for more speed
			} else if (joystick0.getButton(6)){
				Robot.elevator.setElevatorPower(-0.2);
			} else {
				Robot.elevator.setElevatorPower(0);
			}
			context.waitFor(() -> RobotProvider.instance.hasNewDriverStationData());
		}
	}
}
