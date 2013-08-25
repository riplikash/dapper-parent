package org.sandbox.expansiveDemo.demo;

import javax.media.opengl.GL2;

import org.sandbox.expansiveDemo.Bezier;
import org.sandbox.expansiveDemo.DrawingBasics;
import org.sandbox.expansiveDemo.ParticleSystem;

import com.dapper.engine.data.objects.DapperObject;

public class DapperDrawingBasics extends DapperObject {
	DrawingBasics drawingBasics = new DrawingBasics();
	Bezier bezier = new Bezier();
	ParticleSystem particleSystem = new ParticleSystem();
	public DapperDrawingBasics() {
		
	}
	@Override
	public void render(GL2 gl, double[][] pos) {
		drawingBasics.drawAxis( gl, false );      
		drawingBasics.drawPoints( gl );
		drawingBasics.draw2DPoints( gl );
		drawingBasics.drawTriangle( gl );
		drawingBasics.drawColorTriangle( gl );
		drawingBasics.drawWhiteTriangle( gl );
		drawingBasics.drawHouse( gl );
		drawingBasics.draw3DHouseLines( gl );
		drawingBasics.drawCircle( gl, 0f, 0f, 0f );
		drawingBasics.drawHouseNoInnerEdge( gl );
		drawingBasics.drawCube( gl, 1.0f );
		drawingBasics.drawSphere( gl, 0f, 0f, 0f, 0.5f, true );
//	bezier.drawSpiral( gl );
//	bezier.draw2DBezier( gl );
//	particleSystem.draw(gl);

	}
	
	@Override 
	public void init(GL2 gl)
	{
		drawingBasics.initAliasingAndFog( gl, true, false );
		super.init(gl);
//		particleSystem.init(gl);
		
	}
	
}
