package com.dapper.engine.data.math;

public class ScenePosition {
	public  double translateX;
	public double translateY;
	public double scaleX;
	public double scaleY;
	public double rotation;
	
	public ScenePosition() {
		translateX = 0;
		translateY = 0;
		scaleX = 1;
		scaleY= 1;
		rotation = 0;
	}
	
	public ScenePosition(double translateX, double translateY, double scale, double rotation)
	{
		this.translateX = translateX;
		this.translateY = translateY;
		this.scaleX = scale;
		this.scaleY = scale;
		this.rotation = rotation;
	}
	public ScenePosition(double translateX, double translateY, double scaleX, double scaleY, double rotation)
	{
		this.translateX = translateX;
		this.translateY = translateY;
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
	
	public void translate(double x, double y) {
		translateX += x;
		translateY += y;
	}
	public void translate(Point2D translateation)
	{
		translate(translateation.getX(), translateation.getY());
	}
	
	public void rotate(double x) {
		rotation += x;
	}
	
	public void scale(double x) {
		scale(x, x);
		
	}
	
	public Point2D apply(Point2D point)
	{
		
		return Math2D.translate(Math2D.rotate(Math2D.scale(point, getScalePoint()), rotation), getTransformPoint());
		
	}
	
	public Point2D getScalePoint()
	{
		return new Point2D(scaleX, scaleY);
	}
	
	public Point2D getTransformPoint()
	{
		return new Point2D(translateX, translateY);
	}

	public ScenePosition combine(ScenePosition scenePos) {
		ScenePosition newPos = new ScenePosition();
		newPos.scaleX = this.scaleX * scenePos.scaleX;
		newPos.scaleY = this.scaleY * scenePos.scaleY;
		newPos.rotation = this.rotation + scenePos.rotation;
		newPos.translateX = this.translateX + scenePos.translateX;
		newPos.translateY = this.translateY + scenePos.translateY;
		return newPos;
	}
	
}
