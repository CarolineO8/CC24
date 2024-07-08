package org.firstinspires.ftc.teamcode.KCP.Localization;

import org.firstinspires.ftc.teamcode.BaseOpMode;
import org.firstinspires.ftc.teamcode.Subsystems.Hardware;
import org.firstinspires.ftc.teamcode.Utilities.WolfpackUtilities.HardwareDevices.Gyro;
import org.firstinspires.ftc.teamcode.Utilities.WolfpackUtilities.HardwareDevices.MotorEncoder;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;

public class TwoWheelOdometry extends Location{

    //et variables and measure precision of instruments
    private double imuOffset = 0;
    private int imuNumber = 0;

    //location variables to be read by other classes
    double h = 0;

    //what the imu reading should be rounded to for maximum accuracy
    double IMUMaximumPrecision = 0.01;
    double IMUMaxNum;

    //defining the center of the robot to be the center of the robot
    //Values For JamieV2
    double horizontalOffset = 0.5; //vertical distance from horizontal encoder to center of robot
    double verticalOffset = 6; //
    //Values for Test Chassis
    //double verticalOffset = 7.5;
    //double horizontalOffset  7.25;
    //last vertical and horizontal encoder readings
    double hPrevDist, vPrevDist;

    //new readings
    double newVertical, newHorizontal, newHeading;
    //change in readings / calculated change
    double dVertical, dHorizontal, dHeading, dX, dY;
    public final MotorEncoder verticalEncoder;
    public final MotorEncoder horizontalEncoder;
    public final Gyro gyro;
    //public final BadBNO055 gyro;

    //intialize odometry
    public TwoWheelOdometry(double startX, double startY, double startHeading){
        super(startX, startY);
        IMUMaxNum = 1/IMUMaximumPrecision;

        verticalEncoder = new MotorEncoder(Hardware.verticalEncoder, Hardware.verticalEncoderTicksToCM);
        horizontalEncoder = new MotorEncoder(Hardware.horizontalEncoder, Hardware.horizontalEncoderTicksToCM);

        gyro = new Gyro( "imuA");



        //get new reads on sensors (heading, Vertical encoder, and horizontal encoder)
        verticalEncoder.resetEncoder();
        horizontalEncoder.resetEncoder();
        vPrevDist = verticalEncoder.getPosition();
        hPrevDist = horizontalEncoder.getPosition();

        gyro.setCurrentHeading(startHeading);

        //     gyro.setOffsetAngle(Math.toDegrees(startHeading));
        h = startHeading;



    }

    @Override
    public void setCurrentHeading(double heading) {
        gyro.setCurrentHeading(heading);
    }

    //Uses Odo Pods
    public void localize(){

        //get new reads on sensors (heading, Vertical encoder, and horizontal encoder)
        newVertical = verticalEncoder.getPosition();
        newHorizontal = horizontalEncoder.getPosition();
//        newHeading = gyro.getHeading();
        newHeading = gyro.getHeading();

        //get change in heading, Vertical encoder, and horizontal encoder
        dVertical = newVertical - vPrevDist;
        dHorizontal = newHorizontal - hPrevDist;
        dHeading = newHeading - h;

        while (dHeading < -Math.PI) { // For example 355 to 5 degrees
            dHeading += 2 * Math.PI;
        }
        while (dHeading > Math.PI) { // For example 5 to 355 degrees // IDT NECESSARY
            dHeading -= 2 * Math.PI;
        }

        //Math: https://www.desmos.com/calculator/sfpde8dhcw - incorrect
        //needs more images to be properly explained

        //catch the divide by 0
        //TODO use line based when delta heading in range
        if(dHeading == 0) {
            dX = dHorizontal;
            dY = dVertical;
        }else {


            //normal odometry

//            double arcRad = (dVertical - (verticalOffset * dHeading)) / dHeading;
//            ///  \/ highly debated
//            double number = arcRad + dHorizontal - (horizontalOffset * dHeading);
//
//            dX = fastCos(dHeading) * (number) - arcRad;
//            dY = fastSin(dHeading) * (number);
//
//            dX = dHorizontal * fastCos(dHeading) + dVertical * fastSin(dHeading);
//            dY = dHorizontal * fastSin(dHeading) + dVertical * fastCos(dHeading);

            //
            double arcRad1 = (dVertical - (verticalOffset * dHeading)) / dHeading;
            //
            double arcRad2 = (dHorizontal - (horizontalOffset * dHeading)) / dHeading;


            dY = Math.sin(dHeading) * arcRad1 - Math.cos(dHeading) * arcRad2 + arcRad2;
            dX = Math.sin(dHeading) * arcRad2 + Math.cos(dHeading) * arcRad1 - arcRad1;
        }


        //rotating to absolute coordinates vs robot relative calculated above
        location[0] += Math.cos(h) * dX - Math.sin(h) * dY;
        location[1] += Math.sin(h) * dX + Math.cos(h) * dY;
        Location.heading = newHeading;

        //update reference values to current position
        vPrevDist = newVertical;
        hPrevDist = newHorizontal;
        h = newHeading;
    }



    @Override
    public void aprilLocalize(AprilTagDetection tagNum, double x, double y, double heading, double cameraNumber) {

        BaseOpMode.addData("aprilTag Localizing","");
        BaseOpMode.addData("tagX",x);
        BaseOpMode.addData("tagY",y);
        BaseOpMode.addData("tagYaw",heading);
        double tagID = tagNum.id;
        BaseOpMode.addData("tagID",tagID);

        x -= PathingConstants.camOffsetX;
        y += PathingConstants.camOffsetY;

        if (tagID == 1){
            x = PathingConstants.tag1x - x;
            y = PathingConstants.backdropY - y;

        }
        else if (tagID == 2){
            x = PathingConstants.tag2x - x;
            y = PathingConstants.backdropY - y;
        }
        else if (tagID == 3){
            x = PathingConstants.tag3x - x;
            y = PathingConstants.backdropY - y;
        }
        else if (tagID == 4){
            x = PathingConstants.tag4x - x;
            y = PathingConstants.backdropY - y;
        }
        else if (tagID == 5){
            x = PathingConstants.tag5x - x;
            y = PathingConstants.backdropY - y;
        }
        else if (tagID == 6){
            x = PathingConstants.tag6x - x;
            y = PathingConstants.backdropY - y;
        }
        else if (tagID == 7){
            x = PathingConstants.tag7x - x;
            y = PathingConstants.backWallY + x;
        }
        else if (tagID == 8){
            x = PathingConstants.tag8x - x;
            y = PathingConstants.backWallY + y;
        }
        else if (tagID == 9){
            x = PathingConstants.tag9x - x;
            y = PathingConstants.backWallY + y;
        }
        else if (tagID == 10){
            x = PathingConstants.tag10x - x;
            y = PathingConstants.backWallY + y;
        }

        location[0] = x;
        location[1] = y;
        BaseOpMode.addData("finalX",x);
        BaseOpMode.addData("finalY",y);
        Location.heading = heading;
    }


    public double[] getRawValues(){
        return new double[]{verticalEncoder.getPosition(), horizontalEncoder.getPosition(), newHeading};
    }

    public double getHighestX(){
        double highestX = 0;
        if (highestX < TwoWheelOdometry.x()){
            highestX = TwoWheelOdometry.x();
        }
        return highestX;
    }
    public double getHighestY(){
        double highestY = 0;
        if (highestY < TwoWheelOdometry.y()){
            highestY = TwoWheelOdometry.y();
        }
        return highestY;
    }


    public double getVelocityY(){
        return velocity[1];
    }

}