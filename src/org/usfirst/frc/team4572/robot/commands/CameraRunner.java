package org.usfirst.frc.team4572.robot.commands;

import org.usfirst.frc.team4572.robot.Robot;

import com.ni.vision.NIVision;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CameraRunner extends Command {

    public CameraRunner() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.cameraSystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	NIVision.IMAQdxConfigureGrab(Robot.cameraSystem.session);
    	SmartDashboard.putString("Camera Update", "Initialized");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	NIVision.IMAQdxGrab(Robot.cameraSystem.session, Robot.cameraSystem.frame, 1);
    	CameraServer.getInstance().setImage(Robot.cameraSystem.frame);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	NIVision.IMAQdxStopAcquisition(Robot.cameraSystem.session);
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    }   
}