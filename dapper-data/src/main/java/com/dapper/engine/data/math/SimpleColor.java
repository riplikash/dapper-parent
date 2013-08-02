package com.dapper.engine.data.math;

import java.awt.Color;

/**
 * Created with IntelliJ IDEA.
 * User: blake
 * Date: 8/7/12
 * Time: 7:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleColor extends Vector4D{
    public SimpleColor(double r, double g, double b)
    {
        A = r;
        B = g;
        C = b;
        D = 1.0;
    }
    public SimpleColor()
    {
        A = 0.0;
        B = 0.0;
        C = 0.0;
        D = 1.0;
    }

    public final static SimpleColor red = new SimpleColor(1,0,0);
    public final static SimpleColor RED = red;
    public final static SimpleColor green = new SimpleColor(0,1,0);
    public final static SimpleColor GREEN = green;
    public final static SimpleColor blue = new SimpleColor(0,0,1);
    public final static SimpleColor BLUE = blue;
    public final static SimpleColor white = new SimpleColor(1,1,1);
    public final static SimpleColor WHIE = white;
    public final static SimpleColor black= new SimpleColor(0,0,0);
    public final static SimpleColor BLACK = black;


    public double getRed() {
        return (A * 255);
    }
    public double getGreen() {
        return (B * 255);
    }
    public double getBlue() {
        return (C * 255);
    }
    public double getAlpha() {
        return (D * 255);
    }
    
}
