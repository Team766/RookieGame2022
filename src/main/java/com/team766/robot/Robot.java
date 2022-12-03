package com.team766.robot;

import com.team766.robot.mechanisms.*;

public class Robot {
	// Declare mechanisms here
	public static Drive drive;
	public static Intake intake;
	public static Elevator elevator;
	public static OI m_oi;

	public static void robotInit() {
		// Initialize mechanisms here
		drive = new Drive();
		m_oi = new OI();
		intake = new Intake();
		elevator = new Elevator();
	}
}
