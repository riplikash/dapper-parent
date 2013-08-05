package com.dapper.engine.data.objects;

import java.util.ArrayList;

import javax.media.opengl.GL2;

import com.dapper.engine.data.math.Point2D;

public class SimpleFont extends DapperObject{
	
	double left, right, top, bottom;
	ArrayList<SimpleChar> charList;
	public SimpleFont(String s, Point2D startPoint, double size) {
		charList = new ArrayList<SimpleChar>();
		// 10pt = 1/10th the screen
		
		for (int i = 0; i < s.length(); i++)
		{
			Point2D scale = new Point2D(.6 * .01 * size, .01 * size);
			Point2D translation = new Point2D(startPoint.getX() + i * scale.getX(), startPoint.getY());
			char c = s.charAt(i);						
			charList.add(new SimpleChar(c, translation, scale));
			
		}
		
	}
	
	@Override
	public void render(GL2 gl) {
		for (SimpleChar c: charList)
			c.render(gl);
	}
	
	
}
