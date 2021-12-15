package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive_Subsystem;
import frc.robot.subsystems.lightSubsystem;


public class TeleDriveCommand extends CommandBase {

  private final XboxController driver_Controller;
  private final Drive_Subsystem drive_Subsystem;
  private final lightSubsystem led;


  public TeleDriveCommand(XboxController driver_Controller, Drive_Subsystem drive_Subsystem, lightSubsystem ls) {
    this.driver_Controller = driver_Controller;
    this.drive_Subsystem = drive_Subsystem;
    this.led = ls;
    addRequirements(drive_Subsystem);
    addRequirements(led);

  }

  @Override
  public void execute() {
    drive_Subsystem.arcadeDrive(getSpeed(), getRotation(),true);
  }

  private double getSpeed() {
    double speed =-driver_Controller.getY(Hand.kLeft);
    return speed;
  }

  private double getRotation() {
    double rotation = driver_Controller.getRawAxis(2);
    if(rotation > 0.1){
      led.rightLED(255, 50, 0);
      System.out.println("Rotation > 0");
    }
    else if(rotation < -0.1){
      led.leftLED(255, 50, 0);
      System.out.println("Rotation < 0 ");
    }
    else{
      led.rightLED(0, 0, 0);
      led.leftLED(0, 0, 0);
      System.out.println("Rotation = 0");
    }
    return rotation;
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public void end(boolean interrupted) {
    
  }

}
