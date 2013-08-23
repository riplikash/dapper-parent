package com.dapper.a_star.objects;

import javax.media.opengl.GL2;

import com.dapper.engine.data.math.Matrix;
import com.dapper.engine.data.math.SimpleColor;
import com.dapper.engine.data.objects.DapperObject;


public class AStarModule extends DapperObject {
	SearchGrid grid;
	GridBoard board;
	public AStarModule() {
		super();
		board = new GridBoard(.25, .25, .75, .75, 0, SimpleColor.LIGHT_GREY);
		grid = board.getGrid();
		this.pos = Matrix.identity(3);
	}
	@Override
	public void render(GL2 gl, double[][] pos) {
		board.render(gl, getTransformedPosition(pos));				
	}

	public void click(int x, int y) {
		grid.grid[x][y].toggle();		
	}
	public void left() {
		board.transform(Matrix.translation(-.05, 0));
		
	}
	public void right() {
		board.transform(Matrix.translation(.05, 0));	
		
	}
	public void rotLeft() {
		board.transform(Matrix.rotation(-5));
		
	}
	public void rotRight() {
		board.transform(Matrix.rotation(5));
		
	}
	public void down() {
		board.transform(Matrix.translation(0, -.05));	
		
	}
	public void up() {
		board.transform(Matrix.translation(0, .05));	
		
	}
}
