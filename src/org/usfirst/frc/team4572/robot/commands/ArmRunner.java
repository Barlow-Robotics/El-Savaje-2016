package org.usfirst.frc.team4572.robot.commands;

import org.usfirst.frc.team4572.robot.Robot;
import org.usfirst.frc.team4572.robot.OI;

import edu.wpi.first.wpilibj.command.Command;
/**
 *
 */
public class ArmRunner extends Command {

    public ArmRunner() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.armSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if(OI.logitech.getRawButton(3) || OI.logitech.getRawButton(4)){
    		Robot.armSystem.swingArm(-1);
    	}
    	else if (OI.logitech.getRawButton(5) || OI.logitech.getRawButton(6)) {
    		Robot.armSystem.swingArm(0.7);
    	}
    	else if((OI.logitech.getRawButton(5)  ||
				 OI.logitech.getRawButton(6)) &&
				 OI.logitech.getRawButton(2)) {
    		Robot.armSystem.swingArm(1);
    	}
    	else {
    		Robot.armSystem.swingArm(0);
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
