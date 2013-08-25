package com.sandbox.opengl4prototype;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dapper.engine.data.interfaces.DapperGraphicsEngineInterface;
import com.dapper.engine.data.math.Matrix;
import com.dapper.engine.data.math.SimpleColor;
import com.dapper.engine.data.objects.SceneRoot;
import com.jogamp.newt.event.KeyListener;
import com.jogamp.newt.event.MouseListener;
import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.texture.Texture;

public class ModGraphicsEngine implements DapperGraphicsEngineInterface{
	private static final Logger log = LoggerFactory.getLogger(ModGraphicsEngine.class);
	@Autowired
	public 
	GLEventListener dapperEngine;
	@Autowired
	public 
	KeyListener keyListener;
	@Autowired
	public MouseListener mouseListener;


	
	protected GL2 gl;
	
	protected int FPS;
	protected int windowWidth;
	protected int windowHeight;
	protected String windowTitle;
	
	protected GLWindow glWindow;
    protected FPSAnimator fpsAnimator;
	
     
    public ModGraphicsEngine() {    	 
 		super();
 		log.info("constructing graphics engine");
 		
 	}
	@Override
	public void init(GLAutoDrawable drawable) {
		log.info("Initializing graphics engine");
		 GL2 gl = drawable.getGL().getGL2();

	    
	      gl.glClearColor( 0f, 0f, 0f, 0.0f );
	      gl.glPolygonMode( GL2.GL_FRONT, GL2.GL_FILL );

//	      gl.glEnable( GL2.GL_DEPTH_TEST );
//	      gl.glDepthFunc(GL2.GL_LEQUAL);
//	      gl.glEnable( GL2.GL_AUTO_NORMAL );
//	      gl.glEnable(GL2.GL_NORMALIZE);
	      gl.glShadeModel( GL2.GL_FLAT );
//	      gl.glShadeModel( GL2.GL_SMOOTH );
	      
	    

	}
	
	Texture fontTexture;

	@Override
	public void start() {
		log.info("Starting graphics engine");
		GLProfile glProfile = GLProfile.getDefault(); 		
        GLCapabilities glCapabilities = new GLCapabilities(glProfile); 
//        glCapabilities.setDoubleBuffered( true );
//        glCapabilities.setHardwareAccelerated( true );
        
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
		renderTri(0f, 0f, 0f, .2f, .2f, 0f, SimpleColor.red);
		renderTri(.2f, 0f, -5f, .2f, .2f, 0f, SimpleColor.blue);

	}

	
	public void renderTri(float tx, float ty, float tz, float sx, float sy,
			float sz, SimpleColor color) {
		
        gl.glColor3d(color.getRed(), color.getGreen(), color.getBlue());
        double[][] t = Matrix.new2DPosition(tx, ty, sx, sy, 0);
        double[] a = {-.5,.5,1}; //top left
    	double[] b = {.5,.5,1}; // top right
    	double[] c = {-.5, -.5,1}; // bottom left
    	double[] d = {.5,-.5,1}; // bottom right
    	double[] A = Matrix.multiply(t, a);
		double[] B = Matrix.multiply(t, b);
		double[] C = Matrix.multiply(t, c);
		double[] D = Matrix.multiply(t, d);
		gl.glBegin(GL2.GL_POLYGON);
        gl.glColor3d(color.getRed(), color.getGreen(), color.getBlue());
        gl.glVertex3d(C[0],C[1], 0);
        gl.glVertex3d(B[0],B[1], -1);    
        gl.glVertex3d(A[0],A[1], 1);

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
