package com.dapper.engine.data.objects;

import java.util.ArrayList;
import java.util.List;

import com.dapper.engine.data.math.*;


/**
 * Created with IntelliJ IDEA.
 * User: blake
 * Date: 8/7/12
 * Time: 8:40 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class SimpleShape {
    ArrayList<Point2D> points;
    public Point2D translation;
    Point2D scaleVar;
    double rotationVar;
    SimpleColor color;

    public SimpleShape(Point2D translation, Point2D scaleVar, SimpleColor color)
    {
        this.translation = translation;
        this.scaleVar = scaleVar;
        this.color = color;
        this.rotationVar = 0;
    }

    SimpleShape() {
        points = null;
        translation = null;
        scaleVar = null;
        color = null;
    }

    public abstract List<Point2D> getDisplayList();

    public void scale(double x, double y) {
        scaleVar.add(x, y);
    }


    public ArrayList<Point2D> getTransformedPoints()
    {
        ArrayList<Point2D> rtPoints = new ArrayList<Point2D>();
        for (Point2D point: points)
        {
            rtPoints.add(Math2D.translate(Math2D.rotate(Math2D.scale(point, scaleVar),  rotationVar), translation));
        }
        return rtPoints;

    }

    public void rotate(double rotation)
    {
        this.rotationVar += rotation;
    }
}
