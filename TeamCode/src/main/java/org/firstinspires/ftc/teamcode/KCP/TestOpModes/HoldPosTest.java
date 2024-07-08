package org.firstinspires.ftc.teamcode.KCP.TestOpModes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.BaseOpMode;
import org.firstinspires.ftc.teamcode.KCP.Localization.TwoWheelOdometry;
import org.firstinspires.ftc.teamcode.KCP.Movement;

@TeleOp(name="HoldPos Test", group="Testing")
public class HoldPosTest extends BaseOpMode {

    public Movement movement;
    public ElapsedTime runtime = new ElapsedTime();
    double heading = Math.PI/2;

    @Override
    public void externalInit() {
        movement = new Movement(0, 0,0);
    }

    @Override
    public void externalInitLoop() {
    }

    @Override
    public void externalStart() {
        runtime.reset();
    }

    @Override
    public void externalLoop() {
        //movement.update();
        movement.holdPosition(0, 0, heading);

        //For rotation testing - comment the second runtime.reset() to use.
        if (runtime.seconds() > 5){
            heading    += Math.PI/2;
            if (heading != Math.PI/2){
                heading = 0;
            }
            runtime.reset();
        }
        runtime.reset();

        BaseOpMode.addData("X", TwoWheelOdometry.x());
        BaseOpMode.addData("Y", TwoWheelOdometry.y());
        BaseOpMode.addData("H", TwoWheelOdometry.heading());
        BaseOpMode.addData("targetH",heading);
        BaseOpMode.addData("runtime",runtime.seconds());
    }

    @Override
    public void externalStop() {
    }
}
