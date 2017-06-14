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

import org.usfirst.frc4579.Tshirty4579.RobotMap;
import org.usfirst.frc4579.Tshirty4579.commands.*;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class shooter extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final Solenoid robotSole = RobotMap.shooterrobotSole;
    private final Compressor compressor = RobotMap.shootercompressor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    
    int setting = 1;
    
    public void toggle(){
    	if (setting == 1){
    		setting ++;
    	}
    	else if (setting == 2){
    		setting = 1;
    	}
    	else{
    		System.out.println("Error in calculating the setting. Shooting at the first setting");
    		setting = 1;
    	}
    }
    
    
    // the robot shoots depending on what setting it is at
    public void shoot(){
    	if (setting == 1){
    		robotSole.set(true);
    		Timer.delay(.02);
    	}
    	else if (setting == 2){
    		robotSole.set(true);
    		Timer.delay(.06);
    	}
    	robotSole.set(false);
    }
    
    public void compressorState(){
    	if (compressor.enabled()){
    		compressor.stop();
    	}
    	else{
    		compressor.start();
    	}
    }
    
    public void startCompressor(){
    	compressor.setClosedLoopControl(true);
    }
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
}

