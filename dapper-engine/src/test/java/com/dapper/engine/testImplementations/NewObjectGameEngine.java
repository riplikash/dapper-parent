package com.dapper.engine.testImplementations;

import static com.jogamp.newt.event.KeyEvent.*;
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

import com.dapper.engine.data.interfaces.DapperGameEngineInterface;
import com.dapper.engine.data.math.SimpleColor;
import com.dapper.engine.data.objects.SceneRoot;
import com.dapper.engine.data.objects.SimpleFont;
import com.dapper.engine.data.objects.SimpleSquare;
import com.dapper.engine.data.objects.TestControlSquare;
import com.dapper.engine.default_implementations.DefaultControlInterface;
import com.jogamp.newt.event.InputEvent;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.MouseEvent;
@Component
public class NewObjectGameEngine implements DapperGameEngineInterface {
	private static final Logger log = LoggerFactory.getLogger(NewObjectGameEngine.class);
	@Autowired 
	DefaultControlInterface controlInterface;
	@Autowired
	SceneRoot scene;
	long count;
	long wait;
	boolean pause = false;

	public NewObjectGameEngine() {
		count = System.currentTimeMillis();
		wait = 100;
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
        	  
        	  player.move(0,.1);        	  
              break;
          case VK_DOWN:
        	  player.move(0,-.1);
              break;
          case VK_LEFT:
        	  player.move(-.1,0);
              break;
          case VK_RIGHT:
        	  player.move(.1,0);
              break;
          case VK_Q:
        	  player.rotate((double)-5);
        	  break;
          case VK_E:
        	  player.rotate((double)5);
        	  break;
          case VK_W:
        	  player.skew(0.0,5);
        	  break;
          case VK_A:
        	  player.skew(-5, 0.0);
        	  break;
          case VK_S:
        	  player.skew(0.0, -5);
        	  break;
          case VK_D:
        	  player.skew(5,0.0);
        	  break;
          case VK_Z:
        	  player.skew(5,0.0);
        	  break; 
    	  case VK_X:
            	  player.skew(5,0.0);
        	  break;

    		  
          case VK_ESCAPE:

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
	
	TestControlSquare player;

	@Override
	public void init() {
		player = new TestControlSquare(-.3, .5, .1, .1, 0, SimpleColor.green);

		SimpleSquare square = new SimpleSquare(-.3, .5, .1, .1, 0, SimpleColor.BLUE);
		scene.addChild(square);
		scene.addChild(new SimpleSquare(0, 0, .5, .1, 0, SimpleColor.red));
		scene.addChild(new SimpleSquare(-1, 1, .2, .8, 0, SimpleColor.red));
		scene.addChild(player);
		scene.addChild(new SimpleFont("Hey, dude", 0,0, 10));

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
