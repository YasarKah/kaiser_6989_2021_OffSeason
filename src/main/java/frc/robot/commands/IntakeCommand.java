package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake_Subsystem;
import frc.robot.subsystems.lightSubsystem;

public class IntakeCommand extends CommandBase {

private final Intake_Subsystem intake_Subsystem;
private final lightSubsystem led;

  public IntakeCommand(Intake_Subsystem intake_Subsystem, lightSubsystem ls) {
    this.intake_Subsystem = intake_Subsystem;
    this.led = ls;
    addRequirements(intake_Subsystem);
    addRequirements(led);
  }
  @Override
  public void initialize() {
  }
  boolean a = false;
  @Override
  public void execute() {
    intake_Subsystem.change_Intake();
    if(a == false){
      led.frontLED(0, 255, 0);
      a = !a;
    }
    else{
      led.frontLED(255, 0, 0);
      a = !a;
    }
  }


  @Override
  public boolean isFinished() {
    return true;
  }

  @Override
  public void end(boolean interrupted) {
    
    
  }

}
