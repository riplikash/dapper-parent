package org.sandbox.psychadelic;

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
import com.dapper.engine.default_implementations.DefaultControlInterface;
import com.jogamp.newt.event.InputEvent;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.MouseEvent;

@Component
public class PsychadelicEngine implements DapperGameEngineInterface {
	private static final Logger log = LoggerFactory.getLogger(PsychadelicEngine.class);
	@Autowired 
	DefaultControlInterface controlInterface;
	@Autowired
	SceneRoot scene;
	long count;
	long wait;
	boolean pause = false;
	NestedHud hud;

	public PsychadelicEngine() {
		count = System.currentTimeMillis();
		wait = 1;
	}
	
	@Override
	public void update() {
		
		long newCount = System.currentTimeMillis();
		if (newCount-count >= wait)
		{
			count = newCount;
			if (!pause)
			{
				e.inc();
//				a.inc();
//				b.inc();
//				c.inc();
//				d.inc();
			}
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
        	  
//        	  player.move(0,.1);        	  
        	  NestedBox.ty += .001;
        	  hud.updateTy(NestedBox.ty);
              break;
          case VK_DOWN:
//        	  player.move(0,-.1);
        	  NestedBox.ty -= .001;
        	  hud.updateTy(NestedBox.ty);
              break;
          case VK_LEFT:
        	  NestedBox.tx -= .001;
        	  hud.updateTx(NestedBox.tx);
              break;
          case VK_RIGHT:
        	  NestedBox.tx += .001;
        	  hud.updateTx(NestedBox.tx);
              break;
          case VK_Q:
//        	  player.rotate((double)-5);
        	  NestedBox.rot += -.5;
        	  hud.updateRot1(NestedBox.rot);
        	  break;
          case VK_E:
//        	  player.rotate((double)5);
        	  NestedBox.rot += .5;
        	  hud.updateRot1(NestedBox.rot);
        	  break;
          case VK_W:
//        	  player.skew(0.0,5);
        	  NestedBox.sy += .005;
        	  hud.updateSy(NestedBox.sy);
        	  break;
          case VK_A:
//        	  player.skew(-5, 0.0);
        	  NestedBox.sx -= .005;
        	  hud.updateSx(NestedBox.sx);
        	  break;
          case VK_F:
//        	  player.skew(-5, 0.0);
        	  NestedBox.sx -= .005;
        	  NestedBox.sy -= .005;
        	  hud.updateSx(NestedBox.sx);
        	  hud.updateSy(NestedBox.sy);
        	  break;
          case VK_G:
        	  NestedBox.sx += .005;
        	  NestedBox.sy += .005;
        	  hud.updateSx(NestedBox.sx);
        	  hud.updateSy(NestedBox.sy);
        	  break;
          case VK_S:
//        	  player.skew(0.0, -5);
        	  NestedBox.sy -= .005;
        	  hud.updateSy(NestedBox.sy);
        	  break;
          case VK_D:
//        	  player.skew(5,0.0);
        	  NestedBox.sx += .005;
        	  hud.updateSx(NestedBox.sx);
        	  break;
          case VK_Z:
//        	  player.skew(5,0.0);
        	  NestedBoxTest.rot += 1;
        	  
        	  hud.updateRot2(NestedBoxTest.rot);
        	  break; 
    	  case VK_X:
//            	  player.skew(5,0.0);
    		  NestedBoxTest.rot -= 1;
        	  hud.updateRot2(NestedBoxTest.rot);
        	  break;
    	  case VK_PLUS:
    	  case VK_EQUALS:
    		  System.out.println("plus");
    		  wait -= 10; 
    		  break;
    	  case VK_MINUS:
    	  case VK_UNDERSCORE:
    		  wait += 10;
    		  System.out.println("minus");
    		  break;
    		  
          case VK_ESCAPE:
        	  pause = !pause;
              break;	
          case VK_SPACE:
        	  NestedBox.reset();
        	  NestedBoxTest.rot = 0;
        	  hud.update(NestedBox.tx, NestedBox.ty, NestedBox.sx, NestedBox.sy, NestedBox.rot, NestedBoxTest.rot);
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
//		a = new NestedBoxTest(-.5, -.5, .75, .75, 0);
//		b = new NestedBoxTest(.5, -.5, .75, .75, 0);
//		c = new NestedBoxTest(-.5, .5, .75, .75, 0);
//		d = new NestedBoxTest(.5, .5, .75, .75, 0);
		NestedBox.color1 = new SimpleColor(.75,.5,.85);
		NestedBox.color2 = new SimpleColor(.4,0,0);
		NestedBox.color3 = new SimpleColor(0,0,1);
		e = new NestedBoxTest(0,0, 3, 3, 0);
		scene.addChild(e);
		hud = new NestedHud(NestedBox.tx, NestedBox.ty, NestedBox.sx, NestedBox.sy, NestedBox.rot);
		scene.addChild(hud);
//		scene.addChild(a);
//		scene.addChild(b);
//		scene.addChild(c);
//		scene.addChild(d);
//		
		
	}
//	NestedBoxTest a;
//	NestedBoxTest b;
//	NestedBoxTest c;
//	NestedBoxTest d;
	NestedBoxTest e;
	

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
