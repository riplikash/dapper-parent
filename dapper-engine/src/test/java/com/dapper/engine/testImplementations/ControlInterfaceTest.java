package com.dapper.engine.testImplementations;

import javax.media.opengl.GLAutoDrawable;

import org.springframework.beans.factory.annotation.Autowired;

import com.dapper.engine.data.interfaces.DapperControlInterface;
import com.dapper.engine.default_implementations.DefaultControlQueue;

public class ControlInterfaceTest implements DapperControlInterface {
	@Autowired
	TestKeyListener keyListener;

	
	public TestKeyListener getKeyListener() {
		return keyListener;
	}
	
	public void setKeyListener(TestKeyListener keyListener) {
		this.keyListener = keyListener;
	}

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
