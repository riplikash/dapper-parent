package com.dapper.engine.default_implementations;

import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

@Component
public class DefaultKeyListener implements KeyListener {
	@Autowired
	DefaultControlQueue controlQueue;
	DefaultKeyListener() {
		System.out.println("Constructing TestKeyListener");
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		

		controlQueue.add(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {

		
	}

}
