package com.sandbox.opengl4prototype;

import static com.jogamp.newt.event.KeyEvent.*;

import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_CLICKED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_DRAGGED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_ENTERED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_EXITED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_PRESSED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_RELEASED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_WHEEL_MOVED;

import javax.media.opengl.GLAutoDrawable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dapper.engine.data.interfaces.DapperGameEngineInterface;
import com.dapper.engine.data.math.SimpleColor;
import com.dapper.engine.data.objects.SceneRoot;
import com.dapper.engine.data.objects.SimpleSquare;
import com.dapper.engine.default_implementations.DefaultControlInterface;
import com.jogamp.newt.event.InputEvent;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.MouseEvent;

public class ModGameEngine implements DapperGameEngineInterface {
	private static final Logger log = LoggerFactory.getLogger(ModGameEngine.class);
	@Autowired 
	DefaultControlInterface controlInterface;
	@Autowired
	SceneRoot scene;


	public ModGameEngine() {
		
	}
	
	@Override
	public void update() {
		
	}
	


	protected void mouseEvent(MouseEvent e) {
		switch (e.getEventType())
	      {
			
	          case EVENT_MOUSE_CLICKED:
	          	log.debug("Mouse click: (" + e.getX() + ", " + e.getY() + ")");                	
	              break;
	          case EVENT_MOUSE_RELEASED:
	          	
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

	private void keyboardEvent(KeyEvent e) {
		switch (e.getKeyCode())
        {
	
          case VK_UP:
        	 
        	  break;
        	  
        }
		
	}



	private enum EventType { MOUSE, KEY, WINDOW, MONITOR, INVALID }

	private EventType eventType(InputEvent e) {
		short typeCode = e.getEventType();
		
		if (typeCode >= 600)
			return EventType.WINDOW;
		else if (typeCode >= 300)
			return EventType.KEY;
		else if (typeCode >= 200)
			return EventType.MOUSE;
		else if (typeCode >= 100)
			return EventType.WINDOW;
		return EventType.INVALID;
	}
	

	@Override
	public void init() {
		
	}

	@Override
	public void dispose() {
		
		
	}

	@Override
	public void start() {
		
		
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {
		
		
	}

}
