package org.usfirst.frc.team4572.robot.subsystems;

import org.usfirst.frc.team4572.robot.RobotMap;
import org.usfirst.frc.team4572.robot.commands.ArmRunner;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ArmSystem extends Subsystem {
    private final Spark armMotor = new Spark(RobotMap.ARM_MOTOR_PORT);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ArmRunner());
    }
    public void swingArm(double motorSpeed){
    	armMotor.set(motorSpeed);
    }
}

