package com.dapper.a_star.interfaces;

import javax.media.opengl.GL2;

import com.dapper.engine.data.math.Matrix;
import com.dapper.engine.data.math.SimpleColor;
import com.dapper.engine.data.objects.DapperSquare;
import com.dapper.engine.data.objects.NewDapperObject;
import com.dapper.engine.data.objects.NewSimpleFont;

public class GridSquare extends NewDapperObject {
	public int weight;
	public boolean processed;
	DapperSquare square;
	NewSimpleFont countFace;
	
	public GridSquare(int weight, double x, double y, double scaleX, double scaleY) {
		super(x, y, scaleX, scaleY, 0);
		this.weight = weight;
		processed = false;
		String temp = new Integer(weight).toString();
		square = new DapperSquare(0,0,1,1,0,SimpleColor.green);
		countFace = new NewSimpleFont(temp, 0, 0, .5, .5, 0, SimpleColor.white);
		
	}
	
	public void changeColor(SimpleColor c)
	{
		square.setColor(c);
		
	}

	public void toggle() {
		weight++;
		String temp = new Integer(weight).toString();
		
		countFace = new NewSimpleFont(temp, 0, 0, .5, .5, 0, SimpleColor.white);
		if (processed)
		{
			square.setColor(SimpleColor.blue);
			processed = false;
		} else {
			square.setColor(SimpleColor.red);
			processed = true;
		}
		
	}


	@Override
	public void render(GL2 gl, double[][] pos) {
		double[][] finalTransformation = Matrix.multiply(pos, this.pos);
		square.render(gl, finalTransformation);
		countFace.render(gl, finalTransformation);
		
	}

}
