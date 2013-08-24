package com.dapper.engine.data.interfaces;

import javax.media.opengl.GLAutoDrawable;

import com.dapper.engine.data.DapperEngineSettings;
import com.jogamp.newt.opengl.GLWindow;

public interface DapperGraphicsEngineInterface {	

	public void init(GLAutoDrawable drawable);

	public void start();
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height);
	public void render(GLAutoDrawable drawable);

	public GLWindow getGlWindow();

}
