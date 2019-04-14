package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
    //Joystick
    Joystick joyXboxUSB = new Joystick(RobotMap.xbox);

    Button btnGyroDrive = new JoystickButton(joyXboxUSB, RobotMap.gyroDrive);

    public double getJoystickX() {
        double raw = joyXboxUSB.getX();    
        return Math.abs(raw) < 0.1 ? 0.0 : raw;
    }
    public double getJoystickY() {
        double raw = joyXboxUSB.getY();    
        return Math.abs(raw) < 0.1 ? 0.0 : raw;
    }
}
