
package org.usfirst.frc.team4572.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team4572.robot.subsystems.ArmSystem;
import org.usfirst.frc.team4572.robot.subsystems.CameraSystem;
import org.usfirst.frc.team4572.robot.subsystems.DriveSystem;
import org.usfirst.frc.team4572.robot.subsystems.ExtensionSystem;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */

public class Robot extends IterativeRobot {

	public static CameraSystem cameraSystem;
	public static DriveSystem driveSystem;
	public static ArmSystem armSystem;
	public static OI oi = new OI();
	public static ExtensionSystem extensionSystem;
	Command autonomousCommand;
	SendableChooser chooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		cameraSystem = new CameraSystem();
		driveSystem = new DriveSystem();
		armSystem = new ArmSystem();
		extensionSystem = new ExtensionSystem();
		chooser = new SendableChooser();
		SmartDashboard.putData("Auto mode", chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	private double start;
	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	public void autonomousInit() {
		autonomousCommand = (Command) chooser.getSelected();
		
		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
		
		start = 0.0;
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();

		if(start < 0.1) start = System.currentTimeMillis();
    	
		double time = System.currentTimeMillis() - start;
    	SmartDashboard.putNumber("Time: ", time);
    	
    	if(time / 1000.0 < 3) {
    		driveSystem.drive(1.0, 1.0);
    		System.out.println("time: " + time);
    	} else {
    		driveSystem.drive(0.0, 0.0);
    		System.out.println("done");
    	}
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

		if (OI.playstation.getRawButton(5)){
			driveSystem.getBackLeftMotor().set(0.7);
			driveSystem.getFrontLeftMotor().set(0.7);
		}
		if (OI.playstation.getRawButton(6)){
			driveSystem.getBackRightMotor().set(0.7);
			driveSystem.getFrontRightMotor().set(0.7);
			System.out.println("Front Right");
		}
		if (OI.playstation.getRawButton(1)) {
			driveSystem.getFrontLeftMotor().set(0.7);
		}
		if(OI.playstation.getRawButton(2)){
			driveSystem.getFrontRightMotor().set(0.7);
		}
		if(OI.playstation.getRawButton(3)){
			driveSystem.getBackLeftMotor().set(0.7);
			System.out.println("Back Left");
		}
		if(OI.playstation.getRawButton(4)){
			driveSystem.getBackRightMotor().set(0.7);
			System.out.println("Back Right");
		}
	}

	public void testInit() {
		driveSystem.getFrontLeftMotor().set(0.7);
		Timer.delay(3.0);
		driveSystem.getFrontLeftMotor().set(0.0);

		driveSystem.getBackLeftMotor().set(0.7);
		Timer.delay(3.0);
		driveSystem.getBackLeftMotor().set(0.0);

		driveSystem.getFrontRightMotor().set(0.7);
		Timer.delay(3.0);
		driveSystem.getFrontRightMotor().set(0.0);

		driveSystem.getBackRightMotor().set(0.7);
		Timer.delay(3.0);
		driveSystem.getBackRightMotor().set(0.0);
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
