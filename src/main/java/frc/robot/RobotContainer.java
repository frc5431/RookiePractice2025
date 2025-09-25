// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystem.Motor;

public class RobotContainer {
  public Motor motor1 = new Motor(
    new TalonFX(5), 
    new TalonFX(6), 
    new TalonFX(7), 
    new TalonFX(8)
  );
  public CommandXboxController control = new CommandXboxController(0);

  public RobotContainer() {
    configureBindings();
  }

  public void onInitialize() {
    motor1.setDefaultCommand(new RunCommand(() -> motor1.runMotor(0), motor1));
  }

  private void configureBindings() {
    control.a().whileTrue(new RunCommand(() -> motor1.runMotor(0.5)));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
