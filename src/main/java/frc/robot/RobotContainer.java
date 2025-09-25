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
  public Motor motor1 = new Motor(new TalonFX(5));
  public Motor motor2 = new Motor(new TalonFX(6));
  public Motor motor3 = new Motor(new TalonFX(7));
  public Motor motor4 = new Motor(new TalonFX(8));
  public CommandXboxController control = new CommandXboxController(0);

  public RobotContainer() {
    configureBindings();
  }

  public void onInitialize() {
    motor1.setDefaultCommand(new RunCommand(() -> motor1.runMotor(0), motor1));
    motor2.setDefaultCommand(new RunCommand(() -> motor2.runMotor(0), motor2));
    motor3.setDefaultCommand(new RunCommand(() -> motor3.runMotor(0), motor3));
    motor4.setDefaultCommand(new RunCommand(() -> motor4.runMotor(0), motor4));
  }

  private void configureBindings() {
    control.a().whileTrue(new RunCommand(() -> motor1.runMotor(0.5)));
    control.a().whileTrue(new RunCommand(() -> motor2.runMotor(0.5)));
    control.a().whileTrue(new RunCommand(() -> motor3.runMotor(0.5)));
    control.a().whileTrue(new RunCommand(() -> motor4.runMotor(0.5)));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
