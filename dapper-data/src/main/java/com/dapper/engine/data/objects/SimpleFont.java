package com.dapper.engine.data.objects;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.media.opengl.GLProfile;

import com.dapper.engine.data.math.Point2D;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;

public class SimpleFont extends DapperObject{
	
	
	SimpleFont() {
		shape = new SimpleChar(new Point2D(0,0), new Point2D(.2, .2));
	}
	
	
}
