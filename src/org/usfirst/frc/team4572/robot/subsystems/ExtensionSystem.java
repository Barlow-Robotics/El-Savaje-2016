package org.usfirst.frc.team4572.robot.subsystems;

import org.usfirst.frc.team4572.robot.RobotMap;
import org.usfirst.frc.team4572.robot.commands.ExtensionRunner;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ExtensionSystem extends Subsystem {
    
//	private Solenoid backSolenoid = new Solenoid(RobotMap.BACK_SOLENOID_PORT);
//	private Solenoid frontSolenoid = new Solenoid(RobotMap.FRONT_SOLENOID_PORT);
// 
//    private boolean pistonOpen = false;	
//    
//    public void initDefaultCommand() {
//        // Set the default command for a subsystem here.
//        //setDefaultCommand(new MySpecialCommand());
//    	setPiston(pistonOpen);
//    	setDefaultCommand(new ExtensionRunner());
//    }
//    
//    public void togglePiston() {
//		pistonOpen = !pistonOpen;
//		backSolenoid.set(pistonOpen);
//		frontSolenoid.set(pistonOpen);
//	}
//    
//    private void setPiston(boolean state) {
//    	backSolenoid.set(state);
//    	frontSolenoid.set(!state);
//    }
	private Solenoid pistonSolenoid = new Solenoid(RobotMap.BACK_SOLENOID_PORT);
 
    private boolean pistonOpen = false;	
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setPiston(pistonOpen);
    	setDefaultCommand(new ExtensionRunner());
    }
    
    public void togglePiston() {
		pistonOpen = !pistonOpen;
		pistonSolenoid.set(pistonOpen);
	}
    
    private void setPiston(boolean state) {
    	pistonSolenoid.set(state);
    }
}


