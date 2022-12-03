package com.team766.robot.mechanisms;

import com.team766.framework.Mechanism;
import com.team766.hal.EncoderReader;
import com.team766.hal.MotorController;
import com.team766.hal.RobotProvider;
import com.team766.hal.GyroReader;
//This enables the code to interact with the drive motors, gyroscope, and encodes
//Encoders use wheel speed and time to determine how far the robot has travelled
public class Drive extends Mechanism {
	//This enables the code to interact with the drive motors, encoders, and gyroscope
	private MotorController leftMotor;
	private MotorController rightMotor;
	private EncoderReader leftEncoder;
	private EncoderReader rightEncoder;
	private GyroReader gyro;

	public Drive() {
		leftMotor = RobotProvider.instance.getMotor("drive.leftMotor");
		rightMotor = RobotProvider.instance.getMotor("drive.rightMotor");
		leftEncoder = RobotProvider.instance.getEncoder("drive.leftEncoder");
		rightEncoder = RobotProvider.instance.getEncoder("drive.rightEncoder");
		gyro = RobotProvider.instance.getGyro("drive.gyro");
	}
	//This allows the drive motor power to be changed
	//The magnitude ranges from 0.0-1.0, and sign (positive/negative) determines the direction
	public void setDrivePower(double leftPower, double rightPower) {
		checkContextOwnership();

		leftMotor.set(leftPower);
		rightMotor.set(rightPower);
	}
	//This is an improved version of setDrivePower
	public void setArcadeDrivePower(double forward, double turn) {
		double leftMotorPower = (turn + forward);
		double rightMotorPower = -turn + forward;
		setDrivePower(leftMotorPower, rightMotorPower);
	}
	//These controls are a finer version (will have less response) than the others
	//The difference is currently by a factor of 0.2, but that can be changed
	public void setArcadeDrivePowerFine(double forward, double turn) {
		double leftMotorPower = 0.2 * (turn + forward);
		double rightMotorPower = 0.2 * (-turn + forward);
		setDrivePower(leftMotorPower, rightMotorPower);
	}
	//This gets the distance that the robot has travelled from the encoders
	//It starts counting from the last time the encoder was reset
	public double getEncoderDistance() {
		double leftValue = leftEncoder.getDistance();
		double rightValue = rightEncoder.getDistance();
		log("Encoders: " + leftValue + " " + rightValue);
		return (leftValue + rightValue) / 2;
	}
	//This resets (zeros) the encoders
	public void resetEncoders() {
		checkContextOwnership();
		leftEncoder.reset();
		rightEncoder.reset();
	}
	//This gets the amount that the robot has turned in degrees using the gyroscope
	//0° is the angle of the robot when the gyroscope was last reset
	public double getGyroAngle() {
		double angle = gyro.getAngle();
		return angle;
	}
	//This resets (zeros) the gyroscope
	public void resetGyro() {
		checkContextOwnership();
		gyro.reset();
	}
}
