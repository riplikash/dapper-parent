package com.dapper.a_star.interfaces;

import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_CLICKED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_DRAGGED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_ENTERED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_EXITED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_PRESSED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_RELEASED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_WHEEL_MOVED;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dapper.a_star.objects.AStarModule;
import com.dapper.engine.data.math.Matrix;
import com.dapper.engine.default_implementations.DefaultGameEngine;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.MouseEvent;

public class GameEngine extends DefaultGameEngine {
	private static final Logger log = LoggerFactory.getLogger(GameEngine.class);
	int gridSizeX = 10;
	int gridSizeY = 10;

	AStarModule main;
	public GameEngine() {
		super();		
	}

	@Override
	public void init() {
		main = new AStarModule();
		scene.addChild(main);
	}
	
	@Override
	protected void keyboardEvent(KeyEvent e) {
		switch (e.getKeyCode())
      {
		
          case KeyEvent.VK_UP:
        	  main.up();         	
              break;
          case KeyEvent.VK_DOWN:
          	  main.down();
              break;
          case KeyEvent.VK_LEFT:
        	  main.left();    
              break;
          case KeyEvent.VK_RIGHT:
        	  main.right();        	  
              break;
          case KeyEvent.VK_Q:
        	  main.rotLeft();
        	  break;
          case KeyEvent.VK_E:
        	  main.rotRight();
          case KeyEvent.VK_ESCAPE:
        	 
              break;


      }
		
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
		main.click(xGrid, yGrid);
	}
	
}
