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
		RobotMap.FRONT_LEFT_MOTOR_PORT,
		RobotMap.BACK_LEFT_MOTOR_PORT,
		RobotMap.FRONT_RIGHT_MOTOR_PORT,
		RobotMap.BACK_RIGHT_MOTOR_PORT
	);	
    public void initDefaultCommand() {
    	setDefaultCommand(new DriveRunner());
    }
    public void drive(double left, double right) {  
    	
    	// tell the drainTrain to drive
    	driveTrain.tankDrive(left, right);
    	
    	
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

