package com.company.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.SpeedController;

public class TalonSRXControl implements SpeedController {

    private TalonSRX talon;

    public TalonSRXControl(int id) {
        // TODO Auto-generated constructor stub
        this.talon = new TalonSRX(id);
    }

    @Override
    public void pidWrite(double output) {
        // TODO Auto-generated method stub

    }

    @Override
    public void set(double speed) {
        // TODO Auto-generated method stub
        talon.set(ControlMode.PercentOutput, speed);
    }

    @Override
    public double get() {
        // TODO Auto-generated method stub
        return talon.getDeviceID();
    }

    @Override
    public void setInverted(boolean isInverted) {
        // TODO Auto-generated method stub
        talon.setInverted(isInverted);
    }

    @Override
    public boolean getInverted() {
        // TODO Auto-generated method stub
        return talon.getInverted();
    }

    @Override
    public void disable() {
        // TODO Auto-generated method stub
        talon.set(ControlMode.Disabled, 0);
    }

    @Override
    public void stopMotor() {
        // TODO Auto-generated method stub
        talon.set(ControlMode.PercentOutput, 0);
    }

    public TalonSRX getTalon() {
        return talon;
    }

}
