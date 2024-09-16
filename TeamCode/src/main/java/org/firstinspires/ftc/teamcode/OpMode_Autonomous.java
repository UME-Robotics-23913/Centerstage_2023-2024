package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Robot:Auto", group="Robot")
public class OpMode_Autonomous extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    Hardware robot = new Hardware();
    static final double FORWARD_SPEED = 0.6;

    @Override
    public void runOpMode() {
        robot.initMotors(hardwareMap);
        while (opModeIsActive()) {
            turnSeconds(1,-1);
            driveSeconds(1, FORWARD_SPEED);
        }
    }
    public void turnSeconds(double seconds, double speed) {
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() <= seconds)) {
            telemetry.addData("path", "Leg 1: %4.1f S Elapsed",runtime.seconds());
            telemetry.update();

            robot.BackLeftMotor.setPower(speed);
            robot.FrontLeftMotor.setPower(speed);
            robot.BackRightMotor.setPower(-speed);
            robot.FrontRightMotor.setPower(-speed);
        }
        robot.BackLeftMotor.setPower(0);
        robot.FrontLeftMotor.setPower(0);
        robot.BackRightMotor.setPower(0);
        robot.FrontRightMotor.setPower(0);
    }
    public void driveSeconds(double seconds, double speed) {
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() <= seconds)) {
            telemetry.addData("path", "Leg 1: %4.1f S Elapsed",runtime.seconds());
            telemetry.update();

            robot.BackLeftMotor.setPower(speed);
            robot.FrontLeftMotor.setPower(speed);
            robot.BackRightMotor.setPower(speed);
            robot.FrontRightMotor.setPower(speed);
        }
        robot.BackLeftMotor.setPower(0);
        robot.FrontLeftMotor.setPower(0);
        robot.BackRightMotor.setPower(0);
        robot.FrontRightMotor.setPower(0);
    }
}

