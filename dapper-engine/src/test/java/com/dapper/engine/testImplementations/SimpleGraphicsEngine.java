package com.dapper.engine.testImplementations;

import java.util.Iterator;
import java.util.List;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dapper.engine.default_implementations.DefaultGraphicsEngine;

public class SimpleGraphicsEngine extends DefaultGraphicsEngine {

	List<Float> scene;
	public List<Float> getScene() {
		return scene;
	}
	public void setScene(List<Float> scene) {
		this.scene = scene;
	}
	public SimpleGraphicsEngine() {
		super();
	}
	@Override
	public void render(GLAutoDrawable drawable) {
	
			GL2 gl = drawable.getGL().getGL2();
			Iterator itr = scene.iterator();
			while (itr.hasNext()) {
				float a = (float)itr.next();
				float b = (float)itr.next();
				float c = (float)itr.next();

				triangle(a, b, c, gl);
			}
//		    triangle((float)-.8, (float)-0.8, (float) 0.2, gl);
//		    triangle((float).8, (float)-0.6, (float) 0.4, gl);
//		    triangle((float)-.6, (float)-0.4, (float) 0.6, gl);
//		    triangle((float).8, (float)0.8, (float) 0.2, gl);
		   
	}

	void triangle(float x, float y, float size, GL2 gl)
	{
		 // draw a triangle filling the window
	    gl.glBegin(GL.GL_TRIANGLES);
	    gl.glColor3f(1, 0, 0);
	    gl.glVertex2f( (x - size/2),  (y-size/2));
	    gl.glColor3f(0, 1, 0);
	    gl.glVertex2f(x, (y+size/2));
	    gl.glColor3f(0, 0, 1);
	    gl.glVertex2f( (x+size/2), y-size/2);

	    gl.glEnd();		
	}
	
	
	

}
