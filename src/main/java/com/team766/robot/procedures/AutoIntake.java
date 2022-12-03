package com.team766.robot.procedures;

import com.team766.framework.Procedure;
import com.team766.framework.Context;
import com.team766.robot.Robot;
//Ignore this whole thing
public class AutoIntake extends Procedure {
	public void run(Context context) {
		context.takeOwnership(Robot.intake);
		Robot.intake.startIntake();
		context.waitForSeconds(3.0);
		Robot.intake.stopIntake();
	}
}
