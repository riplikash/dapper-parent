package com.dapper.engine.testImplementations;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

import org.springframework.beans.factory.annotation.Autowired;

import com.dapper.engine.data.objects.DapperObject;
import com.dapper.engine.data.objects.DapperSceneGraph;
import com.dapper.engine.default_implementations.DefaultGraphicsEngine;

public class SceneGraphGraphicsEngine extends DefaultGraphicsEngine {

	@Autowired
	public DapperSceneGraph sceneGraph;

	@Override
	public void render(GLAutoDrawable drawable) {
		
		gl = drawable.getGL().getGL2();
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		sceneGraph.render(gl);
		
		
	}


}
