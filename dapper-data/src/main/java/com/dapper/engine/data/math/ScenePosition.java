package com.dapper.engine.data.math;

public class ScenePosition {
	public  double transformX;
	public double transformY;
	public double scaleX;
	public double scaleY;
	public double rotation;
	
	public ScenePosition() {
		transformX = 0;
		transformY = 0;
		scaleX = 0;
		scaleY= 0;
		rotation = 0;
	}
	
	public ScenePosition(double transformX, double transformY, double scale, double rotation)
	{
		this.transformX = transformX;
		this.transformY = transformY;
		this.scaleX = scale;
		this.scaleY = scale;
		this.rotation = rotation;
	}
	public ScenePosition(double transformX, double transformY, double scaleX, double scaleY, double rotation)
	{
		this.transformX = transformX;
		this.transformY = transformY;
		this.scaleX = scaleX;
		this.scaleY = scaleY;
		this.rotation = rotation;
	}

	public void scale(double x, double y) {
		scaleX *= x;
		scaleY *= y;		
	}
	public void scale(Point2D s) 
	{
		scale(s.getX(), s.getY());
	}
	
	public void transform(double x, double y) {
		transformX += x;
		transformY += y;
	}
	public void transform(Point2D transformation)
	{
		transform(transformation.getX(), transformation.getY());
	}
	
	public void rotate(double x) {
		rotation += x;
	}
	
	public void scale(double x) {
		scale(x, x);
		
	}
	
	public Point2D apply(Point2D point)
	{
		
		return point;
		
	}
	
	public Point2D getScalePoint()
	{
		return new Point2D(scaleX, scaleY);
	}
	
	public Point2D getTransformPoint()
	{
		return new Point2D(transformX, transformY);
	}
	
}
