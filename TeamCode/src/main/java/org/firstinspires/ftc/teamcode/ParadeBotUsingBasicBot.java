package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ParadeBotUsingBasicBot extends BasicBot
{
    LinearOpMode linearOpMode;
    public ParadeBotUsingBasicBot(HardwareMap hardwareMap, LinearOpMode linearOpMode_given)
    {
        super(hardwareMap);
        linearOpMode = linearOpMode_given;
    }

    public void pivot(double degrees, double pow)
    {
        pow = Math.abs(pow);
        super.resetEncoders();
        double encTarget = Math.abs(17.254 * Math.abs(degrees) + 367.295);

        if (degrees < 0)
        {
            super.driveMotors(pow, -pow);
        }
        else
        {
            super.driveMotors(-pow, pow);
        }

        while (Math.abs(super.getDriveLeftOne().getCurrentPosition()) < encTarget && !linearOpMode.isStopRequested())
        {
        }
        driveMotors(0,0);
    }
}
