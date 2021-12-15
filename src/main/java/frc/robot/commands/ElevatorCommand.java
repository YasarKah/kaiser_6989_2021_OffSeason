package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Climber_Elevator_Subsystem;

public class ElevatorCommand extends CommandBase {

  private final Climber_Elevator_Subsystem climber_Elevator_Subsystem;
  private XboxController drive_controller;

  public ElevatorCommand(Climber_Elevator_Subsystem climber_Elevator_Subsystem, XboxController drive_controller) {
    this.climber_Elevator_Subsystem = climber_Elevator_Subsystem;
    this.drive_controller = drive_controller;
    addRequirements(climber_Elevator_Subsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (drive_controller.getPOV(0) == 0) {
      climber_Elevator_Subsystem.elevator_Up(1);
    } else if (drive_controller.getPOV(0) == 180) {
      climber_Elevator_Subsystem.elevator_Up(-0.6);
    } else {
      climber_Elevator_Subsystem.elevator_Up(0);
    }

  }

  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public void end(boolean interrupted) {
    climber_Elevator_Subsystem.elevator_Stop();

  }

}
