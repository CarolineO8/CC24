package org.firstinspires.ftc.teamcode.KCP.Localization;

public class PathingConstants {
    public static double fieldSizeY = 141.5;
    public static double fieldSizeX = 141.5;
    public static double backdropY = fieldSizeY - 8.5;
    public static double backWallY = 0;

    public static double centerStackBlue = 47;
    public static double closeStackBlue = centerStackBlue - 12;
    public static double gateStackBlue = centerStackBlue + 12;


    public static double centerStackRed = 86;
    public static double closeStackRed = centerStackRed + 12;
    public static double gateStackRed = centerStackRed - 12;

    public static double tag2x = 35.3;
    public static double tag1x = tag2x - 6;
    public static double tag3x = tag2x + 6;
    public static double tag5x = 106.25;
    public static double tag4x = tag5x - 6;
    public static double tag6x = tag5x + 6;
    public static double tag8x = closeStackRed;
    public static double tag7x = tag8x + 5.5;
    public static double tag9x = closeStackBlue;
    public static double tag10x = tag9x - 5.5;



    public static double robotSizeX = 14.6;
    public static double halfRobotSizeX = robotSizeX / 2;
    public static double robotSizeY = 15.25;
    public static double halfRobotSizeY = robotSizeY / 2;
    public static double halfRobotSizeYDepositorExtended = 14.5;
    //Note: This number does not include the actual grabbing part of the claw, it goes to the back of the claw where the pixels should rest
    public static double halfRobotSizeYIntakeExtended = halfRobotSizeY + 7;

    public static double camOffsetX = 0;
    public static double camOffsetY = halfRobotSizeY - .118;

    public static double endAngle;

    public static double[][] obstacles = {{1,22},{2, 3}};
    public void setEndAngle(double angle){
        endAngle = angle;
    }
}
