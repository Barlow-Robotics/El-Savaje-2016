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

    	frontLeftMotor.set(leftSpeed);
    	backLeftMotor.set(leftSpeed);
    	frontRightMotor.set(rightSpeed);
    	backRightMotor.set(rightSpeed);

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
	
	private double sensitivity = 0.75;
	
	public double getSensitivity() {
		return sensitivity;
	}
	
	public void updateSensitivity() {
		if(OI.logitech.getRawButton(8)){
			sensitivity = 1;
		}
    	if(OI.logitech.getRawButton(7)){
    		sensitivity = 0.75;
    	}
    	if(OI.logitech.getRawButton(9)){
    		sensitivity = 0.5;
    	}
    	if(OI.logitech.getRawButton(11)){
    		sensitivity = 0.25;
    	}
	}


}
