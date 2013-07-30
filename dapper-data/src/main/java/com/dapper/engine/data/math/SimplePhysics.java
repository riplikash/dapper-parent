package com.dapper.engine.data.math;

import com.dapper.engine.data.objects.SimpleObject;


/**
 * Created with IntelliJ IDEA.
 * User: blake
 * Date: 8/8/12
 * Time: 12:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimplePhysics {
    public static void apply(SimpleObject square) {
        applyGravity(square);
        applyWalls(square);


    }

    private static void applyWalls(SimpleObject square) {
        applyCollisions(square);
    }

    private static void applyCollisions(SimpleObject square) {
        boolean xHit = false;
        boolean yHit = false;
        for (Point2D point: square.getShape().getDisplayList())
        {
            if (!xHit)
            {
                if (point.getX() < -1 )
                {
                    double difference = point.getX() + 1;
                    square.move(difference*-1, 0);

                    xHit = true;
                    double xAccel = square.getVector().getX() * -1;
                    if (xAccel > 0)
                    {
                        double bounciness = square.getBounciness();
                        Double reboundForce = xAccel + xAccel * bounciness;
                        square.accel(reboundForce, 0);
                    }
                } else if (point.getX() > 1)
                {
                    double difference = point.getX() - 1;
                    square.move(difference*-1, 0);
                    xHit = true;
                    double xAccel = square.getVector().getX() * -1;
                    if (xAccel < 0)
                    {
                        double bounciness = square.getBounciness();
                        Double reboundForce = xAccel + xAccel * bounciness;
                        square.accel(reboundForce, 0);
                    }

                }
            }
            if (!yHit)
            {
                if (point.getY() < -1 )
                {
                    if (point.getY() < -1.01)
                    {
                        double difference = point.getY() + 1;
                        square.move(0, difference*-1);
                    }
                    yHit = true;
                    double yAccel = square.getVector().getY() * -1;
                    if (yAccel > 0)
                    {
                        double bounciness = square.getBounciness();
                        Double reboundForce = yAccel + yAccel * bounciness;
                        square.accel(0, reboundForce);
                    }
                } else if (point.getY() > 1)
                {
                    double difference = point.getY() - 1;
                    square.move(0, difference*-1);
                    yHit = true;
                    double yAccel = square.getVector().getY() * -1;
                    if (yAccel < 0)
                    {
                        double bounciness = square.getBounciness();
                        Double reboundForce = yAccel + yAccel * bounciness;
                        square.accel(0, reboundForce);
                    }

                }
            }
        }
    }

    private static boolean hasCollision(SimpleObject square) {
        return false;  //To change body of created methods use File | Settings | File Templates.
    }

    private static void applyGravity(SimpleObject square) {
        square.accel(0.0,-0.001);
    }
}
