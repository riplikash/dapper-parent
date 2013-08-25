package org.sandbox.dapper.picking;

import javax.media.opengl.GLAutoDrawable;

import org.springframework.beans.factory.annotation.Autowired;

import com.dapper.engine.data.math.SimpleColor;
import com.dapper.engine.data.objects.SceneRoot;
import com.dapper.engine.data.objects.SimpleSquare;
import com.dapper.engine.default_implementations.DefaultGameEngine;

public class PickingEngine extends DefaultGameEngine {
	@Autowired
	SceneRoot root;
		
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		root.addChild(new SimpleSquare(0,0,1,1,45, SimpleColor.blue));
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}

}
