
package org.usfirst.frc.team4572.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;

import org.usfirst.frc.team4572.robot.RobotMap;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
    public static Joystick playstation = new Joystick(RobotMap.PS_CONTROLLER_PORT);
    public static Joystick logitech = new Joystick(RobotMap.LOGITECH_CONTROLLER_PORT);

	public static double getDriveLeft() {
		//return stick.getAxis(AxisType.kY);
		return playstation.getY();
	}
	
	public static double getDriveRight() {
		return playstation.getThrottle();
	}

	public static double armSpeed(){
		return logitech.getY();
	}

}
