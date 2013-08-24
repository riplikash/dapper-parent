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
    public SimpleColor(double r, double g, double b, double a)
    {
        A = r;
        B = g;
        C = b;
        D = a;
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
    public final static SimpleColor WHITE = white;
    public final static SimpleColor black= new SimpleColor(0,0,0);
    public final static SimpleColor BLACK = black;
    public final static SimpleColor LIGHT_GREY = new SimpleColor(.75,.75,.75);
    public final static SimpleColor MED_GREY = new SimpleColor(.5,.5,.5);
    public final static SimpleColor DARK_GREY = new SimpleColor(.25,.25,.25);
    public final static SimpleColor clear = new SimpleColor(0,0,0,0);

    public double getRed() {
        return (A );
    }
    public double getGreen() {
        return (B );
    }
    public double getBlue() {
        return (C );
    }
    public double getAlpha() {
        return (D * 255);
    }
    
}
