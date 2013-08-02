package com.dapper.engine.default_implementations;

import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dapper.engine.data.interfaces.DapperControlInterface;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

@Component
public class DefaultKeyListener implements KeyListener {
	@Autowired
	DapperControlInterface controlInterface;
	public DefaultKeyListener() {
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		controlInterface.addCommand(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {

		
	}
	
	

}
