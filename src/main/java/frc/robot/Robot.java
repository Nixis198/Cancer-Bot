/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {
  public static OI oi;
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String autoSelected;
  private final SendableChooser<String> chooser = new SendableChooser<>();

  @Override
  public void robotInit() {
    oi = new OI();
    chooser.setDefaultOption("Default Auto", kDefaultAuto);
    chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", chooser);
    frc.robot.subsystems.Drivetrain.DrivetrainSetup();
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
    autoSelected = chooser.getSelected();
    // autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + autoSelected);
  }

  @Override
  public void autonomousPeriodic() {
    switch (autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        AutonDriver.AutonDriveYeet(0.5, "forward", 5);
        AutonDriver.AutonDriveYeet(1, "right", 5);
        AutonDriver.AutonDriveYeet(1, "left", 5);
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        AutonDriver.AutonDriveYeet(0.5, "forward", 5);
        AutonDriver.AutonDriveYeet(1, "right", 5);
        AutonDriver.AutonDriveYeet(1, "left", 5);
        break;
    }
  }

  @Override
  public void teleopPeriodic() {
    frc.robot.subsystems.Drivetrain.drive.arcadeDrive(Robot.oi.getJoystickY(), Robot.oi.getJoystickX());
  }

  @Override
  public void testPeriodic() {
  }
}
