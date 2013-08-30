package org.dapper.deux;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.media.opengl.GL;
import javax.media.opengl.GL3;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

import org.dapper.deux.math.Matrix;

import com.jogamp.common.nio.Buffers;
 
/**
 * inspired from http://www.lighthouse3d.com/cg-topics/code-samples/opengl-3-3-glsl-1-5-sample/
 * 
 */
public class Gl3Sample implements GLEventListener {
    public static void main(String[] args) {
        // allocate the openGL application
        Gl3Sample sample = new Gl3Sample();
 
        // allocate a frame and display the openGL inside it
        JFrame frame = newJFrame("JOGL3 sample with Shader",
                sample, 10, 10, 600, 800);
 
        // display it and let's go
        frame.setVisible(true);
    }
    
    /** GL Init */
    @Override
    public void init(GLAutoDrawable drawable) {
        GL3 gl = drawable.getGL().getGL3();
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
 
        this.programID = this.newProgram(gl);
        this.setupBuffers(gl);
    }
 
    /** GL Window Reshape */
    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        float ratio;
        // Prevent a divide by zero, when window is too short
        // (you can't make a window of zero width).
        if (height == 0)
            height = 1;
 
        ratio = (1.0f * width) / height;
        this.projMatrix = Matrix.buildProjectionMatrix(53.13f, ratio, 1.0f, 30.0f, this.projMatrix);
    }
 
    /** GL Render loop */
    @Override
    public void display(GLAutoDrawable drawable) {
        GL3 gl = drawable.getGL().getGL3();
        renderScene(gl);
    }
 
    /** GL Complete */
    @Override
    public void dispose(GLAutoDrawable drawable) {
    }
   
    
    
    enum ShaderType{ VertexShader, FragmentShader}
 
    // Data for drawing Axis
    float verticesAxis[] = { 
            -1.0f,  0.0f, 0.0f, 1.0f, 
             1.0f,  0.0f, 0.0f, 1.0f,
             0.0f, -1.0f, 0.0f, 1.0f, 
             0.0f,  1.0f, 0.0f, 1.0f};
 
    float colorAxis[] = { 
            0.0f, 0.0f, 0.0f, 0.0f, 
            0.0f, 0.0f, 0.0f, 0.0f, 
            0.0f, 0.0f, 0.0f, 0.0f, 
            0.0f, 0.0f, 0.0f, 0.0f, 
            };
 
    // Data for triangle  x,y,z,w
    float vertices[] = {    0.8f, 0.2f, .0f, 1.0f,  
                            0.2f, 0.2f, .0f, 1.0f,
                            0.5f, 0.8f, .0f, 1.0f };
    // Data for triangle  x,y,z,w
    float vertices2[] = {    -0.1f, 0.8f, .0f, .9f,  
                            0.5f, 0.2f, .0f, .9f,
                            0.6f, 0.9f, .0f, 1.1f };
    
    float colorArray[] = {  // RGBA
            0.0f, 0.0f, 1.0f, 1.0f, 
            1.0f, 0.0f, 0.0f, 1.0f, 
            0.0f, 0.0f, 1.0f, 1.0f };
 
    // Program
        int programID;
 
    // Vertex Attribute Locations
    int vertexLoc, colorLoc;
 
    // Uniform variable Locations
    int projMatrixLoc, viewMatrixLoc;
 
    // storage for Matrices
    float projMatrix[] = new float[16];
    float viewMatrix[] = new float[16];
 
    protected int triangleVAO;
    protected int triangleVAO2;
    protected int axisVAO;
 
   
 
    void changeSize(GL3 gl, int w, int h) {
 
        float ratio;
        // Prevent a divide by zero, when window is too short
        // (you cant make a window of zero width).
        if (h == 0)
            h = 1;
 
        // Set the viewport to be the entire window
        //gl.glViewport(0, 0, w, h);
 
        ratio = (1.0f * w) / h;
        this.projMatrix = Matrix.buildProjectionMatrix(53.13f, ratio, 1.0f, 30.0f, this.projMatrix);
    }
 
    void setupBuffers(GL3 gl) {
        // generate the IDs
        this.triangleVAO = this.generateVAOId(gl);
        this.triangleVAO2 = this.generateVAOId(gl);
        this.axisVAO = this.generateVAOId(gl);
 
        // create the buffer and link the data with the location inside the vertex shader
        this.newFloatVertexAndColorBuffers(gl, this.triangleVAO, 
                this.vertices, this.colorArray, this.vertexLoc, this.colorLoc);
        this.newFloatVertexAndColorBuffers(gl, this.triangleVAO2, 
                this.vertices2, this.colorArray, this.vertexLoc, this.colorLoc);
        this.newFloatVertexAndColorBuffers(gl, this.axisVAO,
                this.verticesAxis, this.colorAxis, this.vertexLoc, this.colorLoc);
    }
 
    void newFloatVertexAndColorBuffers(GL3 gl, int vaoId, float[] verticesArray, float[] colorArray, int verticeLoc, int colorLoc){
        // bind the correct VAO id
        gl.glBindVertexArray( vaoId);
        // Generate two slots for the vertex and color buffers
        int vertexBufferId = this.generateBufferId(gl);
        int colorBufferId = this.generateBufferId(gl);
 
        // bind the two buffer
        this.bindBuffer(gl, vertexBufferId, verticesArray, verticeLoc);
        this.bindBuffer(gl, colorBufferId, colorArray, colorLoc);
    }
 
    void bindBuffer(GL3 gl, int bufferId, float[] dataArray, int dataLoc){
        // bind buffer for vertices and copy data into buffer
        gl.glBindBuffer(GL.GL_ARRAY_BUFFER, bufferId);
        gl.glBufferData(GL.GL_ARRAY_BUFFER, dataArray.length * Float.SIZE / 8,
                Buffers.newDirectFloatBuffer(dataArray), GL.GL_STATIC_DRAW);
        gl.glEnableVertexAttribArray(dataLoc);
        gl.glVertexAttribPointer(dataLoc, 4, GL.GL_FLOAT, false, 0, 0);
 
    }
 
    protected int generateVAOId(GL3 gl) {
        // allocate an array of one element in order to strore 
        // the generated id
        int[] idArray = new int[1];
        // let's generate
        gl.glGenVertexArrays(1, idArray, 0);
        // return the id
        return idArray[0];
    }
 
    protected int generateBufferId(GL3 gl) {
        // allocate an array of one element in order to store 
        // the generated id
        int[] idArray = new int[1];
        // let's generate
        gl.glGenBuffers( 1, idArray, 0);
 
        // return the id
        return idArray[0];
    }
 
    protected void renderScene(GL3 gl) {
 
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
 
        Matrix.setCamera(    0.5f, 0.5f,  2, 
                    0.5f, 0.5f, -1,
                    this.viewMatrix);
 
        gl.glUseProgram(this.programID);
 
        // must be called after glUseProgram
        // set the view and the projection matrix 
        gl.glUniformMatrix4fv( this.projMatrixLoc, 1, false, this.projMatrix, 0);
        gl.glUniformMatrix4fv( this.viewMatrixLoc, 1, false, this.viewMatrix, 0);
 
        gl.glBindVertexArray(this.triangleVAO);
        gl.glDrawArrays(GL.GL_TRIANGLES, 0, 3);
 
        gl.glBindVertexArray(this.triangleVAO2);
        gl.glDrawArrays(GL.GL_TRIANGLES, 0, 3);
        
        gl.glBindVertexArray(this.axisVAO);
        gl.glDrawArrays(GL.GL_LINES, 0, 4);
 
        // Check out error
        int error = gl.glGetError();
        if(error!=0){
            System.err.println("ERROR on render : " + error);}
    }
 
    /** Retrieves the info log for the shader */
    public String getShaderInfoLog(GL3 gl, int obj) {
        // Otherwise, we'll get the GL info log
        final int logLen = getShaderParameter(gl, obj, GL3.GL_INFO_LOG_LENGTH);
        if (logLen <= 0)
            return "";
 
        // Get the log
        final int[] retLength = new int[1];
        final byte[] bytes = new byte[logLen + 1];
        gl.glGetShaderInfoLog(obj, logLen, retLength, 0, bytes, 0);
        final String logMessage = new String(bytes);
 
        return String.format("ShaderLog: %s", logMessage);
    }
 
    /** Get a shader parameter value. See 'glGetShaderiv' */
    private int getShaderParameter(GL3 gl, int obj, int paramName) {
        final int params[] = new int[1];
        gl.glGetShaderiv(obj, paramName, params, 0);
        return params[0];
    }
 
    /** Retrieves the info log for the program */
    public String printProgramInfoLog(GL3 gl, int obj) {
        // get the GL info log
        final int logLen = getProgramParameter(gl, obj, GL3.GL_INFO_LOG_LENGTH);
        if (logLen <= 0)
            return "";
 
        // Get the log
        final int[] retLength = new int[1];
        final byte[] bytes = new byte[logLen + 1];
        gl.glGetProgramInfoLog(obj, logLen, retLength, 0, bytes, 0);
        final String logMessage = new String(bytes);
 
        return logMessage;
    }
 
    /** Gets a program parameter value */
    public int getProgramParameter(GL3 gl, int obj, int paramName) {
        final int params[] = new int[1];
        gl.glGetProgramiv(obj, paramName, params, 0);
        return params[0];
    }
 
    protected String loadStringFileFromCurrentPackage( String fileName){
        InputStream stream = this.getClass().getResourceAsStream(fileName);
 
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        // allocate a string builder to add line per line 
        StringBuilder strBuilder = new StringBuilder();
 
        try {
            String line = reader.readLine();
            // get text from file, line per line
            while(line != null){
                strBuilder.append(line + "\n");
                line = reader.readLine();    
            }
            // close resources
            reader.close();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        return strBuilder.toString();
    }
 
    int newProgram(GL3 gl) {
        // create the two shader and compile them
        int v = this.newShaderFromCurrentClass(gl, "vertex.shader", ShaderType.VertexShader);
        int f = this.newShaderFromCurrentClass(gl, "fragment.shader", ShaderType.FragmentShader);
 
        System.out.println(getShaderInfoLog(gl, v));
        System.out.println(getShaderInfoLog(gl, f));
 
        int p = this.createProgram(gl, v, f);
 
        gl.glBindFragDataLocation(p, 0, "outColor");
        printProgramInfoLog(gl, p);
 
        this.vertexLoc = gl.glGetAttribLocation( p, "position");
        this.colorLoc = gl.glGetAttribLocation( p, "color");
 
        this.projMatrixLoc = gl.glGetUniformLocation( p, "projMatrix");
        this.viewMatrixLoc = gl.glGetUniformLocation( p, "viewMatrix");
 
        return p;
    }
 
    private int createProgram(GL3 gl, int vertexShaderId, int fragmentShaderId) {
        // generate the id of the program
        int programId = gl.glCreateProgram();
        // attach the two shader
        gl.glAttachShader(programId, vertexShaderId);
        gl.glAttachShader(programId, fragmentShaderId);
        // link them
        gl.glLinkProgram(programId);
 
        return programId;
    }
 
    int newShaderFromCurrentClass(GL3 gl, String fileName, ShaderType type){
        // load the source
        String shaderSource = this.loadStringFileFromCurrentPackage( fileName);
        // define the shaper type from the enum
        int shaderType = type==ShaderType.VertexShader?GL3.GL_VERTEX_SHADER:GL3.GL_FRAGMENT_SHADER;
        // create the shader id
        int id = gl.glCreateShader(shaderType);
        //  link the id and the source
        gl.glShaderSource(id, 1, new String[] { shaderSource }, null);
        //compile the shader
        gl.glCompileShader(id);
 
        return id;
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
 

}