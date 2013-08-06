package com.dapper.engine.data.objects;

import java.util.ArrayList;
import java.util.List;

import javax.media.opengl.GL2;

import com.dapper.engine.data.math.Point2D;
import com.dapper.engine.data.math.ScenePosition;

public class DapperSceneGraph {
	ScenePosition pos;
	
	List<SimpleSquare> currentItems;
	
	DapperSceneGraph() {
		pos = new ScenePosition();
		currentItems = new ArrayList<SimpleSquare>();
	}
	DapperSceneGraph(double transformX, double transformY, double scale, double rotation) 
	{
		pos = new ScenePosition(transformX, transformY, scale, rotation);
	}
	
	public void render(GL2 gl) {
		for (SimpleSquare obj: currentItems)
		{
//			obj.render(gl, pos);
		}
	};
	
}
