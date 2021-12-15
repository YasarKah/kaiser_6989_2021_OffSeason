
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class Intake_Subsystem extends SubsystemBase {

  private final WPI_TalonSRX m_intake_Motor = new WPI_TalonSRX(IntakeConstants.kIntake_Motor_Port);
  private final DoubleSolenoid m_intake_solenoid = new DoubleSolenoid(0, 1);

  public static boolean intake_pneumatic_state = false;
  private boolean startEngine = false;
  private boolean test = false;

  public Intake_Subsystem() {
    //RoboRIO çalışınca 1 defa çalışıyor.
  }

  @Override
  public void periodic() {
    if(test == false){
      close_Intake();
      test = true;
    }
    if (startEngine == true) {
      start_Intake();
      
    } else {
      stop_Intake();
    }

  }

  public void change_Intake() {
    startEngine = !startEngine;
  }

  public void change_Pneumatic_Intake() {
    System.out.print("intake_pneumatic_state: ");
    System.out.println(intake_pneumatic_state);
    if (intake_pneumatic_state) {
      close_Intake();
    } else {
      open_Intake();
    }
  }

  public void start_Intake() {
    m_intake_Motor.set(IntakeConstants.kIntake_Motor_speed);
  }

  public void stop_Intake() {
    m_intake_Motor.set(0);

  }

  public void open_Intake() {
    m_intake_solenoid.set(Value.kReverse);
    intake_pneumatic_state = true;
  }

  public void close_Intake() {
    m_intake_solenoid.set(Value.kForward);
    intake_pneumatic_state = false;
  }

}