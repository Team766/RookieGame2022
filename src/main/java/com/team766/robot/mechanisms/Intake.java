package com.team766.robot.mechanisms;
import com.team766.framework.Mechanism;
import com.team766.hal.MotorController;
import com.team766.hal.RobotProvider;

public class Intake extends Mechanism {
	private MotorController leftIntake;
	private MotorController rightIntake;
	public Intake(){
		leftIntake = RobotProvider.instance.getMotor("intakeWheels");
		rightIntake = RobotProvider.instance.getMotor("intakeWheels");
	}

	public void setIntakePower(double giveOrTake){
		checkContextOwnership();

		leftIntake.set(-giveOrTake);
		rightIntake.set(-giveOrTake);
	}
}
