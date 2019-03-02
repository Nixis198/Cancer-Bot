package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.RobotMap;

public class Drivetrain {  
    public static WPI_VictorSPX rightVictorMaster = new WPI_VictorSPX(RobotMap.rightMasterCAN);
    public static WPI_VictorSPX rightVictorSlave1 = new WPI_VictorSPX(RobotMap.rightSlave1CAN);
    public static WPI_VictorSPX rightVictorSlave2 = new WPI_VictorSPX(RobotMap.rightSlave2CAN);

    public static WPI_VictorSPX leftVictorMaster = new WPI_VictorSPX(RobotMap.leftMasterCAN);
    public static WPI_VictorSPX leftVictorSlave1 = new WPI_VictorSPX(RobotMap.leftSlave1CAN);
    public static WPI_VictorSPX leftVictorSlave2 = new WPI_VictorSPX(RobotMap.leftSlave2CAN);

    public static DifferentialDrive drive = new DifferentialDrive(leftVictorMaster, rightVictorMaster);

    public static void DrivetrainSetup() {
        rightVictorMaster.configFactoryDefault();
        rightVictorSlave1.configFactoryDefault();
        rightVictorSlave2.configFactoryDefault();
        leftVictorMaster.configFactoryDefault();
        leftVictorSlave1.configFactoryDefault();
        leftVictorSlave2.configFactoryDefault();

        rightVictorSlave1.follow(rightVictorMaster);
        rightVictorSlave2.follow(rightVictorMaster);
        leftVictorSlave1.follow(leftVictorMaster);
        leftVictorSlave2.follow(leftVictorMaster);

        rightVictorMaster.setInverted(false);
        rightVictorSlave1.setInverted(InvertType.FollowMaster);
        rightVictorSlave2.setInverted(InvertType.FollowMaster);
        leftVictorMaster.setInverted(false);
        leftVictorSlave1.setInverted(InvertType.FollowMaster);
        leftVictorSlave2.setInverted(InvertType.FollowMaster);

        Drivetrain.drive.setRightSideInverted(false);
    }
}