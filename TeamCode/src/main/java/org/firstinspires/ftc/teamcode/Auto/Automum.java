package org.firstinspires.ftc.teamcode.Auto;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

public class Automum extends LinearOpMode {

    DcMotor leftFront;
    DcMotor leftBack;
    DcMotor rightFront;
    DcMotor rightBack;

    int leftFrontPOS;
    int leftBackPOS;
    int rightFrontPOS;
    int rightBackPOS;

    final int TICKS_PER_INCH = 538;

    @Override
    public void runOpMode(){

        leftFront = hardwareMap.get(DcMotor.class,"leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);  //So this line resets the encoder after the end of every run//
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER); // This line tells the robot that we are using encoders.//
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);

        leftFront.setPower(0);
        leftBack.setPower(0);
        rightFront.setPower(0);
        rightBack.setPower(0);

        waitForStart();

        move(10*TICKS_PER_INCH,10*TICKS_PER_INCH, 10*TICKS_PER_INCH, 10*TICKS_PER_INCH, .5); //this is a set movement for the auto that makes  it go forward! //

    }

    public void move(int leftFrontPos,int rightFrontPos, int leftBackPos, int rightBackPos, double speed) /*here wer are telling the motors how far to go in terms of inches as well as the speed in which to move*/{
        leftFrontPOS += leftFrontPos;
        leftBackPOS += leftBackPos;
        rightBackPOS += rightBackPos;
        rightFrontPOS += rightFrontPos; /* If we did not add these 4 "equations" then after every turn, the encoder reading would go back to position 0 after ever action. */

        leftFront.setTargetPosition(leftFrontPOS);
        leftBack.setTargetPosition(leftBackPOS);
        rightFront.setTargetPosition(rightFrontPOS);
        rightBack.setTargetPosition(rightBackPOS); /* we are setting the motor target postion to the designated position. */

        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftFront.setPower(speed);
        leftBack.setPower(speed);
        rightFront.setPower(speed);
        rightBack.setPower(speed);

        while (opModeIsActive() && leftFront.isBusy() && leftBack.isBusy() && rightFront.isBusy() && rightBack.isBusy()) {
            idle(); // random thing needed to make auto work ¯\_(ツ)_/¯ //
        }

    }
}
