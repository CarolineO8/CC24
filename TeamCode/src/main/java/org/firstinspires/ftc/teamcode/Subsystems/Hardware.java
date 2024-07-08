package org.firstinspires.ftc.teamcode.Subsystems;

//hardware variables followed by hardware objects

//DCMotorEx: https://ftctechnh.github.io/ftc_app/doc/javadoc/index.html?com/qualcomm/robotcore/hardware/DcMotorEx.html

import com.acmerobotics.dashboard.config.Config;

import org.firstinspires.ftc.teamcode.KCP.DriveClasses.MecanumDrive;

@Config
public class Hardware {

    public static final String

    extendoL = "HSlideL", extendoR = "HSlideR";

    public static final String
   //         verticalEncoder = "bl", horizontalEncoder = "fr";
    //V2:
    verticalEncoder = "fr", horizontalEncoder = "br";

    public static final String
            intakeV4bServo = "Iv4bL", intakeWrist = "IWrist", intakeV4bServoR = "Iv4bR";
    //                                        ehub 5

    public static final String
            grabLeft = "grabL", grabRight = "grabR";
    public static final String
            v4b1 = "Sv4bL", v4b2 = "Sv4bR", wrist = "SWrist";

    public static final String
            clawLeft = "clawL", clawRight = null; // Trust

    public static final  String
            v4bEncoder = "v4bSensor", wristEncoder =  "wristSensor";

    public static final String
            climb1 = "launcher", climb2 = "climb";

    public static final String
            launcher = "clawR";

    //Multipliers for Test Chassis
    //public static double verticalEncoderTicksToCM = -0.00075491,   horizontalEncoderTicksToCM = -0.00075227449;

    //Multipliers for Jamie V2
    public static double verticalEncoderTicksToCM = -0.00091912743, horizontalEncoderTicksToCM = -0.0005236551576;

    public static final String
            leftFront = "fl", rightFront  = "fr",
            leftBack = "bl", rightBack = "br";



    public static final double[] mecanumWheelPowerVector = new double[]{MecanumDrive.MecanumDriveDash.vecX,MecanumDrive.MecanumDriveDash.vecY};

}

//EHUB
//grab
//brown is left - 1
//orange is on right - 3


//v4b
//white is left - 0
//red is right - 4

