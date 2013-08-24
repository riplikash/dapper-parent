package com.dapper.a_star.objects;

import com.dapper.engine.data.math.SimpleColor;
import com.dapper.engine.data.objects.DapperObject;
import com.dapper.engine.data.objects.SimpleSquare;

public class GridBoard extends DapperObject {
	SearchGrid grid;
	public GridBoard(double x, double y, double scaleX, double scaleY, double rotation, SimpleColor c) {
		super(x, y, scaleX, scaleY, rotation);
		
		addChild(new SimpleSquare(0, 0, 1, 1, 0, c));
		grid = new SearchGrid();
		addChild(grid);
		
	} 

	public void setGrid(SearchGrid grid) {
		this.grid = grid;		
	}
	public SearchGrid getGrid() {
		return grid;
	}

}
