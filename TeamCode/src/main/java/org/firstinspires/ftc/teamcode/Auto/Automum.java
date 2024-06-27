package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

public class Automum extends LinearOpMode {
    DcMotor leftFront; //YOOOOOOOOOOOOOOOOOOOOOOOOOO//
    DcMotor leftBack;
    DcMotor rightFront;
    DcMotor rightBack;
    DcMotor leftLS;
    DcMotor rightLS;

    int leftLSPos;
    int rightLSPos;


    final int TICKS_PER_INCH = 538;

    Servo turn;
     


        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");
        leftLS = hardwareMap.get(DcMotor.class, "leftLS");
        rightLS = hardwareMap.get(DcMotor.class, "rightLS");

        turn = hardwareMap.get(Servo.class,"turn");

        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);
        rightLS.setDirection(DcMotorSimple.Direction.REVERSE);

        leftFront.setPower(0);
        leftBack.setPower(0);
        rightFront.setPower(0);
        rightBack.setPower(0);
        turn.setPosition(0);
}
