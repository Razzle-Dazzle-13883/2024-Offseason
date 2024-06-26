package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

public class MechamumTestDrive extends OpMode {


    DcMotor leftFront; //YOOOOOOOOOOOOOOOOOOOOOOOOOO//
    DcMotor leftBack;
    DcMotor rightFront;
    DcMotor rightBack;

    Servo turn;
    @Override
    public void init() {


        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");

        turn = hardwareMap.get(Servo.class,"turn");

        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);

        leftFront.setPower(0);
        leftBack.setPower(0);
        rightFront.setPower(0);
        rightBack.setPower(0);
        turn.setPosition(0);
    }

    @Override
    public void loop() /*When you press play on your phone this is what shows up type shi*/{

        double forward = -gamepad1.left_stick_y;
        double strafe = gamepad1.left_stick_x;
        double rotation = gamepad1.right_stick_x;

        leftFront.setPower(forward+strafe+rotation);
        leftBack.setPower(forward-strafe+rotation);
        rightFront.setPower(forward-strafe-rotation);
        rightBack.setPower(forward+strafe-rotation);

        if(gamepad1.a){
            turn.setPosition(1);
        }


    }
}
