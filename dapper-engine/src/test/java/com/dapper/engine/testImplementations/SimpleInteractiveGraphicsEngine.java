package com.dapper.engine.testImplementations;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;

import org.springframework.beans.factory.annotation.Autowired;

import com.dapper.engine.data.objects.DapperObject;
import com.dapper.engine.data.objects.SimpleShape;
import com.dapper.engine.data.math.*;
import com.dapper.engine.default_implementations.DefaultGraphicsEngine;
import com.dapper.engine.default_implementations.DefaultScene;

public class SimpleInteractiveGraphicsEngine extends DefaultGraphicsEngine{
	@Autowired
	DefaultScene scene;
	
	GL2 gl;

	public SimpleInteractiveGraphicsEngine() {
		super();
	}
	@Override
	public void render(GLAutoDrawable drawable) {
		gl = drawable.getGL().getGL2();
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		for (DapperObject obj: scene.getDisplayScene())
		{
//			renderObject(obj.shape);
			obj.render(gl);
		}
	}

	protected void renderObject(SimpleShape object) {
	    gl.glBegin(GL.GL_TRIANGLES);
        List<Point2D> displayList = object.getDisplayList();
        for (Point2D point : displayList){
            gl.glColor3d(point.getRed(), point.getGreen(), point.getBlue());
            gl.glVertex2d(point.getX(), point.getY());
        }
        gl.glEnd();
	}
}
