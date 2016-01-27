package org.usfirst.frc.team4572.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4572.robot.RobotMap;
import org.usfirst.frc.team4572.robot.commands.DriveRunner;

/**
 *
 */
public class DriveSystem extends Subsystem {
	
	private final Talon frontLeftMotor = new Talon(RobotMap.FRONT_LEFT_MOTOR_PORT);
	private final Talon frontRightMotor = new Talon(RobotMap.FRONT_RIGHT_MOTOR_PORT);
	private final Talon backLeftMotor = new Talon(RobotMap.BACK_LEFT_MOTOR_PORT);
	private final Talon backRightMotor = new Talon(RobotMap.BACK_RIGHT_MOTOR_PORT);
	
	
	private final RobotDrive driveTrain = new RobotDrive(
		frontLeftMotor,
		frontRightMotor,
		backLeftMotor,
		backRightMotor
	);
	
    public void initDefaultCommand() {
    	getFrontLeftMotor().setInverted(true);
    	getBackLeftMotor().setInverted(true);
    	setDefaultCommand(new DriveRunner());
    }
    
    public void drive(double leftSpeed, double rightSpeed) {
    	
    	//DRIVE THE THING BY LEFTSPPEEDDD
    	
    	frontLeftMotor.set(leftSpeed);
    	backLeftMotor.set(leftSpeed);
    	frontRightMotor.set(rightSpeed);
    	backRightMotor.set(rightSpeed);
    	
    	// tell the drainTrain to drive
    	//driveTrain.tankDrive(left, right);
    	
    	
    	
    }
    
	public Talon getFrontLeftMotor() {
		return frontLeftMotor;
	}
	
	public Talon getFrontRightMotor() {
		return frontRightMotor;
	}
	
	public Talon getBackLeftMotor() {
		return backLeftMotor;
	}
	
	public Talon getBackRightMotor() {
		return backRightMotor;
	}
	
	public RobotDrive getDriveTrain() {
		return driveTrain;
		
	}
	
}

