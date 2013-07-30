package com.dapper.engine.data.objects;

import java.util.ArrayList;
import java.util.List;

import com.dapper.engine.data.math.Point2D;


/**
 * Created with IntelliJ IDEA.
 * User: blake
 * Date: 8/7/12
 * Time: 7:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimplePolygon extends SimpleShape {
    SimplePolygon(Point2D a, Point2D b, Point2D c) {
        points = new ArrayList<Point2D>();
        points.add(a);
        points.add(b);
        points.add(c);
    }

    public List<Point2D> getDisplayList() {
        return points;
    }
}
