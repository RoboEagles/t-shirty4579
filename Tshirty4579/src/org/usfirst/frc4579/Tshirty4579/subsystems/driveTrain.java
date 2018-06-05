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
import org.usfirst.frc4579.filters.AverageFilter;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class driveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final Encoder leftEncoder = RobotMap.driveTrainleftEncoder;
    private final SpeedController leftFront = RobotMap.driveTrainleftFront;
    private final SpeedController leftBack = RobotMap.driveTrainleftBack;
    private final SpeedController rightBack = RobotMap.driveTrainrightBack;
    private final SpeedController rightFront = RobotMap.driveTrainrightFront;
    private final MecanumDrive robotDrive = RobotMap.driveTrainrobotDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    double lastX = 0;
    double lastY = 0;    
    double lastZ = 0;
    double xOut = 0;
    double yOut = 0;
    double zOut = 0;
    
    AverageFilter filter = new AverageFilter(5);
    
    double rotation = 0;
    
    public void drive(double sensitivity){
    	// Getting raw joystick values 
    	double x = -Robot.oi.joystick.getX();
    	double y = -Robot.oi.joystick.getY();
    	double z = .75 * Robot.oi.joystick.getTwist();
    	
    	//Create a joystick dead zone.
    	if (Math.abs(x) < 0.02) x = 0.0;
    	if (Math.abs(y) < 0.02) y = 0.0;
    	if (Math.abs(z) < 0.02) z = 0.0;
    	
    	//Cubing the inputs
    	xOut = Math.signum(x) * Math.pow(x, 1.5);
    	yOut = Math.signum(y) * Math.pow(y, 1.5);
    	zOut = Math.signum(z) * Math.pow(z, 1.5);
    	
    	// Filters the joystick values
    	xOut = (sensitivity * (0.5 * lastX + 0.5 * x));
    	yOut = (sensitivity * (0.5 * lastY + 0.5 * y));
    	zOut = (sensitivity * (0.5 * lastZ + 0.5 * z));
    	
    	SmartDashboard.putNumber("Joystick X: ", xOut);
    	SmartDashboard.putNumber("Joystick Y: ", yOut);
    	SmartDashboard.putNumber("Joystick Z: ", zOut);

    	// Sets the drive speed
    	robotDrive.driveCartesian(xOut, yOut, zOut);
  
    	
    	//robotDrive.drivePolar(yOut, xOut*180, zOut);

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
    
    public double getEncoder(){
    	rotation = leftEncoder.getDistance();
    	
    	return rotation;
    }
    
    public void resetEncoder(){
    	leftEncoder.reset();
    }
    
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new drive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}

