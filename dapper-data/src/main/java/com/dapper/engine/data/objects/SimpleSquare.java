package com.dapper.engine.data.objects;

import java.util.ArrayList;
import java.util.List;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

import com.dapper.engine.data.math.Point2D;
import com.dapper.engine.data.math.SimpleColor;

/**
 * Created with IntelliJ IDEA.
 * User: blake
 * Date: 8/7/12
 * Time: 7:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleSquare extends SimpleShape{
	public SimpleSquare() {};
    public SimpleSquare(Point2D translation, Point2D scale)
    {
        super(translation, scale);
        points = new ArrayList<Point2D>();
        points.add(new Point2D(0, 0));
        points.add(new Point2D(1, 0));
        points.add(new Point2D(0, -1));

        points.add(new Point2D(0, -1));
        points.add(new Point2D(1, 0));
        points.add(new Point2D(1, -1));
    }
    public SimpleSquare(Point2D translation, Point2D scale, SimpleColor color)
    {
        super(translation, scale, color);
        points = new ArrayList<Point2D>();
        points.add(new Point2D(0, 0));
        points.add(new Point2D(1, 0));
        points.add(new Point2D(0,-1));

        points.add(new Point2D(0, -1));
        points.add(new Point2D(1, 0));
        points.add(new Point2D(1, -1));
    }

    @Override
    public List<Point2D> getDisplayList() {
        return getTransformedPoints();
    }
    
    @Override
    public void render(GL2 gl)
    {
    	List<Point2D> displayList = getTransformedPoints();
    	gl.glBegin(GL.GL_TRIANGLES);
        gl.glColor3d(color.getRed(), color.getGreen(), color.getBlue());
        for (Point2D point : displayList){          
        	
            gl.glVertex2d(point.getX(), point.getY());
        }
        gl.glEnd();
    }
}
