package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Hardware {
    public DcMotor  FrontRightMotor, BackLeftMotor, FrontLeftMotor, BackRightMotor;
    public DcMotor ClawArm;
    double frontRightPower, frontLeftPower, backRightPower, backLeftPower;
    public CRServo Slide;
    public Servo servo;
    public Servo Claw;

    public void initMotors(HardwareMap ahwMap) {
        HardwareMap hwMap = ahwMap;
        FrontRightMotor = hwMap.get(DcMotor.class, "FrontRightMotor");
        FrontLeftMotor = hwMap.get(DcMotor.class, "FrontLeftMotor");
        BackRightMotor = hwMap.get(DcMotor.class, "BackRightMotor");
        BackLeftMotor = hwMap.get(DcMotor.class, "BackLeftMotor");
        ClawArm = hwMap.get(DcMotor.class, "ClawArm");
        servo = hwMap.get(Servo.class, "servo");
        Claw = hwMap.get(Servo.class, "Claw");
        //Slide = hwMap.get(CRServo.class, "bup");
        FrontRightMotor.setDirection(DcMotor.Direction.FORWARD);
        FrontLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        BackRightMotor.setDirection(DcMotor.Direction.FORWARD);
        BackLeftMotor.setDirection(DcMotor.Direction.REVERSE);

        FrontRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        FrontLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackRightMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        BackLeftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        ClawArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }
}