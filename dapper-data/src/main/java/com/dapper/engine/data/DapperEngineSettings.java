package com.dapper.engine.data;

import javax.media.opengl.GLEventListener;

import com.jogamp.newt.event.KeyListener;

public class DapperEngineSettings {
	public String windowTitle;    
	public int windowWidth;
    public int windowHeight;
    public int FPS;
    public GLEventListener eventListener;
    public KeyListener keyListener;
    DapperEngineSettings() {
    	System.out.println("Initializing Settings");
    }
    /*DapperEngineSettings() {
        windowTitle = "Dapper Engine Window";
	    windowWidth = 600;
	    windowHeight = 600;
	    FPS = 60;

	}*/
    public String getWindowTitle() {
		return windowTitle;
	}
	public void setWindowTitle(String windowTitle) {
		this.windowTitle = windowTitle;
	}
	public int getWindowWidth() {
		return windowWidth;
	}
	public void setWindowWidth(int windowWidth) {
		this.windowWidth = windowWidth;
	}
	public int getWindowHeight() {
		return windowHeight;
	}
	public void setWindowHeight(int windowHeight) {
		this.windowHeight = windowHeight;
	}
	public int getFPS() {
		return FPS;
	}
	public void setFPS(int fPS) {
		FPS = fPS;
	}
	public GLEventListener getEventListener() {
		return eventListener;
	}
	public void setEventListener(GLEventListener eventListener) {
		this.eventListener = eventListener;
	}
	public KeyListener getKeyListener() {
		return keyListener;
	}
	public void setKeyListener(KeyListener keyListener) {
		this.keyListener = keyListener;
	}
	
}
