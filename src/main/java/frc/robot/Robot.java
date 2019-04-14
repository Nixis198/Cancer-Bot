/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystems.NavX;

public class Robot extends TimedRobot {
  public static OI oi;

  double leftSlow = 0.24;
  double rightSlow = -0.24;
  double rotateSpeed = 0.35;
  double rotateSpeedSlow = 0.25;

  @Override
  public void robotInit() {
    oi = new OI();
    frc.robot.subsystems.Drivetrain.DrivetrainSetup();
    frc.robot.subsystems.NavX.navXSetUp();
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
    
  }

  @Override
  public void teleopPeriodic() {
    if(oi.btnGyroDrive.get()){
      if(NavX.getNavXAngle() <= 3){
        frc.robot.subsystems.Drivetrain.leftVictorMaster.set(leftSlow - (NavX.getNavXAngle()) / 15);
        frc.robot.subsystems.Drivetrain.rightVictorMaster.set(rightSlow - (NavX.getNavXAngle()) / 15);
      } else if(NavX.getNavXAngle() < 10){
        if(NavX.getNavXAngle() > 0){
          frc.robot.subsystems.Drivetrain.leftVictorMaster.set(leftSlow);
          frc.robot.subsystems.Drivetrain.rightVictorMaster.set(1.1 * rightSlow);
        } else if(NavX.getNavXAngle() < 0){
          frc.robot.subsystems.Drivetrain.leftVictorMaster.set(1.1 * leftSlow);
          frc.robot.subsystems.Drivetrain.rightVictorMaster.set(rightSlow);
        }
      } else if(NavX.getNavXAngle() > 0){
        while(NavX.getNavXAngle() > 10 && isOperatorControl()){
          frc.robot.subsystems.Drivetrain.leftVictorMaster.set(-rotateSpeed);
          frc.robot.subsystems.Drivetrain.rightVictorMaster.set(-rotateSpeed);
        }
        while (NavX.getNavXAngle() > 0 && isOperatorControl()){
          frc.robot.subsystems.Drivetrain.leftVictorMaster.set(-rotateSpeedSlow);
          frc.robot.subsystems.Drivetrain.rightVictorMaster.set(-rotateSpeedSlow);
         }
         while (NavX.getNavXAngle() < 0 && isOperatorControl()){
          frc.robot.subsystems.Drivetrain.leftVictorMaster.set(rotateSpeedSlow);
          frc.robot.subsystems.Drivetrain.rightVictorMaster.set(rotateSpeedSlow);
         }
        } else {
         while (NavX.getNavXAngle() < -10 && isOperatorControl()){
          frc.robot.subsystems.Drivetrain.leftVictorMaster.set(rotateSpeed);
          frc.robot.subsystems.Drivetrain.rightVictorMaster.set(rotateSpeed);
         }
         while (NavX.getNavXAngle() < 0 && isOperatorControl()){
          frc.robot.subsystems.Drivetrain.leftVictorMaster.set(rotateSpeedSlow);
          frc.robot.subsystems.Drivetrain.rightVictorMaster.set(rotateSpeedSlow);
         }
         while (NavX.getNavXAngle() > 0 && isOperatorControl()){
          frc.robot.subsystems.Drivetrain.leftVictorMaster.set(-rotateSpeedSlow);
          frc.robot.subsystems.Drivetrain.rightVictorMaster.set(-rotateSpeedSlow);
         }
      }
    } else{
      frc.robot.subsystems.Drivetrain.drive.arcadeDrive(Robot.oi.getJoystickY(), Robot.oi.getJoystickX());
    }
  }

  @Override
  public void testPeriodic() {
  }
}
