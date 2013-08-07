package com.dapper.engine.data.objects;

public interface SimpleControllable {
	public abstract void move(double x, double y);
	public void rotate(double r);
	public void skew(double x, double y);
}
