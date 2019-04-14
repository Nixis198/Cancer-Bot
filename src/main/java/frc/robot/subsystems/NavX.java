/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

public class NavX{
  static AHRS navx = new AHRS(SPI.Port.kMXP);

  public static void navXSetUp(){
    navx.reset();
  }
  public static int getNavXAngle() {
    int raw = (int) Math.abs(navx.getAngle());
    return raw;
  }
}
