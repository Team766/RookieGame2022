
package com.team766.robot.mechanisms;

import com.team766.framework.Mechanism;
import com.team766.hal.MotorController;
import com.team766.hal.RobotProvider;

public class ElevatorWidth extends Mechanism {
	private MotorController motor;

	public ElevatorWidth(){
		motor = RobotProvider.instance.getMotor("elevatorWidth.motorWidth");
	}

	public void setElevatorWidthMotorPower(double motorPower){
		checkContextOwnership();
		double motorPowerElevator = motorPower;

		motor.set(motorPower);

	}
}

