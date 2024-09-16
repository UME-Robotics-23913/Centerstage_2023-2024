package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name="TeleOp", group="Robot")
public class OpMode_TeleOp extends LinearOpMode {

    double frontRightPower, frontLeftPower, backRightPower, backLeftPower;
    double DRIVE_SPEED = 0.5;
    boolean buttonHeld = false;
    ElapsedTime armTimer = new ElapsedTime();
    @Override
    public void runOpMode() {
        Hardware robot = new Hardware();
        robot.initMotors(hardwareMap);
        waitForStart();
        robot.servo.setPosition(1);
        armTimer.reset();
        while (opModeIsActive()) {
            // Forward + Turn + Strafe
            frontRightPower = -gamepad1.left_stick_y - gamepad1.right_stick_x - gamepad1.left_stick_x;
            frontLeftPower = -gamepad1.left_stick_y + gamepad1.right_stick_x + gamepad1.left_stick_x;
            backRightPower = -gamepad1.left_stick_y + gamepad1.right_stick_x - gamepad1.left_stick_x;
            backLeftPower = -gamepad1.left_stick_y - gamepad1.right_stick_x + gamepad1.left_stick_x;

            frontRightPower *= DRIVE_SPEED;
            frontLeftPower *= DRIVE_SPEED;
            backRightPower *= DRIVE_SPEED;
            backLeftPower *= DRIVE_SPEED;

            //divide to keep powers in range 0-1
            double magnitude = Math.max(
                Math.max(
                    Math.max(
                        Math.abs(frontLeftPower), Math.abs(frontRightPower)
                    ),
                    Math.max(
                        Math.abs(backLeftPower), Math.abs(backRightPower)
                    )
                ),
                1
            );

            frontRightPower /= magnitude;
            frontLeftPower /= magnitude;
            backRightPower /= magnitude;
            backLeftPower /= magnitude;

            telemetry.addData("Front left motor: ", frontLeftPower);
            telemetry.addData("Back left motor: ", backLeftPower);
            telemetry.addData("Front right motor: ", frontRightPower);
            telemetry.addData("Back right motor: ", backRightPower);
            telemetry.addLine("crap's workin");
            telemetry.addData("GamepadY position", gamepad1.right_stick_y);
            telemetry.addData("servo position:",robot.servo.getPosition());
            telemetry.update();

            robot.FrontRightMotor.setPower((frontRightPower));
            robot.FrontLeftMotor.setPower((frontLeftPower));
            robot.BackRightMotor.setPower((backRightPower));
            robot.BackLeftMotor.setPower((backLeftPower));
/*
            if(gamepad2.dpad_up)
                robot.ClawArm.setPower(-1);
            else if(gamepad2.dpad_down)
                robot.ClawArm.setPower(1);
            else
                robot.ClawArm.setPower(0);
*/
            if(gamepad2.dpad_up && armTimer.seconds() > 1) {
                armTimer.reset();
                robot.ClawArm.setPower(.25);
            }else if(gamepad2.dpad_down && armTimer.seconds() > 1) {
                armTimer.reset();
                robot.ClawArm.setPower(-.25);
            }else if (armTimer.seconds() > 1)
                robot.ClawArm.setPower(0);

            if(gamepad2.b)
            {
                robot.servo.setPosition(0);
            }
            else
            {
                robot.servo.setPosition(1);
            }





            if(gamepad2.x) {
                robot.Claw.setPosition(1);

            }
            if(gamepad2.a){
                robot.Claw.setPosition(0);

            }
            //telemetry.addData("SlidePower" , robot.Slide.getPower());




            /*
            if(gamepad1.dpad_up | gamepad1.dpad_down) { // Push up on dpad arm go up push down arm go down
                if (gamepad1.dpad_up) {
                    {
                        robot.Slide.setPosition(-1);
                    }
                }
                if (gamepad1.dpad_down) {
                    robot.Slide.setPosition(0);
                }
            }
            */
        }
    }
}
// having problems with claw and arm "the claw - not enough tension of claw" + "the arm - needs adjustments//
// !!!!!!!!!!!!!//
