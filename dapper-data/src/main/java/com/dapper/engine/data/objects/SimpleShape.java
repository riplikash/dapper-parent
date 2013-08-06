package com.dapper.engine.data.objects;

import java.util.ArrayList;
import java.util.List;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

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
    
    public ScenePosition pos;
 
    public SimpleColor color;
    
    public SimpleShape(Point2D translation, Point2D scaleVar)
    {
    	pos = new ScenePosition(translation.getX(), translation.getY(), scaleVar.getX(), scaleVar.getY(), 0);

        this.color = SimpleColor.WHITE;
        
    }

    public SimpleShape(Point2D translation, Point2D scaleVar, SimpleColor color)
    {
    	pos = new ScenePosition(translation.getX(), translation.getY(), scaleVar.getX(), scaleVar.getY(), 0);
        this.color = color;
    }

    SimpleShape() {
        pos = new ScenePosition();
        this.color = SimpleColor.WHITE;
    }

    public abstract List<Point2D> getDisplayList();

    public ArrayList<Point2D> getTransformedPoints()
    {
        ArrayList<Point2D> rtPoints = new ArrayList<Point2D>();
        
        for (Point2D point: points)
        {
            rtPoints.add(Math2D.translate(Math2D.rotate(Math2D.scale(point, pos.getScalePoint()),  pos.rotation), pos.getTransformPoint()));
        }
        return rtPoints;

    }
    public ArrayList<Point2D> getTransformedPoints(ScenePosition pos)
    {
        ArrayList<Point2D> rtPoints = new ArrayList<Point2D>();
        for (Point2D point: points)
        {
            rtPoints.add(Math2D.translate(Math2D.rotate(Math2D.scale(point, pos.getScalePoint()),  pos.rotation), pos.getTransformPoint()));
        }
        return rtPoints;

    }

    public void rotate(double rotation)
    {
        pos.rotate(rotation);
    }


	abstract public void render(GL2 gl) ;
}
