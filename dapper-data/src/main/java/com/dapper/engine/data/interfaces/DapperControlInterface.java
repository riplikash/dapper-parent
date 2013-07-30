package com.dapper.engine.data.interfaces;

import javax.media.opengl.GLAutoDrawable;

import com.jogamp.newt.event.KeyListener;

public interface DapperControlInterface {
	public void init();

	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height);

}
