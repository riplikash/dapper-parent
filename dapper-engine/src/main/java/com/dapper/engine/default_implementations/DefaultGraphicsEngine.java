package com.dapper.engine.default_implementations;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dapper.engine.data.DapperEngineSettings;
import com.dapper.engine.data.interfaces.DapperGraphicsEngineInterface;
import com.jogamp.newt.event.KeyListener;
import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.util.FPSAnimator;

public class DefaultGraphicsEngine implements DapperGraphicsEngineInterface{
	@Autowired
	GLEventListener dapperEngine;
	@Autowired
	KeyListener keyListener;
	
	int FPS;
	int windowWidth;
	int windowHeight;
	String windowTitle;
	
	GLWindow glWindow;
     FPSAnimator fpsAnimator;
     
    public DefaultGraphicsEngine() {    	 
 		super();
 		System.out.println("constructing graphics engine");
 		
 	}
	@Override
	public void init() {
		System.out.println("Initializing graphics engine");
		  	
	}

	@Override
	public void start() {
		System.out.println("Starting graphics engine");
		GLProfile glProfile = GLProfile.getDefault(); 
        GLCapabilities glCapabilities = new GLCapabilities(glProfile); 
        glWindow = GLWindow.create(glCapabilities);
        fpsAnimator = new FPSAnimator(glWindow, FPS, true);

        glWindow.addWindowListener(new WindowAdapter(){
            @Override
            public void windowDestroyNotify(WindowEvent e){
                new Thread(){
                    @Override
                    public void run(){
                        fpsAnimator.stop();
                        System.exit(0);
                    }
                }.start();
            };
        });

        glWindow.addGLEventListener(dapperEngine);
        glWindow.addKeyListener(keyListener);
        glWindow.setTitle(windowTitle);
        glWindow.setSize(windowWidth, windowHeight);

		glWindow.setVisible(true);
		fpsAnimator.start();
		
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {
System.out.println("reshaping");
		
	}
	@Override
	public void render(GLAutoDrawable drawable) {
		System.out.println("Rendering something");
			GL2 gl = drawable.getGL().getGL2();
		    
		    // draw a triangle filling the window
		    gl.glBegin(GL.GL_TRIANGLES);
		    gl.glColor3f(1, 0, 0);
		    gl.glVertex2f(-1, -1);
		    gl.glColor3f(0, 1, 0);
		    gl.glVertex2f(0, 1);
		    gl.glColor3f(0, 0, 1);
		    gl.glVertex2f(1, -1);
		    gl.glEnd();	
	}
	
	public int getFPS() {
		return FPS;
	}
	public void setFPS(int fPS) {
		FPS = fPS;
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
	public String getWindowTitle() {
		return windowTitle;
	}
	public void setWindowTitle(String windowTitle) {
		this.windowTitle = windowTitle;
	}
	public GLWindow getGlWindow() {
		return glWindow;
	}
	public void setGlWindow(GLWindow glWindow) {
		this.glWindow = glWindow;
	}
	public FPSAnimator getFpsAnimator() {
		return fpsAnimator;
	}
	public void setFpsAnimator(FPSAnimator fpsAnimator) {
		this.fpsAnimator = fpsAnimator;
	}

}
