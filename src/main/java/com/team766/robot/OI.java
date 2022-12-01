package com.team766.robot;

import com.team766.framework.Procedure;
import com.team766.framework.Context;
import com.team766.hal.JoystickReader;
import com.team766.hal.RobotProvider;
import com.team766.logging.Category;
import com.team766.robot.procedures.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the code that allow control of the robot.
 */
public class OI extends Procedure {
	private JoystickReader joystick0;
	private JoystickReader joystick1;
	private JoystickReader joystick2;
	private double elevatorUp;

	public OI() {
		loggerCategory = Category.OPERATOR_INTERFACE;

		joystick0 = RobotProvider.instance.getJoystick(0);
		joystick1 = RobotProvider.instance.getJoystick(1);
		joystick2 = RobotProvider.instance.getJoystick(2);
	}
	
	public void run(Context context) {
		context.takeOwnership(Robot.drive);
		context.takeOwnership(Robot.elevator);
		//PS4Controller ourPS4 = new PS4Controller(0); // 0 is the USB Port to be used as indicated on the Driver Station, and ourPS4 is the object name of our PS4 controller.
		
		while (2>1) {

			//REMEMBER: LEFTJOYSTICK1 IS THE X AXIS OF THE LEFT JOYSTICK. LEFTJOYSTICK2 IS THE Y AXIS OF THE LEFT JOYSTICK>
			//CURRENTLY SET TO SPLIT ARCADE DRIVE

			double leftJoystick1 = joystick0.getAxis(1);
			double leftJoystick2 = joystick0.getAxis(0);
			// Add driver controls here - make sure to take/release ownership
			// of mechanisms when appropriate.
			/**log("J0 A0: " + joystick0.getAxis(0) +
			    "  J0 A1: " + joystick0.getAxis(1) +
			    "  J1 A0: " + joystick1.getAxis(0) +
			    "  J1 A1: " + joystick1.getAxis(1) +
			    "  J0 B1: " + joystick0.getButton(1) +
			    "  J0 B2: " + joystick0.getButton(2) +
			    "  J0 B3: " + joystick0.getButton(3));
**/
			log("J0 A1: " + leftJoystick1);
			log(" J0 A0:" + leftJoystick2);

			//Robot.drive.setArcadeDrivePower(leftJoystick1, leftJoystick2);
			Robot.drive.setArcadeDrivePower(leftJoystick1, leftJoystick2);     
			
			if(joystick0.getButton(2)){
				elevatorUp = 1.0;
				log("up button pressed");
			}
			else if(joystick0.getButton(3)){
				elevatorUp = -1.0;
			}
			else {
				elevatorUp = 0.0;
			}

			Robot.elevator.setMotorPower(elevatorUp);
			log(" Elevator: " + elevatorUp);
			context.waitFor(() -> RobotProvider.instance.hasNewDriverStationData());
		}
	}
}
