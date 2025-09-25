package frc.robot.subsystem;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Motor extends SubsystemBase{
    public TalonFX motor1;
    public TalonFX motor2;
    public TalonFX motor3;
    public TalonFX motor4;
    
    public TalonFXConfiguration motorOneConfig;

    public Motor(TalonFX talon) {
        this.motor1 = talon;
        this.motor2 = talon;
        this.motor3 = talon;
        this.motor4 = talon;
    }

    public void runMotor(double speed) {
        motor1.set(speed);
        motor2.set(speed);
        motor3.set(speed);
        motor4.set(speed);
    }
}
