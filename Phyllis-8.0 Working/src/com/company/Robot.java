/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package com.company;

import com.company.commands.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.company.subsystems.ExampleSubsystem;

import static com.company.OI.*;
import static com.company.RobotMap.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
// If you rename or move this class, update the build.properties file in the project root
public class Robot extends TimedRobot{

    public static double steering_adjust = 0.0f;
    public static String gameData = " ";
    public static char game1 = ' ';

    public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
    public static OI oi;

    private Command autonomousCommand;
    private SendableChooser<Command> chooser = new SendableChooser<>();

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override
    public void robotInit()
    {
        button5.whileHeld(new ArmUp());
        button6.whileHeld(new ArmDown());

        driveRight1.set(ControlMode.Follower, DriveRight1);
        driveLeft1.set(ControlMode.Follower, DriveLeft1);

        driveLeft1.setSafetyEnabled(false);
        driveLeft2.setSafetyEnabled(false);
        driveRight1.setSafetyEnabled(false);
        driveRight2.setSafetyEnabled(false);

        intakeRight.setInverted(false);

        driveRight2.setInverted(false);
        driveLeft1.setInverted(true);
        driveRight1.setInverted(false);
        driveLeft2.setInverted(true);

        oi = new OI();

        SmartDashboard.putData("Auto mode", chooser);


    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    @Override
    public void disabledInit()
    {

    }

    @Override
    public void disabledPeriodic()
    {
        Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString code to get the auto name from the text box below the Gyro
     *
     * <p>You can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons
     * to the switch structure below with additional strings & commands.
     */
    @Override
    public void autonomousInit() {
        gameData = DriverStation.getInstance().getGameSpecificMessage();
        game1 = gameData.charAt(0);
        System.out.println(gameData);

        autonomousCommand = chooser.getSelected();
        //Fifty Left




        /*
         * String autoSelected = SmartDashboard.getString("Auto Selector",
         * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
         * = new MyAutoCommand(); break; case "Default Auto": default:
         * autonomousCommand = new ExampleCommand(); break; }
         */

        // schedule the autonomous command (example)
        if (autonomousCommand != null)
        {
            autonomousCommand.start();
        }
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic()
    {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit()
    {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null)
        {
            autonomousCommand.cancel();
        }
    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();

        //Limelight table
        double Kp = -0.1f;
        edu.wpi.first.networktables.NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

        double ta = Limelight.getTa();
        double tx = Limelight.getTx();
        double aim_error = tx;
        double area_error = ta;
        double distance_adjust = Kp * area_error;
        double steering_adjust = Kp * aim_error;
        double AimMinCmd = 0.095f;
        WPI_TalonSRX left_command1 = driveLeft1, driveLeft2;
        WPI_TalonSRX right_command1 = driveRight1, driveRight2;


        if (button25.get()) {
            steering_adjust = Kp * tx;

            left_command1.set(steering_adjust * 1);
            right_command1.set(-steering_adjust * .01);
            if (steering_adjust <= .5){
                if (Limelight.getTa() > 10 || Limelight.getTa() == 0) {
                    left_command1.set(0);
                    right_command1.set(0);
                }
                else {

                    left_command1.set(.4);
                    right_command1.set(-.4);

                }
            }
        }
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {

    }
}
