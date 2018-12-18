package com.company.commands;

import com.company.Robot;
import com.company.Robot;
import com.company.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

import static com.company.RobotMap.MainDrive;
import static com.company.RobotMap.MainDrive;

public class ArcadeDriveCommand extends Command {
    public ArcadeDriveCommand() {

        super.requires(MainDrive);
       // super.requires(RobotMap.FlipperDrive);
       // super.requires(RobotMap.ElevatorDrive);
       // super.requires(RobotMap.AutoDrive);
    }

    @Override
    protected void initialize(){

    }

    @Override
    protected void execute() {
        MainDrive.TeleopDrive(Robot.oi.getJoystick());

    }

    @Override
    protected boolean isFinished() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    protected void end() {
        // TODO Auto-generated method stub

    }

    @Override
    protected void interrupted() {
        // TODO Auto-generated method stub

    }

}