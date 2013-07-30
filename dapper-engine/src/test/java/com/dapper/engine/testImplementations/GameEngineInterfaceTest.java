package com.dapper.engine.testImplementations;

import javax.media.opengl.GLAutoDrawable;

import com.dapper.engine.data.interfaces.DapperGameEngineInterface;

public class GameEngineInterfaceTest implements DapperGameEngineInterface {
	GameEngineInterfaceTest() {

		System.out.println("Constructing game engine");
	}
	@Override
	public void update() {
		
		// TODO Auto-generated method stub
		
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
