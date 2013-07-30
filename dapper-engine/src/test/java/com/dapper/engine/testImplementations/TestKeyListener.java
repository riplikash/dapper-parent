package com.dapper.engine.testImplementations;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

public class TestKeyListener implements KeyListener {

	TestKeyListener() {
		System.out.println("Constructing TestKeyListener");
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		System.out.println(e.getKeyChar() + " Key Pressed");
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println(e.getKeyChar() + " Key Released");
		
	}

}
