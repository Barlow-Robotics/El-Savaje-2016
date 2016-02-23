package org.usfirst.frc.team4572.robot.commands;

import org.usfirst.frc.team4572.robot.OI;
import org.usfirst.frc.team4572.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
/**
 *
 */
public class ExtensionRunner extends Command {

    public ExtensionRunner() {
    	requires(Robot.extensionSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    boolean hasToggled = false;
    
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!hasToggled && OI.logitech.getRawButton(1)){
    		hasToggled = true;
    		Robot.extensionSystem.togglePiston();
    	}
    	
    	if(!OI.logitech.getRawButton(1)){
    		hasToggled = false;
    	}
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
