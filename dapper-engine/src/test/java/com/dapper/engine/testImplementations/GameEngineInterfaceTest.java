package com.dapper.engine.testImplementations;

import java.util.Queue;

import javax.media.opengl.GLAutoDrawable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dapper.engine.data.default_implementations.DefaultScene;
import com.dapper.engine.data.interfaces.DapperGameEngineInterface;
import com.dapper.engine.data.math.Point2D;
import com.dapper.engine.data.math.SimpleColor;
import com.dapper.engine.data.objects.DapperObject;
import com.dapper.engine.data.objects.SimpleSquare;
import com.jogamp.newt.event.KeyEvent;

import static com.jogamp.newt.event.KeyEvent.*;
@Component
public class GameEngineInterfaceTest implements DapperGameEngineInterface {
	@Autowired 
	ControlInterfaceTest controlInterface;
	
	@Autowired
	DefaultScene scene;

	GameEngineInterfaceTest() {

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
                	System.out.println("Moving up");
                	player.move(0,1);
                    break;
                case VK_DOWN:
                	player.move(0,-1);
                    break;
                case VK_LEFT:
                	player.move(-1,0);
                   
                    break;
                case VK_RIGHT:
                   player.move(1,0);
                    break;
                case VK_ESCAPE:

                    break;


            }
		}
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
