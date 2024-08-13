// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants.JoystickConstants;
import frc.robot.subsystems.Tank;

public class RobotContainer {
  private Tank tank;

  private Joystick driverJoystick;

  public RobotContainer() {
    tank = new Tank();

    driverJoystick = new Joystick(JoystickConstants.DRIVER_JOYSTICK_PORT);

    tank.setDefaultCommand(tank.TankDrive(() -> driverJoystick.getRawAxis(JoystickConstants.LEFT_Y_AXIS), () -> driverJoystick.getRawAxis( JoystickConstants.RIGHT_Y_AXIS)));
  }
}