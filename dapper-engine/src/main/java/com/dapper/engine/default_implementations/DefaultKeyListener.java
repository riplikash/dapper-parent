package com.dapper.engine.default_implementations;

import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dapper.engine.DapperEngine;
import com.dapper.engine.data.interfaces.DapperControlInterface;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;

@Component
public class DefaultKeyListener implements KeyListener {
	private static final Logger log = LoggerFactory.getLogger(DefaultKeyListener.class);
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
