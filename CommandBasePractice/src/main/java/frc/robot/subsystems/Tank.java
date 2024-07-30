// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants.*;

public class Tank extends SubsystemBase {
  private TalonSRX backMotorRight;
  private TalonSRX frontMotorRight;

  private TalonSRX backMotorLeft;
  private TalonSRX frontMotorLeft;
  /** Creates a new Tank. */
  public Tank() {
    backMotorRight = new TalonSRX(MotorConstants.BACK_MOTOR_RIGHT_Port);
    frontMotorRight = new TalonSRX(MotorConstants.FRONT_MOTOR_RIGHT_Port);

    backMotorRight.follow(frontMotorRight);
    
    backMotorRight.setNeutralMode(NeutralMode.Brake);
    frontMotorRight.setNeutralMode(NeutralMode.Brake);
    
    
    backMotorLeft = new TalonSRX(MotorConstants.BACK_MOTOR_LEFT_Port);
    frontMotorLeft = new TalonSRX(MotorConstants.FRONT_MOTOR_LEFT_Port);

    backMotorLeft.setInverted(true);
    frontMotorLeft.setInverted(true);

    backMotorLeft.follow(frontMotorLeft);

    backMotorLeft.setNeutralMode(NeutralMode.Brake);
    frontMotorLeft.setNeutralMode(NeutralMode.Brake);
  }

  public Command TankDrive() {
    return new ParallelCommandGroup(
      new RunCommand(()-> backMotorLeft.set(ControlMode.PercentOutput, MotorConstants.MOTOR_POWER), this),
      new RunCommand(()-> backMotorRight.set(ControlMode.PercentOutput, MotorConstants.MOTOR_POWER), this),
      new RunCommand(()-> frontMotorLeft.set(ControlMode.PercentOutput, MotorConstants.MOTOR_POWER), this),
      new RunCommand(()-> frontMotorRight.set(ControlMode.PercentOutput, MotorConstants.MOTOR_POWER), this));
  }

  public Command TimeDrive() {
    return new ParallelCommandGroup(TankDrive(), new WaitCommand(5));
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
