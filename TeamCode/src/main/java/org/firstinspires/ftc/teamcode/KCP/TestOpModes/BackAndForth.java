package org.firstinspires.ftc.teamcode.KCP.TestOpModes;

import static org.firstinspires.ftc.teamcode.Autonomous.AAA_Paths.Path.Back;
import static org.firstinspires.ftc.teamcode.Autonomous.AAA_Paths.Path.Forth;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Autonomous.AAA_Paths;
import org.firstinspires.ftc.teamcode.BaseOpMode;
import org.firstinspires.ftc.teamcode.KCP.Localization.TwoWheelOdometry;
import org.firstinspires.ftc.teamcode.KCP.Movement;
@Autonomous(name = "Back and Forth")
public class BackAndForth extends BaseOpMode {

    Movement drive;
    AAA_Paths.Path state = Forth;
    double currentV;

    @Override
    public void externalInit() {
        drive = new Movement(0,0,0);

        Forth.compile();
        Back.compile();


        BaseOpMode.addData("X", TwoWheelOdometry.x());
        BaseOpMode.addData("Y", TwoWheelOdometry.y());
        BaseOpMode.addData("H", TwoWheelOdometry.heading());
    }

    @Override
    public void externalLoop() {

        stateMachine();
        BaseOpMode.addData("X", TwoWheelOdometry.x());
        BaseOpMode.addData("Y", TwoWheelOdometry.y());
        BaseOpMode.addData("H", TwoWheelOdometry.heading());
    }

    public void stateMachine(){
        switch (state){
            case Forth:
                forth();
                break;
            case Back:
                back();
                break;
        }
    }


    public void forth(){
        double heading = 0;
        BaseOpMode.addData("%Done", Forth.t);
        if(!drive.followPath(Forth,1,heading, .7,true)){
            setState(Back);
        }
    }

    public void back(){
        double heading = Math.PI;
        BaseOpMode.addData("%Done", Back.t);
        if(!drive.followPath(Back,.5,heading, .7,true)){
            setState(Forth);
        }
    }

    public void setState(AAA_Paths.Path state){
        this.state = state;
    }
}
