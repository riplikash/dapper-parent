package org.sandbox.psychadelic;

import javax.media.opengl.GL2;

import com.dapper.engine.data.math.SimpleColor;
import com.dapper.engine.data.objects.SimpleSquare;

public class NestedBox extends SimpleSquare {
	public static SimpleColor color1;
	public static SimpleColor color2;
	public static SimpleColor color3;
	
	public NestedBox(double x, double y, double scaleX, double scaleY,
			double rotation, SimpleColor color) {
		super(x, y, scaleX, scaleY, rotation, color);
	}
	public static double tx = 0;
	public static double ty = 0;
	public static double sx = .96;
	public static double sy = .96;
	public static double rot = 0;
	public static double defaultTx = 0;
	public static double defaultTy = 0;
	public static double defaultSx = .96;
	public static double defaultSy = .96;
	public static double defaultRot = 0;

	public NestedBox(SimpleColor c) {
		super(tx, ty, sx, sy, rot, c);
	}

	public SimpleColor getNextColor() {
		if (this.color == color1)
			return color2;
		else if (this.color == color2)
			return color3;
		else return color1;
	}

	public NestedBox getNext() {
		return (NestedBox) children.get(0);
	}
	
	@Override
	public void render(GL2 gl, double[][] pPos)
	{
		super.render(gl, pPos);
		renderChildren(gl, pPos);
		
	}

	public static void reset() {
		tx = defaultTx;
		ty = defaultTy;
		sx = defaultSx;
		sy = defaultSy;
		rot = defaultRot;
		
	}

}
