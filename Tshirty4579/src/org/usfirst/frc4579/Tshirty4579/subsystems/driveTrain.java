// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4579.Tshirty4579.subsystems;

import org.usfirst.frc4579.Tshirty4579.Robot;
import org.usfirst.frc4579.Tshirty4579.RobotMap;
import org.usfirst.frc4579.Tshirty4579.commands.*;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class driveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController leftFront = RobotMap.driveTrainleftFront;
    private final SpeedController leftBack = RobotMap.driveTrainleftBack;
    private final SpeedController rightBack = RobotMap.driveTrainrightBack;
    private final SpeedController rightFront = RobotMap.driveTrainrightFront;
    private final RobotDrive robotDrive = RobotMap.driveTrainrobotDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    double lastX = 0;
    double lastY = 0;    
    double lastZ = 0;
    
    public void drive(double sensitivity){
    	// Getting raw joystick values
    	double x = Robot.oi.joystick1.getX();
    	double y = Robot.oi.joystick1.getY();
    	double z = Robot.oi.joystick1.getTwist();
    	
    	// Filters the joystick values
    	double xOut = (sensitivity * (0.75 * lastX + 0.25 * x));
    	double yOut = (sensitivity * (0.75 * lastY + 0.25 * y));
    	double zOut = (sensitivity * (0.75 * lastZ + 0.25 * z));
    	
    	//Squaring the inputs
    	xOut = Math.pow(xOut, 3);
    	yOut = Math.pow(yOut, 3);
    	zOut = Math.pow(zOut, 3);
    	
    	// Sets the drive speed
    	robotDrive.mecanumDrive_Cartesian(xOut, yOut, zOut, 0);
    	
    	// Remembers the past values
    	lastX = xOut;
    	lastY = yOut;
    	lastZ = zOut;
    }
    
    public void stop(){
    	robotDrive.stopMotor();
    }
    
    
    public void fullSpeed(double x){
    	leftFront.set(x);
    	rightFront.set(x);
    	leftBack.set(x);
    	rightBack.set(x);
    }
    
    
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new drive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}

