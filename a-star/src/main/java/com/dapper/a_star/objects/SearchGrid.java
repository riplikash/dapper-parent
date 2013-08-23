package com.dapper.a_star.objects;


import javax.media.opengl.GL2;

import com.dapper.engine.data.math.Matrix;
import com.dapper.engine.data.objects.DapperObject;

public class SearchGrid extends DapperObject {
	public GridSquare [][] grid;	
	
	public SearchGrid() {
		init();
	}
	public void init() {
		grid = new GridSquare[10][10];
		for (double y = 0; y < 10; y++)
		{
			for (double x = 0; x < 10; x++)
			{
				grid[(int)x][(int)y] = new GridSquare(1, getCoord(x), getCoord(y) * -1, .18, .18);					
			}
		}
	}
	
	double getCoord(double d) {	return (((d/10)*2)-1) + 0.01 + .09; }
	
	@Override
	public void render(GL2 gl, double[][] pos) {
		double[][] finalTransformation = getTransformedPosition(pos);
		for (int x = 0; x < 10; x++)
			for (int y = 0; y < 10; y++)
				grid[x][y].render(gl, finalTransformation);
		
	}

}
