package com.team766.robot;

import com.team766.robot.mechanisms.*;

public class Robot {
	// Declare mechanisms here
	public static Drive drive;
	public static Launcher launcher;
	public static Intake intake;
	public static Pulley pulley;
	public static Arm arm;

	public static void robotInit() {
		// Initialize mechanisms here
		drive = new Drive();
		launcher = new Launcher();
		intake = new Intake();
		pulley = new Pulley();
		arm = new Arm();
	}
}
