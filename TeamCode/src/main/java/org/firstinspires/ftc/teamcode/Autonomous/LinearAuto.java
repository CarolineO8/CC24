package org.firstinspires.ftc.teamcode.Autonomous;

import static org.firstinspires.ftc.teamcode.Utilities.OpModeUtils.setOpMode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


public class LinearAuto extends LinearOpMode {

    // Declare Subsystems

    public void initialize(){
        // Initialize Subsystems
        setOpMode(this);
    }


    @Override
    public void runOpMode() {
        initialize();

        waitForStart();
        if(opModeIsActive()){
            //Run Auto

        }
    }
}
