package com.dapper.engine.data.objects;

import java.util.ArrayList;
import java.util.List;

import javax.media.opengl.GL2;

import com.dapper.engine.data.math.Matrix;
import com.dapper.engine.data.math.SimpleColor;

public abstract class NewDapperObject {
	protected double[][] pos;
	SimpleColor color;
	List<NewDapperObject> children;

	public NewDapperObject() {
		pos = Matrix.identity(3);	
		color = color.clear;
		children = new ArrayList<NewDapperObject>();
	}
	
	public NewDapperObject(double x, double y, double scaleX, double scaleY, double rotation, SimpleColor color) {
		pos = Matrix.new2DPosition(x, y, scaleX, scaleY, rotation);
		this.color = color;
		children = new ArrayList<NewDapperObject>();
	}
	public NewDapperObject(double[][] newPos, SimpleColor color) {
		pos = newPos;
		this.color = color;
	}
	public abstract void render(GL2 gl, double[][] pos);
	public void render(GL2 gl) {
		render(gl, Matrix.identity(3));
	};
	
	public void addChild(NewDapperObject c)
	{
		children.add(c);
	}
	
}
