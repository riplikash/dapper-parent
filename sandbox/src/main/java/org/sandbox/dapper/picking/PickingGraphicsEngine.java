package org.sandbox.dapper.picking;

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

public class PickingGraphicsEngine implements DapperGraphicsEngineInterface{
	private static final Logger log = LoggerFactory.getLogger(PickingGraphicsEngine.class);
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
	
     
    public PickingGraphicsEngine() {    	 
 		super();
 		log.info("constructing graphics engine");
 		
 	}
	@Override
	public void init(GLAutoDrawable drawable) {
		log.info("Initializing graphics engine");
		GL2 gl = drawable.getGL().getGL2();
		gl.glEnable(GL2.GL_CULL_FACE);
		gl.glEnable(GL2.GL_DEPTH_TEST);
		gl.glEnable(GL2.GL_NORMALIZE);

	      // Be carefull with debug, it can cause errors.
	      //drawable.setGL( new DebugGL(drawable.getGL() ));
	      //System.out.println("Init GL is " + gl.getClass().getName());

	      // On some systems the reshape call does not seem to 
//	       happen automatically on init.
	      // Set the projection and viewport.
	      reshape( drawable, 0, 0, windowWidth, windowHeight );

	      gl.glClearColor( 0f, 0f, 0f, 0.0f );
//	      gl.glClearColor( 1f, 1f, 1f, 0.0f );

	      // Really Nice Perspective Calculations
	      gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);  
	      // GL.GL_FRONT[_AND_BACK], GL.GL_LINE, GL.GL_FILL
//	      gl.glPolygonMode( GL2.GL_FRONT_AND_BACK, GL2.GL_LINE );

//	      gl.glEnable( GL2.GL_DEPTH_TEST );
	      gl.glDepthFunc(GL2.GL_LEQUAL);
//	      gl.glEnable( GL2.GL_AUTO_NORMAL );
//	      gl.glEnable(GL2.GL_NORMALIZE);
//	      gl.glShadeModel( GL2.GL_FLAT );
	      gl.glShadeModel( GL2.GL_SMOOTH );
	      
	    
	      root.init(gl);

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
	    GL2 gl = drawable.getGL().getGL2();
	    gl.glViewport(0, 0, width, height);
	    gl.glMatrixMode(GL2.GL_PROJECTION);
	    gl.glLoadIdentity();
			log.info("reshaping graphics engine");
		
	}
	@Override
	public void render(GLAutoDrawable drawable) {
		
		gl = drawable.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		root.render(gl);
		gl.glFlush();

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
