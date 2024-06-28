package org.firstinspires.ftc.teamcode.Teleop;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import com.qualcomm.robotcore.util.SoftwareVersionWarningSource;
//importing other classes to use the functions and etc defined in them

public class MechamumTestDrive extends OpMode { //creating a class and extending it to use the functions and etc in the OpMode Class

    DcMotor leftFront; //Creating and labeling DcMotors by using objects from the DcMotor class //
    DcMotor leftBack;
    DcMotor rightFront;
    DcMotor rightBack;
    DcMotor leftLS;
    DcMotor rightLS;

    int leftLSPos;
    int rightLSPos;


    final int TICKS_PER_INCH = 538;//Create a variable for ticks per inch

    Servo turn;
    @Override
    public void init() {


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


        lSMove(30 * TICKS_PER_INCH, 30 * TICKS_PER_INCH, 0.25); //Using the ticks per inch variable to assign a certain number of inches that the linear slides should go; Make as many as you need for the linear slides to go up and up

    }



    public void lSMove(int leftLSPOS, int rightLSPOS, double speed) { //the function lsMove is defined by the variables leftLSPOS, rightLSPOS, and speed

        leftLSPos += leftLSPOS;//assigning the value of leftLSPOS to leftLSPos because
        //if we used the leftLSPOS in the following code the value would change back to zero each time we have the linear slides move; so we use leftLSPos instead because when you change the value of that variable it doesn't return to zero
        rightLSPos += rightLSPOS;//assigning the value of rightLSPOS to rightLSPos

        leftLS.setTargetPosition(leftLSPos); //setting the target position of the linear slide motors to be the assigned number of ticks
        rightLS.setTargetPosition(rightLSPos);

        leftLS.setMode(DcMotor.RunMode.RUN_TO_POSITION); //telling it to run to that position
        rightLS.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftLS.setPower(speed); //setting the speed as the variable speed defined earlier
        rightLS.setPower(speed);
    }
}
