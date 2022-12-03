package com.team766.robot.mechanisms;
import com.team766.framework.Mechanism;
import com.team766.hal.MotorController;
import com.team766.hal.RobotProvider;

public class Elevator extends Mechanism {
	private MotorController elevatorMotor;
	public Elevator(){
		elevatorMotor = RobotProvider.instance.getMotor("elevator.Motor");
	}
	public void setElevatorPower(double elevatePower){
		checkContextOwnership();
		elevatorMotor.set(elevatePower);

	}
}
