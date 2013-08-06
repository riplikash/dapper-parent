package com.dapper.engine.data.objects;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLProfile;


import com.dapper.engine.data.math.Point2D;
import com.dapper.engine.data.math.SimpleColor;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;

public class SimpleChar extends SimpleSquare {
	static Texture fontTexture;
	static boolean loaded = false;
	ArrayList<Point2D> texture;
	public void init() {
		if (loaded == false)
		{
			loaded = true;
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
	public SimpleChar() {};
	public SimpleChar(char c, Point2D translation, Point2D scale)
	{
		super(translation, scale, SimpleColor.white);
        texture = new ArrayList<Point2D>();
        points = new ArrayList<Point2D>();
        points.add(new Point2D(0, 0, color));        
        points.add(new Point2D(1, 0, color));
        points.add(new Point2D(0, -1, color));        
        points.add(new Point2D(0, -1, color));        
        points.add(new Point2D(1, 0, color));
        points.add(new Point2D(1, -1, color));
	        

		double leftX, rightX, topY, bottomY;		   
        leftX = 8/(double)16;
        rightX =9/(double)16;
        topY = 1/(double)14;
        bottomY = 0/(double)14;

        System.out.println(c);
		switch (c) {
		case '0':
			   
	        leftX = 0;
	        rightX =1/(double)16;
	        topY = 13/(double)14;
	        bottomY = 12/(double)14;	        	      
		break;

		case '1':			   
		        leftX = 1/(double)16;
		        rightX =2/(double)16;
		        topY = 13/(double)14;
		        bottomY = 12/(double)14;
			break;
	
		case '2':			   
	        leftX = 2/(double)16;
	        rightX =3/(double)16;
	        topY = 13/(double)14;
	        bottomY = 12/(double)14;
		break;
		case '3':			   
	        leftX = 3/(double)16;
	        rightX =4/(double)16;
	        topY = 13/(double)14;
	        bottomY = 12/(double)14;
		break;
		case '4':			   
	        leftX = 4/(double)16;
	        rightX =5/(double)16;
	        topY = 13/(double)14;
	        bottomY = 12/(double)14;
		break;
		case '5':			   
	        leftX = 5/(double)16;
	        rightX =6/(double)16;
	        topY = 13/(double)14;
	        bottomY = 12/(double)14;
		break;
		case '6':			   
	        leftX = 6/(double)16;
	        rightX =7/(double)16;
	        topY = 13/(double)14;
	        bottomY = 12/(double)14;
		break;
		case '7':			   
	        leftX = 7/(double)16;
	        rightX =8/(double)16;
	        topY = 13/(double)14;
	        bottomY = 12/(double)14;
		break;
		case '8':			   
	        leftX = 8/(double)16;
	        rightX =9/(double)16;
	        topY = 13/(double)14;
	        bottomY = 12/(double)14;
		break;
		case '9':			   
	        leftX = 9/(double)16;
	        rightX =10/(double)16;
	        topY = 13/(double)14;
	        bottomY = 12/(double)14;
		break;
		case '.':			   
	        leftX = 14/(double)16;
	        rightX =15/(double)16;
	        topY = 14/(double)14;
	        bottomY = 13/(double)14;
		break;
		case ',':			   
	        leftX = 12/(double)16;
	        rightX =13/(double)16;
	        topY = 14/(double)14;
	        bottomY = 13/(double)14;
		break;
		case '(':			   
	        leftX = 8/(double)16;
	        rightX =9/(double)16;
	        topY = 14/(double)14;
	        bottomY = 13/(double)14;
		break;
		case ')':			   
	        leftX = 9/(double)16;
	        rightX =10/(double)16;
	        topY = 14/(double)14;
	        bottomY = 13/(double)14;
		break;

		default:
			
			break;
		}
		
		 // 16 x 14
        texture.add(new Point2D(leftX,topY));
        texture.add(new Point2D(rightX,topY));        
        texture.add(new Point2D(leftX,bottomY));        
        texture.add(new Point2D(leftX,bottomY));
        texture.add(new Point2D(rightX,topY));
        texture.add(new Point2D(rightX,bottomY));
		
		
	}
  
    @Override
    public List<Point2D> getDisplayList() {
        return getTransformedPoints();
    }
    
    @Override
    public void render(GL2 gl)
    {
    	init();
    	 fontTexture.enable(gl);
 	    fontTexture.bind(gl);
 	    gl.glEnable(GL.GL_BLEND);
 	    gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
    	List<Point2D> displayList = getTransformedPoints();
    	gl.glBegin(GL.GL_TRIANGLES);
    	gl.glColor3d(color.getRed(), color.getGreen(), color.getBlue());
    
        
        gl.glTexCoord2d(texture.get(0).getX(), texture.get(0).getY());
        gl.glVertex2d(displayList.get(0).getX(), displayList.get(0).getY());
        gl.glTexCoord2d(texture.get(1).getX(), texture.get(1).getY());
        gl.glVertex2d(displayList.get(1).getX(), displayList.get(1).getY());
        gl.glTexCoord2d(texture.get(2).getX(), texture.get(2).getY());
        gl.glVertex2d(displayList.get(2).getX(), displayList.get(2).getY());
        gl.glTexCoord2d(texture.get(3).getX(), texture.get(3).getY());
        gl.glVertex2d(displayList.get(3).getX(), displayList.get(3).getY());
        gl.glTexCoord2d(texture.get(4).getX(), texture.get(4).getY());
        gl.glVertex2d(displayList.get(4).getX(), displayList.get(4).getY());
        gl.glTexCoord2d(texture.get(5).getX(), texture.get(5).getY());
        gl.glVertex2d(displayList.get(5).getX(), displayList.get(5).getY());
        
        gl.glEnd();
        fontTexture.disable(gl);
    }
    
    
    
}
