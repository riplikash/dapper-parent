package com.dapper.engine.data.objects;

import javax.media.opengl.GL2;

import com.dapper.engine.data.math.SimpleColor;

public class SceneRoot extends NewDapperObject {

	public SceneRoot()
	{
		super();
	}
	public SceneRoot(double x, double y, double scaleX, double scaleY,
			double rotation, SimpleColor color) {
		super(x, y, scaleX, scaleY, rotation, color);
	}

	@Override
	public void render(GL2 gl, double[][] pos) {
		for (NewDapperObject c: children)
		{
			c.render(gl, pos);
		}
		
	}

}
