package com.dapper.engine.default_implementations;

import java.util.LinkedList;
import java.util.Queue;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dapper.engine.DapperEngine;
import com.dapper.engine.data.interfaces.DapperControlInterface;
import com.dapper.engine.data.interfaces.DapperGraphicsEngineInterface;
import com.jogamp.newt.event.InputEvent;

@Component
public class DefaultControlInterface implements DapperControlInterface {
	private static final Logger log = LoggerFactory.getLogger(DapperEngine.class);
	public volatile Queue<InputEvent> commandQueue;
	@Autowired
	DapperGraphicsEngineInterface canvas;
	
	public DefaultControlInterface() {
		super();
		commandQueue = new LinkedList<InputEvent>();
		log.info("Constructing control interface");
	}
	
	@Override
	public void init() {
		log.info("Initializing Control interface");
		
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {
		log.info("Reshaping control interface");
		
	}

	@Override
	public void addCommand(InputEvent event) {		
		commandQueue.add(event);	
	}

	@Override
	public Queue<InputEvent> getCommands() {
		return commandQueue;
	}

	@Override
	public void hitCheck(int x, int y) {
		GL gl = canvas.getGlWindow().getGL();
		
		
	}
	
	


	

}
