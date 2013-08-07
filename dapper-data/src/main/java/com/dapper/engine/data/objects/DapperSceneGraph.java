package com.dapper.engine.data.objects;

import java.util.ArrayList;
import java.util.List;

import javax.media.opengl.GL2;

import com.dapper.engine.data.math.ScenePosition;

public class DapperSceneGraph {
	ScenePosition pos;
	
	List<DapperObject> displayObjects;
	
	
	public DapperSceneGraph() {
		pos = new ScenePosition();
		displayObjects = new ArrayList<DapperObject>();
	}
	DapperSceneGraph(double transformX, double transformY, double scale, double rotation) 
	{
		pos = new ScenePosition(transformX, transformY, scale, rotation);
	}
	
	public void addObject(DapperObject obj) {
		displayObjects.add(obj);
	}
	
	public void render(GL2 gl) {
		for (DapperObject obj: displayObjects)
		{
			
			obj.render(gl, pos);
			obj.render(gl);
		}
	};
	
}
