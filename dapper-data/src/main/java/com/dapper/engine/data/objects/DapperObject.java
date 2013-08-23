package com.dapper.engine.data.objects;

import java.util.ArrayList;
import java.util.List;

import javax.media.opengl.GL2;

import com.dapper.engine.data.math.Matrix;
import com.dapper.engine.data.math.SimpleColor;

public abstract class DapperObject {
	protected double[][] pos;
	protected SimpleColor color;
	protected List<DapperObject> children;

	public DapperObject() {
		pos = Matrix.identity(3);	
		children = new ArrayList<DapperObject>();
	}
	
	public DapperObject(double x, double y, double scaleX, double scaleY, double rotation) {
		pos = Matrix.new2DPosition(x, y, scaleX, scaleY, rotation);
		children = new ArrayList<DapperObject>();
	}
	public DapperObject(double[][] newPos) {
		pos = newPos;
	}
	public abstract void render(GL2 gl, double[][] pos);
	public void render(GL2 gl) {
		render(gl, Matrix.identity(3));
	};
	public double[][] getTransformedPosition(double[][] d)
	{
//		System.out.println(Matrix.toString(Matrix.multiply(d,  this.pos)));
		return Matrix.multiply(d, this.pos);	
	}
	public void addChild(DapperObject c)
	{
		children.add(c);
	}
	
	public void transform(double[][] newP)
	{
		pos = Matrix.multiply(pos, newP);
	}

	


}
