package com.dapper.engine.data.math;

/**
 * Created with IntelliJ IDEA.
 * User: blake
 * Date: 8/7/12
 * Time: 7:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class Point2D extends Vector4D{
    SimpleColor color;
    public Point2D(double a, double b)
    {
        A = a;
        B = b;
        C = 0.0;
        D = 0.0;
    }
    public Point2D(double a, double b, SimpleColor pointColor)
    {
        A = a;
        B = b;
        C = 0.0;
        D = 0.0;
        color = pointColor;
    }

    public Point2D(Point2D point) {
        A = point.A;
        B = point.B;
        C = 0.0;
        D = 0.0;
        color = point.color;
    }

    public double getRed() {
        return color.getRed();
    }
    public double getGreen() {
        return color.getGreen();
    }
    public double getBlue() {
        return color.getBlue();
    }
    public double getAlpha() {
        return color.getAlpha();
    }

    public double getX()
    {
        return A;
    }
    public double getY()
    {
        return B;
    }
    public void setX(double x)
    {
        A = x;
    }
    public void setY(double y)
    {
        B = y;
    }

    public void add(double x, double y)
    {
        A += x;
        B += y;
    }


}
