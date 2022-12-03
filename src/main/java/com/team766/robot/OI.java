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
	private JoystickReader joystick1;
	private JoystickReader joystick2;
	final int finerButton = 1;
	final int analogArmButton = 1;
	final int pulleyUpButton = 2;
	final int pulleyDownButton = 3;
	
	public OI() {
		loggerCategory = Category.OPERATOR_INTERFACE;

		joystick0 = RobotProvider.instance.getJoystick(0);
		joystick1 = RobotProvider.instance.getJoystick(1);
		joystick2 = RobotProvider.instance.getJoystick(2);
	}
	
	public void run(Context context) {
		context.takeOwnership(Robot.drive);
		while (true) {
			// Add driver controls here - make sure to take/release ownership
			// of mechanisms when appropriate.

			//Connects the joystick controls to the drive motors
			//These are the finer controls using the other joystick
			if (joystick0.getButton(finerButton)) {
				//Finer controls are used when the trigger is puller
				//Strength of finer controls can be changed in Drive.java, setArcadeDrivePowerFine
				//*Henry Note: instead of finer() could just *0.2 here*//
				Robot.drive.setArcadeDrivePowerFine(joystick0.getAxis(1), joystick0.getAxis(0));
			} else {
				//Normal controls are used when the trigger is released
				Robot.drive.setArcadeDrivePower(joystick0.getAxis(1), joystick0.getAxis(0));
			}
			//Controls pulley and arm
			if (joystick1.getButton(analogArmButton)) {
				//Controls arm when trigger is pressed
				//May need *-1 to make left on the joystick make the arm move left
				Robot.arm.setArmPower(joystick1.getAxis(0));
			} else if (joystick1.getButtonPressed(pulleyUpButton)) {
				//This will move the pulley up a set amount
				context.takeOwnership(Robot.pulley);
				//Sets the pulley motor power to 0.2
				Robot.pulley.setPulleyPower(0.2);
				//Waits for 0.5 seconds
				context.waitForSeconds(0.5);
				//Sets the pulley motor power to 0.0, motor stops
				Robot.pulley.setPulleyPower(0.0);
			} else if (joystick1.getButtonPressed(pulleyDownButton)) {
				//This will move the pulley down a set amount
				context.takeOwnership(Robot.pulley);
				//Sets the pulley motor power to -0.2
				Robot.pulley.setPulleyPower(-0.2);
				//Waits for 0.5 seconds
				context.waitForSeconds(0.5);
				//Sets the pulley motor power to 0.0, motor stops
				Robot.pulley.setPulleyPower(0.0);
			} else {
				//Controls elevator/pulley when trigger is released
				//May need *-1 to make up on the joystick make the pulley move up
				Robot.pulley.setPulleyPower(joystick1.getAxis(1));
			}
			context.waitFor(() -> RobotProvider.instance.hasNewDriverStationData());
		}
	}
}
