package com.dapper.engine.default_implementations;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dapper.engine.DapperEngine;
import com.dapper.engine.data.interfaces.DapperGraphicsEngineInterface;
import com.dapper.engine.data.objects.SceneRoot;
import com.jogamp.newt.event.KeyListener;
import com.jogamp.newt.event.MouseListener;
import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.texture.Texture;

public class DefaultGraphicsEngine implements DapperGraphicsEngineInterface{
	private static final Logger log = LoggerFactory.getLogger(DefaultGraphicsEngine.class);
	@Autowired
	public 
	GLEventListener dapperEngine;
	@Autowired
	public 
	KeyListener keyListener;
	@Autowired
	public MouseListener mouseListener;
	@Autowired
	SceneRoot root;

	
	protected GL2 gl;
	
	protected int FPS;
	protected int windowWidth;
	protected int windowHeight;
	protected String windowTitle;
	
	protected GLWindow glWindow;
    protected FPSAnimator fpsAnimator;
	
     
    public DefaultGraphicsEngine() {    	 
 		super();
 		log.info("constructing graphics engine");
 		
 	}
	@Override
	public void init() {
		log.info("Initializing graphics engine");

	}
	
	Texture fontTexture;

	@Override
	public void start() {
		log.info("Starting graphics engine");
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
        glWindow.addMouseListener(mouseListener);
        glWindow.setTitle(windowTitle);
        glWindow.setSize(windowWidth, windowHeight);

		glWindow.setVisible(true);
		
	
		fpsAnimator.start();
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {
			log.info("reshaping graphics engine");
		
	}
	@Override
	public void render(GLAutoDrawable drawable) {
		
		gl = drawable.getGL().getGL2();
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		root.render(gl);

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
	@Override
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
