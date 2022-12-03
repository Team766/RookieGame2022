package com.team766.robot.procedures;

import com.team766.framework.Procedure;
import com.team766.framework.Context;
import com.team766.robot.Robot;
//Lowers the elevator, cord is unspooled from the pulley
public class PulleyDown extends Procedure {
	public void run(Context context) {
		context.takeOwnership(Robot.pulley);
		//Sets the pulley motor power to -0.2
		Robot.pulley.setPulleyPower(-0.2);
		//Waits for 0.5 seconds
		context.waitForSeconds(0.5);
		//Sets the pulley motor power to 0.0, motor stops
		Robot.pulley.setPulleyPower(0.0);
	}
}