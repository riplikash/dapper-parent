package com.dapper.engine.default_implementations;

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
import com.jogamp.newt.event.KeyEvent;

import static com.jogamp.newt.event.KeyEvent.*;
@Component
public class DefaultGameEngine implements DapperGameEngineInterface {
	@Autowired 
	DefaultControlInterface controlInterface;
	
	@Autowired
	DefaultScene scene;

	DefaultGameEngine() {

		System.out.println("Constructing game engine");
	
	}
	
	@Override
	public void update() {
		Queue<Short> queue = controlInterface.getCommands();
		while (queue.size() > 0)
		{
			switch (queue.remove())
            {
                case KeyEvent.VK_UP:
                	System.out.println("up");                	
                    break;
                case VK_DOWN:
                	System.out.println("down");
                    break;
                case VK_LEFT:
                	System.out.println("left");
                   
                    break;
                case VK_RIGHT:
                   System.out.println("right");
                    break;
                case VK_ESCAPE:

                    break;


            }
		}
	}
	


	

	@Override
	public void init() {
		System.out.println("initializing game engine");
		DapperObject player = new DapperObject();
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
