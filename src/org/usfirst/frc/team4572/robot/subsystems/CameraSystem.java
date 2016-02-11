package org.usfirst.frc.team4572.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc.team4572.robot.commands.CameraRunner;
import org.usfirst.frc.team4572.robot.commands.DriveRunner;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

/**
 *
 */
public class CameraSystem extends Subsystem {
    
	public int session = NIVision.IMAQdxOpenCamera(
			"cam0",
			NIVision.IMAQdxCameraControlMode.CameraControlModeController
		);
    public Image frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new CameraRunner());
    } 
}

