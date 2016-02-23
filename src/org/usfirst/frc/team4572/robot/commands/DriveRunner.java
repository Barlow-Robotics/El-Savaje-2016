package org.usfirst.frc.team4572.robot.commands;
import org.usfirst.frc.team4572.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4572.robot.OI;

/**
 *
 */
public class DriveRunner extends Command {

	private boolean hasToggled = false;	
	
    public DriveRunner() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {

    }
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveSystem.updateSensitivity();
    	
    	if(OI.logitech.getRawButton(12) && !hasToggled){
    		Robot.driveSystem.toggleDriveMode();
			hasToggled = true;
    	}
    	
    	if (!OI.logitech.getRawButton(12)) {
    		hasToggled = false;
    	}
    	
    	Robot.driveSystem.drive(
    		OI.getDriveLeft() * Robot.driveSystem.getSensitivity(),
    		OI.getDriveRight() * Robot.driveSystem.getSensitivity()
    	);
    	
//    	Robot.driveSystem.drive(OI.getDriveLeft(), OI.getDriveRight());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
