package com.dapper.engine;

import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dapper.engine.data.interfaces.DapperControlInterface;
import com.dapper.engine.data.interfaces.DapperGameEngineInterface;
import com.dapper.engine.data.interfaces.DapperGraphicsEngineInterface;
import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.util.FPSAnimator;
@Component
public class DapperEngine implements GLEventListener {
	@Autowired
	DapperControlInterface controls;
	@Autowired
	DapperGraphicsEngineInterface graphicsEngine;
	@Autowired
	DapperGameEngineInterface gameEngine;

	DapperEngine() {
		System.out.println("Constructing dapper engine");

	}
	
	public void start() {
		System.out.println("Starting dapper engine");
		gameEngine.start();
		graphicsEngine.start();		
	
	}
	
	@Override
	public void init(GLAutoDrawable drawable) {
		System.out.println("Initializing dapper engine");
					
	}
	@Override
	public void dispose(GLAutoDrawable drawable) {
		System.out.println("Disposing of dapper engine");
		
	}
	@Override
	public void display(GLAutoDrawable drawable) {
		
		gameEngine.update();
		graphicsEngine.render(drawable);
		
	}
	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {
		System.out.println("Reshaping dapper engine");
		graphicsEngine.reshape(drawable, x, y, width, height);
		gameEngine.reshape(drawable, x, y, width, height);
		controls.reshape(drawable, x, y, width, height);
	}
	

}
