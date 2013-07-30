package com.dapper.engine.data.math;

/**
 * Created with IntelliJ IDEA.
 * User: blake
 * Date: 8/8/12
 * Time: 11:22 AM
 * To change this template use File | Settings | File Templates.
 */
public class Math2D {
    public static Point2D translate(Point2D point, Point2D translation)
    {
        Point2D rtPoint =  new Point2D(point);
        rtPoint.add(translation.getX(), translation.getY());
        return rtPoint;
    }
    public static Point2D scale(Point2D point, Point2D scale)
    {
        Point2D rtPoint = new Point2D(point);
        rtPoint.setX(point.getX() * scale.getX());
        rtPoint.setY(point.getY() * scale.getY());
        return rtPoint;
    }
    public static Point2D rotate(Point2D point, double rotation)
    {
        Point2D rtPoint = new Point2D(point);
        double cosTheta = Math.cos(rotation);
        double sinTheta = Math.sin(rotation);
        rtPoint.setX(point.getX() * cosTheta - point.getY() * sinTheta);
        rtPoint.setY(point.getX() * sinTheta + point.getY() * cosTheta);
        return rtPoint;
    }

}
