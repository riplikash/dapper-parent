package com.dapper.engine.testImplementations;

import java.util.Queue;

import javax.media.opengl.GLAutoDrawable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dapper.engine.data.interfaces.DapperGameEngineInterface;
import com.dapper.engine.data.math.Point2D;
import com.dapper.engine.data.math.SimpleColor;
import com.dapper.engine.data.objects.DapperObject;
import com.dapper.engine.data.objects.SimpleSquare;
import com.dapper.engine.default_implementations.DefaultControlInterface;
import com.dapper.engine.default_implementations.DefaultScene;
import com.dapper.engine.default_implementations.DefaultGameEngine.EventType;
import com.jogamp.newt.event.InputEvent;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.MouseEvent;

import static com.jogamp.newt.event.KeyEvent.*;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_CLICKED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_DRAGGED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_ENTERED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_EXITED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_PRESSED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_RELEASED;
import static com.jogamp.newt.event.MouseEvent.EVENT_MOUSE_WHEEL_MOVED;
@Component
public class GameEngineInterfaceTest implements DapperGameEngineInterface {
	@Autowired 
	DefaultControlInterface controlInterface;
	
	@Autowired
	DefaultScene scene;

	public GameEngineInterfaceTest() {

		System.out.println("Constructing game engine");
	
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
				System.out.println("Window Event");
			case MONITOR:
				System.out.println("Monitor Event");

			default:
				break;
			}

		}
	}
	


	protected void mouseEvent(MouseEvent e) {
		switch (e.getEventType())
	      {
			
	          case EVENT_MOUSE_CLICKED:
	          	System.out.println("Mouse click: (" + e.getX() + ", " + e.getY() + ")");                	
	              break;
	          case EVENT_MOUSE_RELEASED:
	          	System.out.println("Mosue Release");
	              break;
	          case EVENT_MOUSE_DRAGGED:
	          	System.out.println("Mouse Dragged");
	             
	              break;
	          case EVENT_MOUSE_ENTERED:
	             System.out.println("Mouse Entered");
	              break;
	          case EVENT_MOUSE_EXITED:
	        	  System.out.println("Mouse Exited");
	              break;
	          case EVENT_MOUSE_PRESSED:
	        	  System.out.println("Mouse Pressed: (" + e.getX() + ", " + e.getY() + ")");
	              break;
	          case EVENT_MOUSE_WHEEL_MOVED:
	        	  System.out.println("Mouse Wheel");

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
          case VK_ESCAPE:
        	  System.out.println("Escape");
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
	

	DapperObject player;

	@Override
	public void init() {
		System.out.println("initializing game engine");
		player = new DapperObject();
		player.id = 0;
		Point2D Translation = new Point2D(1,1);
		player.shape = new SimpleSquare(new Point2D(0,0), new Point2D(.5,.5), SimpleColor.BLUE);
		scene.add(player);
	}

	@Override
	public void dispose() {
		System.out.println("disposing of game engine");
		
	}

	@Override
	public void start() {
		System.out.println("Starting game engine");
		
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {
		System.out.println("reshaping game engine");
		
	}

}
