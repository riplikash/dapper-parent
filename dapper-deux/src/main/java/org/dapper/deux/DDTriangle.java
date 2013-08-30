package org.dapper.deux;

import javax.media.opengl.GL3;

public class DDTriangle {
	float vertices[] = {   
		-1.0f, -1.0f, 0.0f,
		1.0f, -1.0f, 0.0f,
		.0f,  1.0f, 0.0f };

	int VAO;
	
	public void init(GL3 gl) {
		
		VAO = generateVAOId(gl);
		gl.glBindVertexArray(VAO);
	}	
	
    protected static int generateVAOId(GL3 gl) {
        // allocate an array of one element in order to stroe 
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
}