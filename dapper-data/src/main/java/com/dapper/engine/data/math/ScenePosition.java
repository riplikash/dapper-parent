package com.dapper.engine.data.math;

public class ScenePosition {

	private double[][] transformation;
	
	public ScenePosition(double[][] m) {
		transformation = Matrix.copy(m);
	}
	public ScenePosition() {
		transformation = Matrix.identity(3);
	}
	
	public ScenePosition(double translateX, double translateY, double scale, double rotation)
	{
		transformation = Matrix.translation(translateX, translateY);
		transformation = Matrix.multiply(transformation, Matrix.rotation(rotation));
		transformation = Matrix.multiply(transformation, Matrix.scale(scale, scale));
	}
	public ScenePosition(double translateX, double translateY, double scaleX, double scaleY, double rotation)
	{
		transformation = Matrix.translation(translateX, translateY);
		transformation = Matrix.multiply(transformation, Matrix.rotation(rotation));
		transformation = Matrix.multiply(transformation, Matrix.scale(scaleX, scaleY));
	}

	public void scale(double x, double y) {
		transformation = Matrix.multiply(transformation, Matrix.scale(x, y));	
	}
	public void scale(Point2D s) 
	{
		transformation = Matrix.multiply(transformation, Matrix.scale(s.getX(), s.getY()));
	}
	
	public void translate(double x, double y) {
		transformation = Matrix.multiply(transformation, Matrix.translation(x,y));
	}
	public void translate(Point2D trans)
	{
		transformation = Matrix.multiply(transformation, Matrix.translation(trans.getX(), trans.getY()));
	}
	
	public void rotate(double x) {
		transformation = Matrix.multiply(transformation, Matrix.rotation(x));
	}
	
	public void scale(double x) {
		transformation = Matrix.multiply(transformation, Matrix.scale(x, x));	
		
	}
	
	public Point2D apply(Point2D point)
	{
		double[] workingPoint = {point.getX(), point.getY(), 1};
		workingPoint = Matrix.multiply(transformation, workingPoint);
		return new Point2D(workingPoint[0], workingPoint[1]);
		
	}
	
	public ScenePosition combine(ScenePosition scenePos) {
		
		return new ScenePosition(Matrix.multiply(transformation, scenePos.transformation));
	}
	
}
