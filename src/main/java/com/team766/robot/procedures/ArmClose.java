package com.team766.robot.procedures;

import com.team766.framework.Procedure;
import com.team766.framework.Context;
import com.team766.robot.Robot;
//This uses Arm.java code to close the arm
public class ArmClose extends Procedure {
	public void run(Context context) {
		context.takeOwnership(Robot.arm);
		//Sets the arm motor to -0.2
		Robot.arm.setArmPower(-0.2);
		//Waits 0.5 seconds
		context.waitForSeconds(0.5);
		//Sets the arm motor to 0.0, motor stops
		Robot.arm.setArmPower(0.0);
	}
}
