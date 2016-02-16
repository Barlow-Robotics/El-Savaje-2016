package org.usfirst.frc.team4572.robot.subsystems;

import org.usfirst.frc.team4572.robot.RobotMap;
import org.usfirst.frc.team4572.robot.commands.ExtensionRunner;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ExtensionSystem extends Subsystem {
    
	private Solenoid pistonSolenoid = new Solenoid(RobotMap.EXTENSTION_SOLENOID_PORT);
 
    private boolean solenoidOpen = false;	
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	pistonSolenoid.set(solenoidOpen);
    	setDefaultCommand(new ExtensionRunner());
    }
    
	public void toggleSolenoid() {
		solenoidOpen = !solenoidOpen;
		pistonSolenoid.set(solenoidOpen);
	}
    
//    public void openSolenoid(){
//    	pistonSolenoid.set(true);
//    }
//    public void closeSolenoid(){
//    	pistonSolenoid.set(false);
//
//    }
}

