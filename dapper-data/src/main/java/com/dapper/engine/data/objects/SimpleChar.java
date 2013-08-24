package com.dapper.engine.data.objects;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLProfile;

import com.dapper.engine.data.math.Matrix;
import com.dapper.engine.data.math.Point2D;
import com.dapper.engine.data.math.SimpleColor;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;

public class SimpleChar extends SimpleSquare {
	static volatile Texture fontTexture;
	static volatile Map<String, Point2D> charPos;
	
	double[] ta; //texture top left
	double[] tb; //texture top right
	double[] tc; //texture bottom left
	double[] td; //texture bottom right
	private char character;
	
	public char getChar() { return character; }
	
	public SimpleChar(char c, double x, double y, double scaleX, double scaleY, double rotation, SimpleColor color) {
		super(x, y, scaleX, scaleY, rotation, color);
		this.character = c;
		if (charPos == null)
			initHashMap();
	
		
		ta = new double[] {getLeftX(c), getTopY(c), 1};
		tb = new double[] {getRightX(c), getTopY(c), 1};
		tc = new double[] {getLeftX(c), getBottomY(c), 1};
		td = new double[] {getRightX(c), getBottomY(c), 1};						
	}
	
	@Override
	public synchronized void init(GL2 gl) {
		if (fontTexture == null) {
			GLProfile glProfile = GLProfile.getDefault(); 
	        try {
	            InputStream stream = getClass().getClassLoader().getResource("com/dapper/engine/resources/fontset.png").openStream();
	            TextureData data = TextureIO.newTextureData(glProfile, stream, false, "png");
	            fontTexture = TextureIO.newTexture(data);
	        }
	        catch (IOException exc) {
	            exc.printStackTrace();
	            System.exit(1);
	        }
		}
	
	}	
	
	private Point2D getPoint(int x, int y)
	{
		return new Point2D(x, y);
	}
	private void initHashMap() {
		charPos = new HashMap<String, Point2D>();
		
		charPos.put(" ", getPoint(0,13));
		charPos.put("!", getPoint(1,13));
		charPos.put("\"", getPoint(2,13));
		charPos.put("#", getPoint(3,13));
		charPos.put("$", getPoint(4,13));
		charPos.put("%", getPoint(5,13));
		charPos.put("&", getPoint(6,13));
		charPos.put("'", getPoint(7,13));
		charPos.put("(", getPoint(8,13));
		charPos.put(")", getPoint(9,13));
		charPos.put("*", getPoint(10,13));
		charPos.put("+", getPoint(11,13));
		charPos.put(",", getPoint(12,13));
		charPos.put("-", getPoint(13,13));
		charPos.put(".", getPoint(14,13));
		charPos.put("/", getPoint(15,13));
		
		charPos.put("0", getPoint(0,12));
		charPos.put("1", getPoint(1,12));
		charPos.put("2", getPoint(2,12));
		charPos.put("3", getPoint(3,12));
		charPos.put("4", getPoint(4,12));
		charPos.put("5", getPoint(5,12));
		charPos.put("6", getPoint(6,12));
		charPos.put("7", getPoint(7,12));
		charPos.put("8", getPoint(8,12));
		charPos.put("9", getPoint(9,12));
		charPos.put(":", getPoint(10,12));
		charPos.put(";", getPoint(11,12));
		charPos.put("<", getPoint(12,12));
		charPos.put("=", getPoint(13,12));
		charPos.put(">", getPoint(14,12));
		charPos.put("?", getPoint(15,12));
		
		charPos.put("@", getPoint(0,11));
		charPos.put("A", getPoint(1,11));
		charPos.put("B", getPoint(2,11));
		charPos.put("C", getPoint(3,11));
		charPos.put("D", getPoint(4,11));
		charPos.put("E", getPoint(5,11));
		charPos.put("F", getPoint(6,11));
		charPos.put("G", getPoint(7,11));
		charPos.put("H", getPoint(8,11));
		charPos.put("I", getPoint(9,11));
		charPos.put("J", getPoint(10,11));
		charPos.put("K", getPoint(11,11));
		charPos.put("L", getPoint(12,11));
		charPos.put("M", getPoint(13,11));
		charPos.put("N", getPoint(14,11));
		charPos.put("O", getPoint(15,11));
		
		charPos.put("P", getPoint(0,10));
		charPos.put("Q", getPoint(1,10));
		charPos.put("R", getPoint(2,10));
		charPos.put("S", getPoint(3,10));
		charPos.put("T", getPoint(4,10));
		charPos.put("U", getPoint(5,10));
		charPos.put("V", getPoint(6,10));
		charPos.put("W", getPoint(7,10));
		charPos.put("X", getPoint(8,10));
		charPos.put("Y", getPoint(9,10));
		charPos.put("Z", getPoint(10,10));
		charPos.put("[", getPoint(11,10));
		charPos.put("\\", getPoint(12,10));
		charPos.put("]", getPoint(13,10));
		charPos.put("^", getPoint(14,10));
		charPos.put("_", getPoint(15,10));
		
		charPos.put("`", getPoint(0,9));
		charPos.put("a", getPoint(1,9));
		charPos.put("b", getPoint(2,9));
		charPos.put("c", getPoint(3,9));
		charPos.put("d", getPoint(4,9));
		charPos.put("e", getPoint(5,9));
		charPos.put("f", getPoint(6,9));
		charPos.put("g", getPoint(7,9));
		charPos.put("h", getPoint(8,9));
		charPos.put("i", getPoint(9,9));
		charPos.put("j", getPoint(10,9));
		charPos.put("k", getPoint(11,9));
		charPos.put("l", getPoint(12,9));
		charPos.put("m", getPoint(13,9));
		charPos.put("n", getPoint(14,9));
		charPos.put("o", getPoint(15,9));
		
		charPos.put("p", getPoint(0,8));
		charPos.put("q", getPoint(1,8));
		charPos.put("r", getPoint(2,8));
		charPos.put("s", getPoint(3,8));
		charPos.put("t", getPoint(4,8));
		charPos.put("u", getPoint(5,8));
		charPos.put("v", getPoint(6,8));
		charPos.put("w", getPoint(7,8));
		charPos.put("x", getPoint(8,8));
		charPos.put("y", getPoint(9,8));
		charPos.put("z", getPoint(10,8));
		charPos.put("{", getPoint(11,8));
		charPos.put("|", getPoint(12,8));
		charPos.put("}", getPoint(13,8));
		charPos.put("~", getPoint(14,8));
		
	}
	
