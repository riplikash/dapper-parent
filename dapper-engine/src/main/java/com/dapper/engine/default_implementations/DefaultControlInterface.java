package com.dapper.engine.default_implementations;

import static com.jogamp.newt.event.KeyEvent.VK_A;
import static com.jogamp.newt.event.KeyEvent.VK_D;
import static com.jogamp.newt.event.KeyEvent.VK_DOWN;
import static com.jogamp.newt.event.KeyEvent.VK_ESCAPE;
import static com.jogamp.newt.event.KeyEvent.VK_J;
import static com.jogamp.newt.event.KeyEvent.VK_K;
import static com.jogamp.newt.event.KeyEvent.VK_LEFT;
import static com.jogamp.newt.event.KeyEvent.VK_RIGHT;
import static com.jogamp.newt.event.KeyEvent.VK_S;
import static com.jogamp.newt.event.KeyEvent.VK_SPACE;
import static com.jogamp.newt.event.KeyEvent.VK_UP;
import static com.jogamp.newt.event.KeyEvent.VK_W;

import java.util.LinkedList;
import java.util.Queue;

import javax.media.opengl.GLAutoDrawable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dapper.engine.data.interfaces.DapperControlInterface;

@Component
public class DefaultControlInterface implements DapperControlInterface {
	volatile Queue<Short> commandQueue;
	
	DefaultControlInterface() {
		super();
		commandQueue = new LinkedList<Short>();
		System.out.println("Constructing control interface");
	}
	
	@Override
	public void init() {
		System.out.println("Initializing Control interface");
		
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {
		System.out.println("Reshaping control interface");
		
	}

	@Override
	public void addCommand(Short cmd) {		
		commandQueue.add(cmd);		
	}

	@Override
	public Queue<Short> getCommands() {
		return commandQueue;
	}
	
	


	

}
