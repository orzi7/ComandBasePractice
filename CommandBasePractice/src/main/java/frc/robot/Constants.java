// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static class MotorConstants {
    public final static int BACK_MOTOR_LEFT_Port = 1;
    public final static int FRONT_MOTOR_LEFT_Port = 2;

    public final static int BACK_MOTOR_RIGHT_Port = 3;
    public final static int FRONT_MOTOR_RIGHT_Port = 4;

    public final static double MOTOR_POWER = 0.5;
  }
}
