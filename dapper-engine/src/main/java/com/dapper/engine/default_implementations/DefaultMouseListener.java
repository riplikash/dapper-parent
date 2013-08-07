package com.dapper.engine.default_implementations;

import java.awt.Point;
import java.util.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dapper.engine.DapperEngine;
import com.dapper.engine.data.interfaces.DapperControlInterface;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import com.jogamp.newt.event.MouseEvent;
import com.jogamp.newt.event.MouseListener;

@Component
public class DefaultMouseListener implements MouseListener {
	private static final Logger log = LoggerFactory.getLogger(MouseListener.class);
	private static Point center;
	@Autowired
	DapperControlInterface controlInterface;
	public DefaultMouseListener() {
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		
		controlInterface.addCommand(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		controlInterface.addCommand(e);
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		controlInterface.addCommand(e);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		controlInterface.addCommand(e);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		controlInterface.addCommand(e);
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {

		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		controlInterface.addCommand(e);
		
	}

	@Override
	public void mouseWheelMoved(MouseEvent e) {
		controlInterface.addCommand(e);
		
	}
	
	

}
