package com.team766.robot.mechanisms;

import com.team766.framework.Mechanism;
import com.team766.hal.MotorController;
import com.team766.hal.RobotProvider;
import com.team766.hal.EncoderReader;
//This is for the motor that controls the pulley
public class Pulley extends Mechanism {
	//This enables the code to interact with the motor that controls the pulley
	private MotorController PulleyMotor;
	private EncoderReader PulleyEncoder;

	public Pulley() {
		PulleyMotor = RobotProvider.instance.getMotor("PulleyMotor");
		PulleyEncoder = RobotProvider.instance.getEncoder("PulleyEncoder");
	}
	//This allows the pulley motor power to be changed
	//The magnitude ranges from 0.0-1.0, and sign (positive/negative) determines the direction
	public void setPulleyPower(double power) {
		checkContextOwnership();
		PulleyMotor.set(power);
	}

	public double getEncoderDistance() {
		return PulleyEncoder.getDistance();
	}
}