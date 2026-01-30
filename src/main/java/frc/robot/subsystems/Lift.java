package frc.robot.subsystems;

import com.revrobotics.PersistMode;
import com.revrobotics.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import frc.robot.Constants.LiftConstants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lift extends SubsystemBase {
    private final SparkMax liftLeftMotor = new SparkMax(LiftConstants.kLeftLiftSparkMaxPort, MotorType.kBrushed);
    private final SparkMax liftRightMotor = new SparkMax(LiftConstants.kRightLiftSparkMaxPort, MotorType.kBrushed);

    private final SparkMaxConfig liftLeftMotorConfig = new SparkMaxConfig();
    private final SparkMaxConfig liftRightMotorConfig = new SparkMaxConfig();

    public Lift() {
        liftLeftMotorConfig.inverted(false).idleMode(IdleMode.kBrake);
        liftRightMotorConfig.inverted(false).idleMode(IdleMode.kBrake);

        liftLeftMotor.configure(liftLeftMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
        liftRightMotor.configure(liftRightMotorConfig, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);
    }

    public void runUp() {
        liftLeftMotor.setVoltage(LiftConstants.kVoltageLift);
        liftRightMotor.setVoltage(LiftConstants.kVoltageLift);
    }

    public void runDown() {
        liftLeftMotor.setVoltage(-LiftConstants.kVoltageLift);
        liftRightMotor.setVoltage(-LiftConstants.kVoltageLift);
    }

    public void stop() {
        liftLeftMotor.setVoltage(0);
        liftRightMotor.setVoltage(0);
    }
}
