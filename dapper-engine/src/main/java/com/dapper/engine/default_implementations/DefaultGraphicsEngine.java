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
	public void init(GLAutoDrawable drawable) {
		log.info("Initializing graphics engine");
		 GL2 gl = drawable.getGL().getGL2();

	      // Be carefull with debug, it can cause errors.
	      //drawable.setGL( new DebugGL(drawable.getGL() ));
	      //System.out.println("Init GL is " + gl.getClass().getName());

	      // On some systems the reshape call does not seem to 
	      // happen automatically on init.
	      // Set the projection and viewport.
	      reshape( drawable, 0, 0, windowWidth, windowHeight );

	      gl.glClearColor( 0f, 0f, 0f, 0.0f );
	      //gl.glClearColor( 1f, 1f, 1f, 0.0f );

	      // Really Nice Perspective Calculations
	      //gl.glHint(GL.GL_PERSPECTIVE_CORRECTION_HINT, GL.GL_NICEST);  
	      // GL.GL_FRONT[_AND_BACK], GL.GL_LINE, GL.GL_FILL
//	      gl.glPolygonMode( GL2.GL_FRONT_AND_BACK, GL2.GL_LINE );

//	      gl.glEnable( GL2.GL_DEPTH_TEST );
	      //gl.glDepthFunc(GL.GL_LEQUAL);
	      gl.glEnable( GL2.GL_AUTO_NORMAL );
	      //gl.glEnable(GL.GL_NORMALIZE);
	      //gl.glShadeModel( GL.GL_FLAT );
	      gl.glShadeModel( GL2.GL_SMOOTH );
	      
	      //drawingBasics.initAliasingAndFog( gl, true, false );
	      //blend.init( gl );
	      //light.init( gl );
	      //font.init( gl );      
	      //solarSystem.initDisplayLists( gl, glu );
	      //imaging.init( width, height );
	      //imaging.loadImage( null ); // Load default image.
	      //texturing.init( gl, glu );
	      //texture3D.init( gl );
	      //modelLoaderOBJ.init( gl );
	      //particleSystem.init( gl );
	      //vertexArray.init( gl );
	      
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
