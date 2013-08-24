package com.dapper.engine;

import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dapper.engine.data.interfaces.DapperControlInterface;
import com.dapper.engine.data.interfaces.DapperGameEngineInterface;
import com.dapper.engine.data.interfaces.DapperGraphicsEngineInterface;
@Component
public class DapperEngine implements GLEventListener {
	private static final Logger log = LoggerFactory.getLogger(DapperEngine.class);

	@Autowired
	DapperControlInterface controls;
	@Autowired
	DapperGraphicsEngineInterface graphicsEngine;
	@Autowired
	DapperGameEngineInterface gameEngine;

	DapperEngine() {
		
	}
	
	public void start() {
		log.info("Starting dapper engine");
		
		gameEngine.start();
		graphicsEngine.start();		
	
	}
	
	@Override
	public void init(GLAutoDrawable drawable) {
		gameEngine.init();
		graphicsEngine.init(drawable);
		controls.init();
		log.info("Initializing dapper engine");
					
	}
	@Override
	public void dispose(GLAutoDrawable drawable) {
		log.info("Disposing of dapper engine");
		
	}
	@Override
	public void display(GLAutoDrawable drawable) {
		
		gameEngine.update();
		graphicsEngine.render(drawable);
		
	}
	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {
		log.info("Reshaping dapper engine");
		graphicsEngine.reshape(drawable, x, y, width, height);
		gameEngine.reshape(drawable, x, y, width, height);
		controls.reshape(drawable, x, y, width, height);
	}
	

}
