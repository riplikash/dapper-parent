package com.dapper.engine.data.interfaces;

import java.util.Queue;

import javax.media.opengl.GLAutoDrawable;

import com.jogamp.newt.event.InputEvent;

public interface DapperControlInterface {
	public void init();

	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height);
	public void addCommand(InputEvent event);
	public Queue<InputEvent> getCommands();
	
	public void hitCheck(int x, int y);
}
