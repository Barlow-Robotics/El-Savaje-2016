package org.usfirst.frc.team4572.robot.subsystems;

import org.usfirst.frc.team4572.robot.RobotMap;
import org.usfirst.frc.team4572.robot.commands.ArmRunner;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArmSystem extends Subsystem {
    
	private final Talon armMotor = new Talon(RobotMap.ARM_MOTOR_PORT);
    
    public void initDefaultCommand() {
    	setDefaultCommand(new ArmRunner());
    }
    
    public void swingArm(double motorSpeed){
    	armMotor.set(motorSpeed);
    }
    
}

