package com.dapper.engine.testImplementations;

import java.util.Iterator;
import java.util.Queue;

import javax.media.opengl.GLAutoDrawable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dapper.engine.data.interfaces.DapperGameEngineInterface;
import com.dapper.engine.default_implementations.DefaultControlQueue;
@Component
public class GameEngineInterfaceTest implements DapperGameEngineInterface {
	@Autowired 
	DefaultControlQueue controlQueue;
	GameEngineInterfaceTest() {

		System.out.println("Constructing game engine");
		size = 0;
	}
	int size;
	@Override
	public void update() {
		if (size != controlQueue.size())
		{			
			size = controlQueue.size();
			Iterator itr = controlQueue.iterator();
			System.out.print("{");
			while (itr.hasNext()) {
				System.out.print(itr.next());
				itr.remove();
				if (itr.hasNext()) System.out.print(", ");
			}
			System.out.print("}\n");
		}
		
	}

	@Override
	public void init() {
		System.out.println("initializing game engine");
		
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
