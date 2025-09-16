package frc.robot.subsystem;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Motor extends SubsystemBase{
    public TalonFX motor1;
    public TalonFXConfiguration motorOneConfig;

    public Motor(TalonFX talon) {
        this.motor1 = talon;
    }

    public void runMotor(double speed) {
        motor1.set(speed);
    }
}
