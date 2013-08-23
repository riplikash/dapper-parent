package com.dapper.a_star.objects;

import javax.media.opengl.GL2;

import com.dapper.engine.data.math.Matrix;
import com.dapper.engine.data.math.SimpleColor;
import com.dapper.engine.data.objects.DapperObject;
import com.dapper.engine.data.objects.SimpleSquare;

public class GridBoard extends DapperObject {
	SearchGrid grid;
	public GridBoard(double x, double y, double scaleX, double scaleY, double rotation, SimpleColor c) {
		super(x, y, scaleX, scaleY, rotation);
		addChild(new SimpleSquare(0, 0, 2, 2, 0, c));
		grid = new SearchGrid();
	} 
	@Override
	public void render(GL2 gl, double[][] pos) {
		double[][] finalTransformation = getTransformedPosition(pos);
		for (DapperObject d : children)
			d.render(gl, finalTransformation);
		grid.render(gl, finalTransformation);		
		
	}
	public void setGrid(SearchGrid grid) {
		this.grid = grid;		
	}
	public SearchGrid getGrid() {
		return grid;
	}

}
