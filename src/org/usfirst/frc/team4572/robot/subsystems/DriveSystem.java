package org.usfirst.frc.team4572.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4572.robot.OI;
import org.usfirst.frc.team4572.robot.Robot;
import org.usfirst.frc.team4572.robot.RobotMap;
import org.usfirst.frc.team4572.robot.commands.DriveRunner;

/**
 *
 */
public class DriveSystem extends Subsystem {

	private final Spark frontLeftMotor = new Spark(RobotMap.FRONT_LEFT_MOTOR_PORT);
	private final Spark frontRightMotor = new Spark(RobotMap.FRONT_RIGHT_MOTOR_PORT);
	private final Spark backLeftMotor = new Spark(RobotMap.BACK_LEFT_MOTOR_PORT);
	private final Spark backRightMotor = new Spark(RobotMap.BACK_RIGHT_MOTOR_PORT);
	
	private double sensitivity = 1;
	private boolean isTwoWheelDrive = false;


//	private final RobotDrive driveTrain = new RobotDrive(
//		frontLeftMotor,
//		frontRightMotor,
//		backLeftMotor,
//		backRightMotor
//	);

    public void initDefaultCommand() {
    	getFrontLeftMotor().setInverted(true);
    	getBackLeftMotor().setInverted(true);
    	setDefaultCommand(new DriveRunner());
    }

    public void drive(double leftSpeed, double rightSpeed) {
    	
    	if(isTwoWheelDrive) {
    		frontLeftMotor.set(0);
    		frontRightMotor.set(0);
    		backLeftMotor.set(leftSpeed);
    		backRightMotor.set(rightSpeed);
    	}
    	else {
        	frontLeftMotor.set(leftSpeed);
        	backLeftMotor.set(leftSpeed);
        	frontRightMotor.set(rightSpeed);
        	backRightMotor.set(rightSpeed);
    	}

    	// tell the drainTrain to drive
    	//driveTrain.tankDrive(left, right);
    }

	public Spark getFrontLeftMotor() {
		return frontLeftMotor;
	}

	public Spark getFrontRightMotor() {
		return frontRightMotor;
	}

	public Spark getBackLeftMotor() {
		return backLeftMotor;
	}

	public Spark getBackRightMotor() {
		return backRightMotor;
	}
	
	public double getSensitivity() {
		return sensitivity;
	}
	
	public void toggleDriveMode() {
		isTwoWheelDrive = !isTwoWheelDrive;
	}
	public void updateSensitivity() {
		
		if(OI.logitech.getRawButton(8) || OI.playstation.getRawButton(7)){
			// System.out.println("PRESSED BUTTON 8");
			sensitivity = 1;
			System.out.println("The sensitivity is now at 100%");
		}
    	
		if(OI.logitech.getRawButton(7) || OI.playstation.getRawButton(5)){
    		// System.out.println("PRESSED BUTTON 7");
    		sensitivity = 0.75;
    		System.out.println("The sensitivity is now at 75%");
    	}
    	
    	if(OI.logitech.getRawButton(9) || OI.playstation.getRawButton(8)){
    		// System.out.println("PRESSED BUTTON 9");
    		sensitivity = 0.60;
    		System.out.println("The sensitivity is now at 60%");
    	}
    	
    	if(OI.logitech.getRawButton(11) || OI.playstation.getRawButton(6)){
    		// System.out.println("PRESSED BUTTON 11");
    		sensitivity = 0.50;
    		System.out.println("The sensitivity is now at 50%");
    	}
	}
}
