package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.math.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {

  /* Calling the motors into arrays. Contains 4 falcons */
  protected final WPI_TalonSRX[] leftMotors;
  protected final WPI_TalonSRX[] rightMotors;
  private final DifferentialDrive differentialDrive;

  /*
   * Calling the different items needed for the autonomous and differential drive
   */
  DifferentialDriveKinematics kinematics;
  SimpleMotorFeedforward feedForward;
  PIDController leftPIDController;
  PIDController rightPIDController;

  /**
   * this method is called when the DriveTrainSubsystem class is initialized.
   */
  public Drive() {
    super();

    /* Instantiating the Motors */
    this.leftMotors = new WPI_TalonSRX[] {
        new WPI_TalonSRX(4),
        new WPI_TalonSRX(5)
    };
    this.rightMotors = new WPI_TalonSRX[] {
        new WPI_TalonSRX(2),
        new WPI_TalonSRX(1)
    };

    // Creating the differential drive and items needed for autonomous
    differentialDrive = new DifferentialDrive(leftMotors[0], rightMotors[0]);


    // Settings for motors to ensure they run properly
    leftMotors[1].follow(leftMotors[0]);
    rightMotors[1].follow(rightMotors[0]);


    leftMotors[1].setNeutralMode(NeutralMode.Brake);
    leftMotors[0].setNeutralMode(NeutralMode.Brake);
    rightMotors[0].setNeutralMode(NeutralMode.Brake);
    rightMotors[1].setNeutralMode(NeutralMode.Brake);

    leftMotors[0].configOpenloopRamp(0.7);
    leftMotors[1].configOpenloopRamp(0.7);
    rightMotors[0].configOpenloopRamp(0.7);
    rightMotors[1].configOpenloopRamp(0.7);
  }


  

  /**
   * This method will set the robot into arcade drive
   * 
   * @param speed    Need the speed of the robot as a speed
   * @param rotation the speed at which the robot will rotate
   **/
  public void arcadeDrive(double speed, double rotation) {
    differentialDrive.arcadeDrive(speed, rotation);
  }

  /**
   * This method will set the robot into tank drive
   * 
   * @param leftTrain  Need the speed of the robot as a speed
   * @param rightTrain the speed at which the robot will rotate
   **/
  public void tankDrive(double leftTrain, double rightTrain) {
    differentialDrive.tankDrive(leftTrain, rightTrain);
    differentialDrive.feed();
  }

}