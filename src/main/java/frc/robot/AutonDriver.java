package frc.robot;

import java.util.concurrent.TimeUnit;
import frc.robot.subsystems.Drivetrain;

public class AutonDriver{
    public static void AutonDriveYeet(double speed, String direction, long time) {
        if(direction == "forward") {
            Drivetrain.rightVictorMaster.set(speed);
            Drivetrain.leftVictorMaster.set(speed);
            try{
                TimeUnit.SECONDS.sleep(time);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            Drivetrain.rightVictorMaster.set(0);
            Drivetrain.leftVictorMaster.set(0);
        }
        if(direction == "right") {
            Drivetrain.rightVictorMaster.set(speed);
            Drivetrain.leftVictorMaster.set(-speed);
            try{
                TimeUnit.SECONDS.sleep(time);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            Drivetrain.rightVictorMaster.set(0);
            Drivetrain.leftVictorMaster.set(0);
        }
        if(direction == "left") {
            Drivetrain.rightVictorMaster.set(-speed);
            Drivetrain.leftVictorMaster.set(speed);
            try{
                TimeUnit.SECONDS.sleep(time);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            Drivetrain.rightVictorMaster.set(0);
            Drivetrain.leftVictorMaster.set(0);
        }
        if(direction == "back") {
            Drivetrain.rightVictorMaster.set(-speed);
            Drivetrain.leftVictorMaster.set(-speed);
            try{
                TimeUnit.SECONDS.sleep(time);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            Drivetrain.rightVictorMaster.set(0);
            Drivetrain.leftVictorMaster.set(0);
        }
    }
}