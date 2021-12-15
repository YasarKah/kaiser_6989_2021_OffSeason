package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.lightSubsystem;
import edu.wpi.first.cameraserver.CameraServer;

public class Robot extends TimedRobot {

  private RobotContainer m_robotContainer;
  private Command m_autonomousCommand;

  @Override
  public void robotInit() {
    CameraServer.getInstance().startAutomaticCapture();
    m_robotContainer = new RobotContainer();
    m_robotContainer.c.setClosedLoopControl(true);

  }

  @Override
  public void robotPeriodic() {

    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {
    
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();
    m_robotContainer.m_drive.m_gyro.reset();
    m_robotContainer.m_drive.setBrake();
    m_robotContainer.m_drive.m_gyro.reset();

    m_robotContainer.m_drive.setVoltageComp();

    m_robotContainer.m_intake.close_Intake();

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }
  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {

    m_robotContainer.m_drive.setBrake();
    m_robotContainer.m_drive.disableVoltageComp();

    m_robotContainer.m_intake.stop_Intake();
    m_robotContainer.m_shooter.shoot_Stop();
    m_robotContainer.m_indexer.stop_Indexer_auto();
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }

  }
  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }

}