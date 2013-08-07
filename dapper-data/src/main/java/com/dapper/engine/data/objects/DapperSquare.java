package com.dapper.engine.data.objects;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;

import com.dapper.engine.data.math.Matrix;

import com.dapper.engine.data.math.SimpleColor;

public class DapperSquare extends NewDapperObject {
	static double[] a = {-.5,.5,1}; //top left
	static double[] b = {.5,.5,1}; // top right
	static double[] c = {-.5, -.5,1}; // bottom left
	static double[] d = {.5,-.5,1}; // bottom right
	public DapperSquare(double x, double y, double scaleX, double scaleY,
			double rotation, SimpleColor color) {
		super(x, y, scaleX, scaleY, rotation, color);		
	}

	@Override
	public void render(GL2 gl, double[][] pos) {
		double[][] finalTransformation = Matrix.multiply(pos, this.pos);
		double[] A = Matrix.multiply(finalTransformation, a);
		double[] B = Matrix.multiply(finalTransformation, b);
		double[] C = Matrix.multiply(finalTransformation, c);
		double[] D = Matrix.multiply(finalTransformation, d);
		
		System.out.println(Matrix.toString(pos));
		
		gl.glBegin(GL.GL_TRIANGLES);
        gl.glColor3d(color.getRed(), color.getGreen(), color.getBlue());

            gl.glVertex2d(A[0],A[1]);
            gl.glVertex2d(B[0],B[1]);
            gl.glVertex2d(C[0],C[1]);
            
            gl.glVertex2d(C[0],C[1]);
            gl.glVertex2d(B[0],B[1]);
            gl.glVertex2d(D[0],D[1]);

        gl.glEnd();
	}

}
