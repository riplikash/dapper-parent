package com.dapper.engine.default_implementations;

import static com.jogamp.newt.event.KeyEvent.VK_DOWN;
import static com.jogamp.newt.event.KeyEvent.VK_ESCAPE;
import static com.jogamp.newt.event.KeyEvent.VK_LEFT;
import static com.jogamp.newt.event.KeyEvent.VK_RIGHT;
import static com.jogamp.newt.event.KeyEvent.VK_UP;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_CLICKED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_DRAGGED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_ENTERED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_EXITED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_PRESSED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_RELEASED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_WHEEL_MOVED;

import java.util.Queue;

import javax.media.opengl.GLAutoDrawable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dapper.engine.DapperEngine;
import com.dapper.engine.data.interfaces.DapperGameEngineInterface;
import com.dapper.engine.data.objects.SceneRoot;
import com.jogamp.newt.event.InputEvent;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.MouseEvent;
@Component
public class DefaultGameEngine implements DapperGameEngineInterface {
	private static final Logger log = LoggerFactory.getLogger(DefaultGameEngine.class);
	@Autowired 
	public DefaultControlInterface controlInterface;
	@Autowired
	protected SceneRoot scene;

	protected int width;
	protected int height;
	public DefaultGameEngine() {

	}
	
	@Override
	public void update() {
		Queue<InputEvent> queue = controlInterface.getCommands();
		while (queue.size() > 0)
		{
			InputEvent e = queue.remove();
			
			switch (eventType(e)) {
			case KEY:
				keyboardEvent((KeyEvent)e);
				break;
			case MOUSE:
				mouseEvent((MouseEvent)e);
				break;
			case WINDOW: 
				log.info("Window Event");
			case MONITOR:
				log.info("Monitor Event");

			default:
				break;
			}

		}
	}
	


	protected void mouseEvent(MouseEvent e) {
		switch (e.getEventType())
	      {
			
	          case EVENT_MOUSE_CLICKED:
	        	  log.info("Mouse click: (" + e.getX() + ", " + e.getY() + ")");                	
	              break;
	          case EVENT_MOUSE_RELEASED:
	          		log.info("Mosue Release");
	              break;
	          case EVENT_MOUSE_DRAGGED:
	        	  log.info("Mouse Dragged");
	             
	              break;
	          case EVENT_MOUSE_ENTERED:
	             log.info("Mouse Entered");
	              break;
	          case EVENT_MOUSE_EXITED:
	        	  log.info("Mouse Exited");
	              break;
	          case EVENT_MOUSE_PRESSED:
	        	  log.info("Mouse Pressed: (" + e.getX() + ", " + e.getY() + ")");
	              break;
	          case EVENT_MOUSE_WHEEL_MOVED:
	        	  log.info("Mouse Wheel");

	              break;	          

	      }
		
	}

	protected void keyboardEvent(KeyEvent e) {
		switch (e.getKeyCode())
      {
		
          case VK_UP:
          	log.info("up");                	
              break;
          case VK_DOWN:
          	log.info("down");
              break;
          case VK_LEFT:
          	log.info("left");
             
              break;
          case VK_RIGHT:
             log.info("right");
              break;
          case VK_ESCAPE:
        	  log.info("Escape");
              break;


      }
		
	}



	public enum EventType { MOUSE, KEY, WINDOW, MONITOR, INVALID }

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
		log.info("Initializing Default Game Engine");
	}

	@Override
	public void dispose() {
		log.info("Disposing of DefaultGameEngine");
	}

	@Override
	public void start() {
		log.info("Starting DefaultGameEngine");
		
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) { 
		this.width = width; 
		this.height = height;
	}

}
