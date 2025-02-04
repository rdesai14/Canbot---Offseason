package frc.robot.commands;


import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drive;

public class DriveCommand extends Command {
  private final Drive drive;
  private final DoubleSupplier power;
  private final DoubleSupplier turn;
  /**
   * Creates a new DefaultDrive.
   *
   * @param drive       The drive subsystem this command wil run on.
   * @param Arm         The arm subsystem is required to gather the state of the arm. If extended, then the robot will move slower
   * @param power       The control input for driving 
   * @param rotation    The control input for turning
   * @param turbo       The button input for toggling the robot speed
   */

   
  public DriveCommand(Drive drive, DoubleSupplier power, 
                    DoubleSupplier turn) {
        super();

    this.drive = drive;
    this.power = power;
    this.turn = turn;
    addRequirements(drive);
  }


@Override
  public void execute() {
      drive.arcadeDrive(power.getAsDouble() * 0.3, turn.getAsDouble() * -0.3);
  }
 }