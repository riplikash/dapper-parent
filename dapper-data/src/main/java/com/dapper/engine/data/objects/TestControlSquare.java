package com.dapper.engine.data.objects;

import com.dapper.engine.data.interfaces.TestControllableInterface;
import com.dapper.engine.data.math.Matrix;
import com.dapper.engine.data.math.SimpleColor;

public class TestControlSquare extends SimpleSquare implements TestControllableInterface {

	public TestControlSquare(double x, double y, double scaleX, double scaleY,
			double rotation, SimpleColor color) {
		super(x, y, scaleX, scaleY, rotation, color);
	}

	public void move(double x, double y) {
		pos = Matrix.multiply(pos, Matrix.translation(x, y));
		
	}

	public void rotate(double r) {
		pos = Matrix.multiply(pos, Matrix.rotation(r));
		
	}

	public void skew(double x, double y) {
		pos = Matrix.multiply(pos,  Matrix.skew(x, y));
		
	}

}
