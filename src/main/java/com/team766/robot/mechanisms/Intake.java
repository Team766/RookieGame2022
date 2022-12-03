package com.team766.robot.mechanisms;

import com.team766.framework.Mechanism;
import com.team766.hal.MotorController;
import com.team766.hal.RobotProvider;
import com.team766.hal.SolenoidController;
//Ignore this whole thing
public class Intake extends Mechanism {
	private SolenoidController intakeArmStatus;
	private MotorController intakeWheelsStatus;

	public Intake() {
		intakeArmStatus = RobotProvider.instance.getSolenoid("intakeArm");
		intakeWheelsStatus = RobotProvider.instance.getMotor("intakeWheels");
	}

	public void startIntake() {
		intakeArmStatus.set(true);
		intakeWheelsStatus.set(1);
	}

	public void stopIntake() {
		intakeArmStatus.set(false);
		intakeWheelsStatus.set(0);
	}
}
