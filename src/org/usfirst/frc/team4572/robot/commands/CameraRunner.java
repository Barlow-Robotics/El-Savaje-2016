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

    public CameraRunner(){
        requires(Robot.camera);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	NIVision.IMAQdxConfigureGrab(Robot.camera.session);
    	SmartDashboard.putString("Camera Update", "Initialized");
    	SmartDashboard.putBoolean("Camera Light On: ", false);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	NIVision.IMAQdxGrab(Robot.camera.session, Robot.camera.frame, 1);
        if (Robot.camera.visionTracking == false){
    		CameraServer.getInstance().setImage(Robot.camera.frame);
    	}
    	//CameraServer.getInstance().setImage(camera.frame);
    	//camera.numCommands++;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	NIVision.IMAQdxStopAcquisition(Robot.camera.session);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
