package com.dapper.engine.data.objects;

import java.util.List;

import javax.media.opengl.GL2;

import com.dapper.engine.data.math.Point2D;

public class DapperObject {
	public SimpleShape shape;
	public Integer id;
	public DapperObject() { }
	public DapperObject(SimpleShape shape, Integer id) {
		this.shape = shape;
		this.id = id;		

	}
	public List<Point2D> getDisplayList() {
		return shape.getDisplayList();
	}
	public void move(double xMove, double yMove) {
		this.shape.pos.transform(xMove, yMove);
		
		
	}

	public void render(GL2 gl) {
		shape.render(gl);
	}
	
}
