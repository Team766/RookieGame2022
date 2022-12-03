package com.team766.robot.procedures;

import com.team766.framework.Procedure;
import com.team766.framework.Context;
import com.team766.robot.Robot;
//This is the code to open the arm
public class ArmOpen extends Procedure {
	public void run(Context context) {
		context.takeOwnership(Robot.arm);
		//Sets the arm motor power to 0.2
		Robot.arm.setArmPower(0.2);
		//Waits 0.5 seconds 
		context.waitForSeconds(0.5);
		//Sets the arm motor power to 0.0, motor stops
		Robot.arm.setArmPower(0.0);
	}
}
