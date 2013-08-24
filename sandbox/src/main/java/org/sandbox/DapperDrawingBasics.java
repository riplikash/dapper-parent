package org.sandbox;

import javax.media.opengl.GL2;

import org.sandbox.expansiveDemo.Bezier;
import org.sandbox.expansiveDemo.DrawingBasics;
import org.sandbox.expansiveDemo.ParticleSystem;

import com.dapper.engine.data.objects.DapperObject;

public class DapperDrawingBasics extends DapperObject {
	DrawingBasics db = new DrawingBasics();
	Bezier bezier = new Bezier();
	ParticleSystem particleSystem = new ParticleSystem();
	public DapperDrawingBasics() {
	}
	@Override
	public void render(GL2 gl, double[][] pos) {
//		db.drawAxis( gl, false );      
//		db.drawPoints( gl );
//		db.draw2DPoints( gl );
//		db.drawTriangle( gl );
//		db.drawColorTriangle( gl );
//		db.drawWhiteTriangle( gl );
//		db.drawHouse( gl );
//		db.draw3DHouseLines( gl );
//		db.drawCircle( gl, 0f, 0f, 0f );
//		db.drawHouseNoInnerEdge( gl );
//		db.drawCube( gl, 1.0f );
//		db.drawSphere( gl, 0f, 0f, 0f, 0.5f, true );
      bezier.drawSpiral( gl );
      bezier.draw2DBezier( gl );
      particleSystem.draw(gl);
//      bezier.draw3DBezier( gl );
	}
	
	@Override 
	public void init(GL2 gl)
	{
		super.init(gl);
		particleSystem.init(gl);
		
	}
	
}
