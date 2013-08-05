package com.dapper.a_star.interfaces;

import com.dapper.engine.data.math.SimpleColor;
import com.dapper.engine.data.objects.DapperObject;
import com.dapper.engine.data.objects.SimpleSquare;

public class GridSquare extends DapperObject {
	public int weight;
	public boolean processed;
	
	
	public GridSquare(int weight, SimpleSquare square, int id) {
		super(square, id);
		square.color = SimpleColor.red;		
		this.weight = weight;
		shape = square;
		processed = false;
	}
	public GridSquare(int weight) {
		shape.color = SimpleColor.red;
		this.weight = weight;
		processed = false;
	}
	public GridSquare() {
		shape.color = SimpleColor.red;
		this.weight = 1;
		processed = false;
	}
	
	public void changeColor(SimpleColor c)
	{
		shape.color = c;
		
	}
	public SimpleColor getColor() {
		return shape.color;
	}
	public void toggle() {
		if (processed)
		{
			shape.color = SimpleColor.blue;
			processed = false;
		} else {
			shape.color = SimpleColor.green;
			processed = true;
		}
		
	}
	
	

}