package org.usfirst.frc.team4572.robot.subsystems;

import org.usfirst.frc.team4572.robot.commands.CameraRunner;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class CameraSystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public boolean visionTracking = false;
	public int session = NIVision.IMAQdxOpenCamera("cam0",
			NIVision.IMAQdxCameraControlMode.CameraControlModeController);
    public Image frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
    
    public void initDefaultCommand() {
        setDefaultCommand(new CameraRunner());
    }
}

