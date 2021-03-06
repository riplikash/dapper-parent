package com.dapper.engine.data.objects;

import java.util.ArrayList;

import javax.media.opengl.GL2;

import com.dapper.engine.data.math.Point2D;
import com.dapper.engine.data.math.SimpleColor;

public class SimpleFont extends DapperObject {
	
	double left, right, top, bottom;


	public SimpleFont(String s, double x, double y, double size) {
		construct(s, x, y, .01 * size, .01 * size, (double)0, SimpleColor.white);		
	}

	public SimpleFont(String s, double x, double y, double xScale,
			double yScale, double rotation, SimpleColor color) {
		construct(s, x, y, xScale, yScale, rotation, color);	
	}
	
	private void construct(String s, double x, double y, double xScale,
			double yScale, double rotation, SimpleColor color) {
		for (int i = 0; i < s.length(); i++)
		{
			double transX = (double)x + i*xScale - i*xScale * .2;
			char c = s.charAt(i);		
			children.add(new SimpleChar(c, transX, y,xScale, yScale, 0, color ));			
		}
		
	}

	@Override
	public void init(GL2 gl) {
		for (DapperObject d : children)
			d.init(gl);
	}

	
}
