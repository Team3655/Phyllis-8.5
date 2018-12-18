/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.company;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI 
{
    // CREATING BUTTONS
    // One type of button is a joystick button which is any button on a
    // joystick.
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

    // Start the command when the button is released and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    public static Joystick driver = new Joystick(0);
    public static Joystick controlDeck = new Joystick(1);
    public static Joystick takeOver = new Joystick(2);

    //takeOver trigger
    public static Button command = new JoystickButton(takeOver,1);

    public static Button button1 =  new JoystickButton(controlDeck, 1);
    public static Button button2 =  new JoystickButton(controlDeck, 2);
    public static Button button3 =  new JoystickButton(controlDeck, 3);
    public static Button button4 =  new JoystickButton(controlDeck, 4);
    public static Button button5 =  new JoystickButton(controlDeck, 5);
    public static Button button6 =  new JoystickButton(controlDeck, 6);
    public static Button button7 =  new JoystickButton(controlDeck, 7);
    public static Button button8 =  new JoystickButton(controlDeck, 8);
    public static Button button9 =  new JoystickButton(controlDeck, 9);
    public static Button button10 =  new JoystickButton(controlDeck, 10);
    public static Button button11 =  new JoystickButton(controlDeck, 11);
    public static Button button12 =  new JoystickButton(controlDeck, 12);
    public static Button button13 =  new JoystickButton(controlDeck, 13);
    public static Button button14 =  new JoystickButton(controlDeck, 14);
    public static Button button15 =  new JoystickButton(controlDeck, 15);
    public static Button button16 =  new JoystickButton(controlDeck, 16);
    public static Button button17 =  new JoystickButton(controlDeck, 17);
    public static Button button18 =  new JoystickButton(controlDeck, 18);
    public static Button button19 =  new JoystickButton(controlDeck, 19);
    public static Button button20 =  new JoystickButton(controlDeck, 20);
    public static Button button21 =  new JoystickButton(controlDeck, 21);
    public static Button button22 =  new JoystickButton(controlDeck, 22);
    public static Button button23 =  new JoystickButton(controlDeck, 23);
    public static Button button24 =  new JoystickButton(controlDeck, 24);
    public static Button button25 =  new JoystickButton(driver, 1);
    public static Button button26 =  new JoystickButton(driver, 2);

    public static Joystick getJoystick() {
        return driver;
    }
}
