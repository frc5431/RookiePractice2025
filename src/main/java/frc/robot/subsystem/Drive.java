package frc.robot.subsystem;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drive extends SubsystemBase {
    public TalonFX frontLeft;
    public TalonFX frontRight;
    public TalonFX backLeft;
    public TalonFX backRight;
    public TalonFXConfiguration frontLeftConfig = new TalonFXConfiguration();
    public TalonFXConfiguration frontRightConfig = new TalonFXConfiguration();
    public TalonFXConfiguration backLeftConfig = new TalonFXConfiguration();
    public TalonFXConfiguration backRightConfig = new TalonFXConfiguration();

    public Drive(TalonFX frontLeft, TalonFX frontRight, TalonFX backLeft, TalonFX backRight) {
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.backLeft = backLeft;
        this.backRight = backRight;
        setInvert(Constants.MotorConstants.frontLeftInvert, frontLeftConfig);
        setInvert(Constants.MotorConstants.frontRightInvert, frontRightConfig);
        setInvert(Constants.MotorConstants.backLeftInvert, backLeftConfig);
        setInvert(Constants.MotorConstants.backRightInvert, backRightConfig);

        frontLeft.getConfigurator().apply(frontLeftConfig);
        frontRight.getConfigurator().apply(frontRightConfig);
        backLeft.getConfigurator().apply(backLeftConfig);
        backRight.getConfigurator().apply(backRightConfig);

    }

    public void runMotor(double speed) {
        frontLeft.set(speed);
        frontRight.set(speed);
        backLeft.set(speed);
        backRight.set(speed);
    }

    public void setInvert(Boolean isInverted, TalonFXConfiguration config) {
        config.MotorOutput.Inverted = isInverted ? InvertedValue.CounterClockwise_Positive
                : InvertedValue.Clockwise_Positive;
    }
}
