package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
    //Joystick
    Joystick xboxUSB = new Joystick(RobotMap.xbox);

    public double getJoystickX() {
        double raw = xboxUSB.getX();    
        return Math.abs(raw) < 0.1 ? 0.0 : raw;
    }
    public double getJoystickY() {
        double raw = xboxUSB.getY();    
        return Math.abs(raw) < 0.1 ? 0.0 : raw;
    }
}
