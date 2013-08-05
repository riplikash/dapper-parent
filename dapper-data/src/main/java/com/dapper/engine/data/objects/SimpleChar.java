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

public class SimpleChar extends SimpleShape {
	Texture fontTexture;
	public void init() {
		if (fontTexture == null)
		{
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
    public SimpleChar(Point2D translation, Point2D scale)
    {
        super(translation, scale);
        points = new ArrayList<Point2D>();
        points.add(new Point2D(0, 0));
        points.add(new Point2D(1, 0));
        points.add(new Point2D(0, -1));

        points.add(new Point2D(0, -1));
        points.add(new Point2D(1, 0));
        points.add(new Point2D(1, -1));
    }
    public SimpleChar(Point2D translation, Point2D scale, SimpleColor color)
    {
        super(translation, scale, color);
        points = new ArrayList<Point2D>();
        points.add(new Point2D(0, 0, color));
        points.add(new Point2D(1, 0, color));
        points.add(new Point2D(0,-1, color));

        points.add(new Point2D(0, -1, color));
        points.add(new Point2D(1, 0, color));
        points.add(new Point2D(1, -1, color));
    }

    @Override
    public List<Point2D> getDisplayList() {
        return getTransformedPoints();
    }
    
    @Override
    public void render(GL2 gl)
    {
    	 fontTexture.enable(gl);
 	    fontTexture.bind(gl);
    	List<Point2D> displayList = getTransformedPoints();
    	gl.glBegin(GL.GL_TRIANGLES);
        gl.glColor3d(color.getRed(), color.getGreen(), color.getBlue());
        
        gl.glVertex2d(displayList.get(0).getX(), displayList.get(0).getY());
        gl.glTexCoord2d(0, 0);
        gl.glVertex2d(displayList.get(1).getX(), displayList.get(1).getY());
        gl.glTexCoord2d(10, 0);
        gl.glVertex2d(displayList.get(2).getX(), displayList.get(2).getY());
        gl.glTexCoord2d(0, -10);
        gl.glVertex2d(displayList.get(3).getX(), displayList.get(3).getY());
        gl.glTexCoord2d(0, -10);
        gl.glVertex2d(displayList.get(4).getX(), displayList.get(4).getY());
        gl.glTexCoord2d(10, 0);
        gl.glVertex2d(displayList.get(5).getX(), displayList.get(5).getY());
        gl.glTexCoord2d(10, -10);
        gl.glEnd();
        fontTexture.disable(gl);
    }
}
