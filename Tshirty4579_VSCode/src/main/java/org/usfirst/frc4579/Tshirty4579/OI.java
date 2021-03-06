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

import org.usfirst.frc4579.Tshirty4579.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc4579.Tshirty4579.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton shootButton;
    public JoystickButton toggleButton;
    public JoystickButton canonUp;
    public JoystickButton canonDown;
    public JoystickButton speedButton;
    public JoystickButton compressorButton;
    public Joystick joystick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public JoystickButton shootButtonXbox;
    public JoystickButton toggleButtonXbox;
    public JoystickButton canonUpXbox;
    public JoystickButton canonDownXbox;
    public JoystickButton speedButtonXbox;
    public JoystickButton compressorButtonXbox;
    
    public XboxController controller;
    
    public OI() {
    	controller = new XboxController(3);
    	
        compressorButton = new JoystickButton(controller, 9);
        compressorButton.whenPressed(new changeCompressor());
        speedButton = new JoystickButton(controller, 12);
        speedButton.whenPressed(new fullSpeed());
        canonDown = new JoystickButton(controller, 3);
        canonDown.whileHeld(new aim());
        canonUp = new JoystickButton(controller, 5);
        canonUp.whileHeld(new aim());
        toggleButton = new JoystickButton(controller, 2);
        toggleButton.whenPressed(new shootToggle());
        shootButton = new JoystickButton(controller, 1);
        shootButton.whenPressed(new shoot());
        
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        joystick = new Joystick(0);
        
        compressorButton = new JoystickButton(joystick, 9);
        compressorButton.whenPressed(new changeCompressor());
        speedButton = new JoystickButton(joystick, 12);
        speedButton.whenPressed(new fullSpeed());
        canonDown = new JoystickButton(joystick, 3);
        canonDown.whileHeld(new aim());
        canonUp = new JoystickButton(joystick, 5);
        canonUp.whileHeld(new aim());
        toggleButton = new JoystickButton(joystick, 2);
        toggleButton.whenPressed(new shootToggle());
        shootButton = new JoystickButton(joystick, 1);
        shootButton.whenPressed(new shoot());


        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("shoot", new shoot());
        SmartDashboard.putData("drive", new drive());
        SmartDashboard.putData("shootToggle", new shootToggle());
        SmartDashboard.putData("aim", new aim());
        SmartDashboard.putData("fullSpeed", new fullSpeed());
        SmartDashboard.putData("changeCompressor", new changeCompressor());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getjoystick() {
        return joystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

