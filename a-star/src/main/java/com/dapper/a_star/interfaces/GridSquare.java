package com.dapper.a_star.interfaces;

import java.util.ArrayList;

import javax.media.opengl.GL2;

import com.dapper.engine.data.math.Point2D;
import com.dapper.engine.data.math.SimpleColor;
import com.dapper.engine.data.objects.DapperObject;
import com.dapper.engine.data.objects.SimpleFont;
import com.dapper.engine.data.objects.SimpleSquare;

public class GridSquare extends DapperObject {
	public int weight;
	public boolean processed;
	SimpleFont countFace;
	
	
	public GridSquare(int weight, double x, double y, double scaleX, double scaleY, int id) {
		super(new SimpleSquare(new Point2D(x, y), new Point2D(scaleX, scaleY), SimpleColor.red), id);
		this.weight = weight;
		processed = false;
		String temp = new Integer(weight).toString();
		Point2D translation = new Point2D(x, y);
		countFace = new SimpleFont(temp, translation, 7);
		
	}
	public GridSquare(int weight) {
		shape.color = SimpleColor.red;
		this.weight = weight;
		processed = false;
	}
	public GridSquare() {
		shape.color = SimpleColor.red;
		this.weight = 1;
		processed = false;
	}
	
	public void changeColor(SimpleColor c)
	{
		shape.color = c;
		
	}
	public SimpleColor getColor() {
		return shape.color;
	}
	public void toggle() {
		printPoints();
		weight++;
		String temp = new Integer(weight).toString();
		Point2D translation = null;//shape.pos.getTranslatePoint();
		countFace = new SimpleFont(temp, translation, 7);
		if (processed)
		{
			shape.color = SimpleColor.blue;
			processed = false;
		} else {
			shape.color = SimpleColor.green;
			processed = true;
		}
		
	}
	private void printPoints() {
		ArrayList<Point2D> list = shape.getTransformedPoints();
		for (Point2D p : list) {
    		System.out.println(p.getX() + ", " + p.getY());
		}
		
	}
	
	public void render(GL2 gl) {
		shape.render(gl);
		countFace.render(gl);
	}

}