	private double getLeftX(char c) {
		String s = String.valueOf(c);
		double pos = charPos.get(s).getX();
		
		return pos/16;
	}
	private double getRightX(char c) {
		String s = String.valueOf(c);
		double pos = charPos.get(s).getX() + 1;
		
		return pos/16;
	}
	private double getBottomY(char c) {
		String s = String.valueOf(c);
		double pos = charPos.get(s).getY();
		return pos/14+.005;
	}
	private double getTopY(char c) {
		String s = String.valueOf(c);
		double pos = charPos.get(s).getY() + 1;
		return pos/14;
	}
  
   
   	
    	@Override
    	public void render(GL2 gl, double[][] pos) {
    		double[][] finalTransformation = getTransformedPosition(pos);
    		double[] A = Matrix.multiply(finalTransformation, a);
    		double[] B = Matrix.multiply(finalTransformation, b);
    		double[] C = Matrix.multiply(finalTransformation, c);
    		double[] D = Matrix.multiply(finalTransformation, d);
   
       	 	fontTexture.enable(gl);
    	    fontTexture.bind(gl);
    	    gl.glEnable(GL.GL_BLEND);
     	    gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
    		
    		gl.glBegin(GL.GL_TRIANGLES);
	            gl.glColor3d(color.getRed(), color.getGreen(), color.getBlue());
	            
	            gl.glTexCoord2d(ta[0],ta[1]);
	            gl.glVertex2d(A[0],A[1]);	            
	            gl.glTexCoord2d(tb[0],tb[1]);
	            gl.glVertex2d(B[0],B[1]);	            
	            gl.glTexCoord2d(tc[0],tc[1]);
	            gl.glVertex2d(C[0],C[1]);
	            
	            gl.glTexCoord2d(tc[0],tc[1]);
	            gl.glVertex2d(C[0],C[1]);
	            gl.glTexCoord2d(tb[0],tb[1]);
	            gl.glVertex2d(B[0],B[1]);
	            gl.glTexCoord2d(td[0],td[1]);
	            gl.glVertex2d(D[0],D[1]);

            gl.glEnd();
            fontTexture.disable(gl);
  
       
    }
    	
      
    
    
}
