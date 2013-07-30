package com.dapper.engine.testImplementations;

import javax.media.opengl.GLAutoDrawable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dapper.engine.data.interfaces.DapperControlInterface;
import com.dapper.engine.default_implementations.DefaultKeyListener;

@Component
public class ControlInterfaceTest implements DapperControlInterface {
	@Autowired
	DefaultKeyListener keyListener;

	ControlInterfaceTest() {
		super();
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


	

}
