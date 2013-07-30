package com.dapper.engine.data.objects;

import com.dapper.engine.data.math.*;


/**
 * Created with IntelliJ IDEA.
 * User: blake
 * Date: 8/8/12
 * Time: 12:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleObject {
    double rotationTheta;
    Point2D vector;
    SimpleSquare square;
    private double bounciness;
    public int id;

    public SimpleObject() {
        square = new SimpleSquare(new Point2D(0,0), new Point2D(.5,.5), SimpleColor.RED);
        vector = new Point2D(0,0);
        bounciness = 50;
    }

    public SimpleObject(Point2D translation, Point2D scale, SimpleColor color) {
        square = new SimpleSquare(translation, scale, color);
        vector = new Point2D(0,0);
        bounciness = 50;
    }

    public void rotatationalAccel(double theta)
    {
        rotationTheta += theta;
    }

    public void accel(Point2D theta)
    {
        vector.add(theta.getX(), theta.getY());
    }
    public void accel(double xTheta, double yTheta)
    {
        vector.add(xTheta, yTheta);
    }

    public Point2D getVector()
    {
        return vector;
    }

    public void increment()
    {
        square.rotate(rotationTheta);
        square.translation.add(vector.getX(), vector.getY());
    }

    public void scale(double x, double y) {
        square.scale(x, y);
    }

    public SimpleSquare getShape()
    {
        return square;
    }

    public void xAccelStop() {
        vector.setX(0);
    }

    public void yAccelStop() {
        vector.setY(0);
    }

    public void setBounciness(double b)
    {
        if (bounciness > 0)
            bounciness = b;
        else
            bounciness = 0;
    }

    public double getBounciness() {
        return bounciness/100;
    }

    public void move(double x, double y) {
        square.translation.add(x, y);

    }
}
