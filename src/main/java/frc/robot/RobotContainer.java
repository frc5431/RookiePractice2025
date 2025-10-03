// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystem.Drive;

public class RobotContainer {
  public Drive drive = new Drive(
      new TalonFX(Constants.MotorConstants.frontLeftDriveId),
      new TalonFX(
          Constants.MotorConstants.frontRightDriveId),
      new TalonFX(
          Constants.MotorConstants.backLeftDriveId),
      new TalonFX(Constants.MotorConstants.backRightDriveId));
  public CommandXboxController control = new CommandXboxController(0);

  public RobotContainer() {
    configureBindings();
  }

  public void onInitialize() {
    drive.setDefaultCommand(new RunCommand(() -> drive.runMotor(0), drive));
  }

  private void configureBindings() {
    control.a().whileTrue(new RunCommand(() -> drive.runMotor(0.1)));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}