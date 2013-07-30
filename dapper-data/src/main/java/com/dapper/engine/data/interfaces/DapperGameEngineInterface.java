package com.dapper.engine.data.interfaces;

import javax.media.opengl.GLAutoDrawable;

public interface DapperGameEngineInterface {
    public void update();
    public void init();
    public void dispose();
	public void start();
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height);
}
