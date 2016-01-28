package org.usfirst.frc.team4572.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
	
	// CONTROLLERS
	public static final int PS_CONTROLLER_PORT = 0;
	public static final int LOGITECH_CONTROLLER_PORT = 1;
	
	// MOTORS
	public static final int FRONT_LEFT_MOTOR_PORT = 1;
	public static final int FRONT_RIGHT_MOTOR_PORT = 2;
	public static final int BACK_LEFT_MOTOR_PORT = 3;
	public static final int BACK_RIGHT_MOTOR_PORT = 4;
	public static final int ARM_MOTOR_PORT = 5;
	
	//PNEUMATICS
	public static final int RIGHT_SOLENOID_PORT = 6;
	public static final int LEFT_SOLENOID_PORT = 7;
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
