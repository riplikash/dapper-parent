package com.dapper.engine.data.objects;

import org.springframework.stereotype.Component;

@Component
public class SceneRoot extends DapperObject {

	public SceneRoot()
	{
		super();
	}
	public SceneRoot(double x, double y, double scaleX, double scaleY,
			double rotation) {
		super(x, y, scaleX, scaleY, rotation);
	}


}
