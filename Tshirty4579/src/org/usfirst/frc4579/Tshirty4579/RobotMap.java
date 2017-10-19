// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4579.Tshirty4579;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController driveTrainleftFront;
    public static SpeedController driveTrainleftBack;
    public static SpeedController driveTrainrightBack;
    public static SpeedController driveTrainrightFront;
    public static RobotDrive driveTrainrobotDrive;
    public static SpeedController aimeraimMotor;
    public static DigitalInput aimerfrontSwitch;
    public static DigitalInput aimerbackSwitch;
    public static Solenoid shooterrobotSole;
    public static Compressor shootercompressor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainleftFront = new VictorSP(0);
        LiveWindow.addActuator("driveTrain", "leftFront", (VictorSP) driveTrainleftFront);
        
        driveTrainleftBack = new VictorSP(1);
        LiveWindow.addActuator("driveTrain", "leftBack", (VictorSP) driveTrainleftBack);
        
        driveTrainrightBack = new VictorSP(2);
        LiveWindow.addActuator("driveTrain", "rightBack", (VictorSP) driveTrainrightBack);
        
        driveTrainrightFront = new VictorSP(3);
        LiveWindow.addActuator("driveTrain", "rightFront", (VictorSP) driveTrainrightFront);
        
        driveTrainrobotDrive = new RobotDrive(driveTrainleftFront, driveTrainleftBack,
              driveTrainrightFront, driveTrainrightBack);
        
        driveTrainrobotDrive.setSafetyEnabled(true);
        driveTrainrobotDrive.setExpiration(0.1);
        driveTrainrobotDrive.setSensitivity(0.5);
        driveTrainrobotDrive.setMaxOutput(1.0);

        driveTrainrobotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        driveTrainrobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        aimeraimMotor = new VictorSP(4);
        LiveWindow.addActuator("aimer", "aimMotor", (VictorSP) aimeraimMotor);
        
        aimerfrontSwitch = new DigitalInput(0);
        LiveWindow.addSensor("aimer", "frontSwitch", aimerfrontSwitch);
        
        aimerbackSwitch = new DigitalInput(1);
        LiveWindow.addSensor("aimer", "backSwitch", aimerbackSwitch);
        
        shooterrobotSole = new Solenoid(0, 0);
        LiveWindow.addActuator("shooter", "robotSole", shooterrobotSole);
        
        shootercompressor = new Compressor(1);
        
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        /*skfljal
        dsfkhasdjf
        asdfjkldjf
        dsfjklsdjf
        dshfjksadhf
        dfahkdsafj
        hdsfka
        */
        
        
        
        
    }
}
