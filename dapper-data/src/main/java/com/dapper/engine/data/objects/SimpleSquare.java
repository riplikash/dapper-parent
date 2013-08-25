package com.dapper.engine.data.objects;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

import com.dapper.engine.data.math.Matrix;

import com.dapper.engine.data.math.SimpleColor;

public class SimpleSquare extends DapperObject {
	protected SimpleColor color;
	static double[] a = {-.5,.5,1}; //top left
	static double[] b = {.5,.5,1}; // top right
	static double[] c = {-.5, -.5,1}; // bottom left
	static double[] d = {.5,-.5,1}; // bottom right
	public SimpleSquare(double x, double y, double scaleX, double scaleY,
			double rotation, SimpleColor color) {
		super(x, y, scaleX, scaleY, rotation);	
		this.color = color;
	}

	@Override
	public void render(GL2 gl, double[][] pos) {
		double[][] finalTransformation = getTransformedPosition(pos);
		double[] A = Matrix.multiply(finalTransformation, a);
		double[] B = Matrix.multiply(finalTransformation, b);
		double[] C = Matrix.multiply(finalTransformation, c);
		double[] D = Matrix.multiply(finalTransformation, d);
		gl.glPolygonMode(GL2.GL_FRONT, GL2.GL_FILL);
		gl.glBegin(GL2.GL_POLYGON);
        gl.glColor3d(color.getRed(), color.getGreen(), color.getBlue());
        gl.glVertex3d(C[0],C[1], -1);
        gl.glVertex3d(B[0],B[1], -1);    
        gl.glVertex3d(A[0],A[1], -1);
      
        gl.glVertex3d(D[0],D[1],1);
        gl.glVertex3d(B[0],B[1],1);
        gl.glVertex3d(C[0],C[1],1);

        gl.glEnd();
	}
	public SimpleColor getColor() {
		return color;
	}
	public void setColor(SimpleColor c)
	{
		color = c;
	}
}
