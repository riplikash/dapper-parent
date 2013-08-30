package org.dapper.deux;

import javax.media.opengl.GL;
import javax.media.opengl.GL3;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

import org.dapper.deux.Gl3Sample.ShaderType;

public class L1 implements GLEventListener {
	int programId;
    public static void main(String[] args) {
        // allocate the openGL application
        Gl3Sample sample = new Gl3Sample();
 
        // allocate a frame and display the openGL inside it
        JFrame frame = newJFrame("Lesson 1",
                sample, 10, 10, 600, 800);
 
        // display it and let's go
        frame.setVisible(true);
    }

	@Override
	public void init(GLAutoDrawable drawable) {
        GL3 gl = drawable.getGL().getGL3();
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
 
        programId = newProgram(gl);
        //setupBuffers
		
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}
	
    public static JFrame newJFrame(String name, GLEventListener sample, int x,
            int y, int width, int height) {
        JFrame frame = new JFrame(name);
        frame.setBounds(x, y, width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        GLProfile glp = GLProfile.get(GLProfile.GL3);
        GLCapabilities glCapabilities = new GLCapabilities(glp);
        GLCanvas glCanvas = new GLCanvas(glCapabilities);
 
        glCanvas.addGLEventListener(sample);
        frame.add(glCanvas);
 
        return frame;
    }
    
    int newProgram(GL3 gl) {
        // create the two shader and compile them
//        int v = this.newShaderFromCurrentClass(gl, "vertex.shader", ShaderType.VertexShader);
//        int f = this.newShaderFromCurrentClass(gl, "fragment.shader", ShaderType.FragmentShader);
 
//        System.out.println(getShaderInfoLog(gl, v));
//        System.out.println(getShaderInfoLog(gl, f));
    	int p = gl.glCreateProgram();
    	gl.glLinkProgram(programId);
//        gl.glBindFragDataLocation(p, 0, "outColor");
//        printProgramInfoLog(gl, p);
 
//        this.vertexLoc = gl.glGetAttribLocation( p, "position");
//        this.colorLoc = gl.glGetAttribLocation( p, "color");
 
//        this.projMatrixLoc = gl.glGetUniformLocation( p, "projMatrix");
//        this.viewMatrixLoc = gl.glGetUniformLocation( p, "viewMatrix");
 
        return p;
    }
}
