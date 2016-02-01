package org.usfirst.frc.team4572.robot.subsystems;

import org.usfirst.frc.team4572.robot.commands.ExtensionRunner;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ExtensionSystem extends Subsystem {
    private Solenoid rightSolenoid = new Solenoid(1);
    private Solenoid leftSolenoid = new Solenoid(2);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ExtensionRunner());
    }
    public void openSolenoid(){
    	leftSolenoid.set(true);
    	rightSolenoid.set(true);
    }
    public void closeSolenoid(){
    	leftSolenoid.set(false);
    	rightSolenoid.set(false);
    }
}

