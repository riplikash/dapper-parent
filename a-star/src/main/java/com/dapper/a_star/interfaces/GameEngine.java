package com.dapper.a_star.interfaces;

import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_CLICKED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_DRAGGED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_ENTERED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_EXITED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_PRESSED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_RELEASED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_WHEEL_MOVED;

import org.springframework.beans.factory.annotation.Autowired;

import com.dapper.engine.default_implementations.DefaultGameEngine;
import com.jogamp.newt.event.MouseEvent;

public class GameEngine extends DefaultGameEngine {
	int gridSizeX = 10;
	int gridSizeY = 10;

	SearchGrid searchGrid;
	public GameEngine() {
		super();		
	}

	@Override
	public void init() {
		searchGrid = new SearchGrid();
		scene.addChild(searchGrid);
	}
	
	@Override
	protected void mouseEvent(MouseEvent e) {
		switch (e.getEventType())
	      {
			
	          case EVENT_MOUSE_CLICKED:
 
	              break;
	          case EVENT_MOUSE_RELEASED:
	        	  markSquare(e.getX(), e.getY());
	              break;
	          case EVENT_MOUSE_DRAGGED:
	          		             
	              break;
	          case EVENT_MOUSE_ENTERED:
	            
	              break;
	          case EVENT_MOUSE_EXITED:
	        	
	              break;
	          case EVENT_MOUSE_PRESSED:
	        	
	              break;
	          case EVENT_MOUSE_WHEEL_MOVED:
	        	

	              break;	          

	      }
		
	}

	private void markSquare(int x, int y) {
		int xGrid = (int)(((double)x/(double)width)*10);
		int yGrid = (int)(((double)y/(double)height)*10);
		searchGrid.grid[xGrid][yGrid].toggle();
	}
}
