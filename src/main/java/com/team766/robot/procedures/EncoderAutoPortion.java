package com.team766.robot.procedures;

import com.team766.framework.Procedure;
import com.team766.framework.Context;
import com.team766.robot.Robot;
//This does the autonomous stuff at the beginning
public class EncoderAutoPortion extends Procedure{
	public void run(Context context) {
		context.takeOwnership(Robot.drive);
		//Sets encoder distance to 0
		Robot.drive.resetEncoders();
		//Sets both motors to 0.25 power
		Robot.drive.setDrivePower(0.25, 0.25);
		//Waits for the robot to move 40.0 inches before running the next line, uses encoders
		context.waitFor(() -> Robot.drive.getEncoderDistance() >= 40.0);
		//Sets both motors to 0.15 power
		Robot.drive.setDrivePower(0.15, 0.15);
		//Waits for the robot to move 50.0 (an additional 10.0) inches before running the next line, uses encoders
		context.waitFor(() -> Robot.drive.getEncoderDistance() >= 50.0);
		//Sets both motors to 0.1 power
		Robot.drive.setDrivePower(0.1, 0.1);
		//Waits for the robot to move 57.0 (an additional 7.0) inches before running the next line, uses encoders
		context.waitFor(() -> Robot.drive.getEncoderDistance() >= 57.0);
		//Sets both motors to 0.01 power
		Robot.drive.setDrivePower(0.01, 0.01);
		//Waits for the robot to move 59.0 (an additional 2.0) inches before running the next line, uses encoders
		context.waitFor(() -> Robot.drive.getEncoderDistance() >= 59.0);
		//Sets both motors to 0.0 power, motors stop
		Robot.drive.setDrivePower(0.0, 0.0);
		System.out.println(Robot.drive.getEncoderDistance());
		//Waits for the robot to move 66.0 (an additional 7.0) inches before running the next line, uses encoders
		context.waitFor(() -> Robot.drive.getEncoderDistance() >= 63.0);
		//Sets both motors to -0.05 power
		//This, along with the previous line, will correct the robot if it overshoots the target a little bit
		Robot.drive.setDrivePower(-0.05, -0.05);
		//Waits 0.5 seconds before running the next line
		context.waitFor(() -> Robot.drive.getEncoderDistance() <= 61.0);
		//Sets both motors to 0.0 power, motors stop
		Robot.drive.setDrivePower(0.0, 0.0);
	}
}
