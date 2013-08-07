package com.dapper.a_star.interfaces;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dapper.engine.data.math.Point2D;
import com.dapper.engine.data.math.SimpleColor;
import com.dapper.engine.data.objects.SimpleFont;
import com.dapper.engine.data.objects.SimpleSquare;
import com.dapper.engine.default_implementations.DefaultScene;

@Component
public class SearchGrid {
	public GridSquare [][] grid;	
	
	@Autowired
	DefaultScene scene;
	
	public SearchGrid() {

	}
	public void init() {
		Integer [][] t = new Integer[10][10];
		grid = new GridSquare[10][10];
		SimpleSquare tGraphic;
		GridSquare square;
		for (double y = 0; y < 10; y++)
		{
			for (double x = 0; x < 10; x++)
			{
				
				tGraphic = new SimpleSquare(new Point2D(getCoord(x), getCoord(y) * -1), new Point2D(.18, .18), SimpleColor.BLUE);
				square = new GridSquare(1, getCoord(x), getCoord(y) * -1, .18, .18, (int)(x * 10 + y));
				grid[(int)x][(int)y] = square;
				scene.add(square);
				String s = "(" + new Double(x).toString().charAt(0) + "," + new Double(y).toString().charAt(0) + ")";
				
				
				
			}
		}
	}
	
	double getCoord(double d) {	return (((d/10)*2)-1) + 0.01; }
}
