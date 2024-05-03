package org.firstinspires.ftc.teamcode.TeleOp;

import static org.firstinspires.ftc.teamcode.Utilities.OpModeUtils.multTelemetry;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="Rocket League", group="Iterative Opmode")
public class RocketLeague extends OpMode {
    //Declare Subsystems

    //Timer
    ElapsedTime runtime = new ElapsedTime();

    @Override
    public void init() {
        //Set timer to 0
        runtime.reset();
        //Code that runs when you hit init
    }

    @Override
    public void start(){
        //Code that runs when you hit start
    }

    @Override
    public void loop() {
        //Code that *LOOPS* after you hit start
    }

    @Override
    public void stop(){
        //Code that runs when you hit stop
        multTelemetry.addData("Runtime", runtime);
        multTelemetry.update();

    }

}
