package com.team766.robot.procedures;

import com.team766.framework.Procedure;
import com.team766.framework.Context;
import com.team766.robot.Robot;
//This does the autonomous stuff at the beginning
public class AutoPortion extends Procedure{
	public void run(Context context) {
		context.takeOwnership(Robot.drive);
		//Sets both motors to 0.25 power
		Robot.drive.setDrivePower(0.25, 0.25);
		//Waits for 2.5 seconds before running the next line
		context.waitForSeconds(2.5);
		//Sets both motors to 0.15 power
		Robot.drive.setDrivePower(0.15, 0.15);
		//Waits for 1.0 second before running the next line
		context.waitForSeconds(1.0);
		//Sets both motors to 0.1 power
		Robot.drive.setDrivePower(0.1, 0.1);
		//Waits for 0.5 seconds before running the next line
		context.waitForSeconds(0.5);
		//Sets both motors to 0.01 power
		Robot.drive.setDrivePower(0.01, 0.01);
		//Waits for 0.1 seconds before running the next line, uses encoders
		context.waitForSeconds(0.1);
		//Sets both motors to 0.0 power, motors stop
		Robot.drive.setDrivePower(0.0, 0.0);
	}
}
