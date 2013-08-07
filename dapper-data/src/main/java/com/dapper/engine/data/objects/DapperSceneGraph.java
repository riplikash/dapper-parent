package com.dapper.engine.data.objects;

import java.util.ArrayList;
import java.util.List;

import javax.media.opengl.GL2;

import com.dapper.engine.data.math.Matrix;
import com.dapper.engine.data.math.ScenePosition;

public class DapperSceneGraph extends DapperObject {
	protected ScenePosition pos;
	protected List<DapperSceneGraph> children;
	public DapperSceneGraph() {
		pos = new ScenePosition();	
		children = new ArrayList<DapperSceneGraph>();
	}
	
	DapperSceneGraph(double transformX, double transformY, double scale, double rotation) 
	{
		pos = new ScenePosition(transformX, transformY, scale, rotation);
	}
	
	@Override
	public void render(GL2 gl) {
		if (shape != null)
			shape.render(gl, pos);
		for (DapperSceneGraph obj: children)
		{
			obj.render(gl, pos);
		}
	}
	
	@Override
	public void render(GL2 gl, ScenePosition parentPos) {
		if (shape != null)
			shape.render(gl, pos);
		for (DapperSceneGraph obj: children)
		{
			obj.render(gl, parentPos.combine(pos));
		}
	}

	public void add(DapperSceneGraph newObj) {
		children.add(newObj);
		
	};
	
}
