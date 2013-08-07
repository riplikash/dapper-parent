package com.dapper.engine.data.objects;

import javax.media.opengl.GL2;

import org.springframework.stereotype.Component;

import com.dapper.engine.data.math.SimpleColor;

@Component
public class SceneRoot extends NewDapperObject {

	public SceneRoot()
	{
		super();
	}
	public SceneRoot(double x, double y, double scaleX, double scaleY,
			double rotation) {
		super(x, y, scaleX, scaleY, rotation);
	}

	@Override
	public void render(GL2 gl, double[][] pos) {
		for (NewDapperObject c: children)
		{
			c.render(gl, pos);
		}
		
	}

}
