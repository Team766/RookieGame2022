package com.team766.robot.mechanisms;

import com.team766.framework.Mechanism;
import com.team766.hal.MotorController;
import com.team766.hal.RobotProvider;
//This is for the motor that controls the arm
public class Arm extends Mechanism{
	//This enables the code to interact with the motor that controls the arm
	private MotorController ArmMotor;

	public Arm() {
		ArmMotor = RobotProvider.instance.getMotor("ArmMotor");
	}
	//This allows the arm motor power to be changed
	//The magnitude ranges from 0.0-1.0, and sign (positive/negative) determines the direction
	public void setArmPower(double power) {
		checkContextOwnership();
		ArmMotor.set(power);
	}
}
