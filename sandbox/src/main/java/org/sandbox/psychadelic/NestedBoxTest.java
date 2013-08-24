package org.sandbox.psychadelic;

import javax.media.opengl.GL2;

import com.dapper.engine.data.math.Matrix;
import com.dapper.engine.data.math.SimpleColor;
import com.dapper.engine.data.objects.DapperObject;

public class NestedBoxTest extends DapperObject {
	public static NestedBox first;
	public static NestedBox last;
	public static double rot;
	
	public synchronized void inc() {
		first = first.getNext();
		NestedBox newLast = new NestedBox(last.getNextColor());
		last.addChild(newLast);
		last = newLast;		
		this.transform(Matrix.rotation(rot));
	}

	public NestedBoxTest(double x, double y, double scaleX, double scaleY, double rot)
	{
		super(x, y, scaleX, scaleY, rot);
		rot = 0;
		NestedBox next = new NestedBox( NestedBox.color1);
		NestedBox current;
		addChild(next);
		first = next;
		for (int i = 0; i < 100; i++)
		{	
			current = next;
			next  = new NestedBox(current.getNextColor());
			current.addChild(next);	
		}
		last = next;	
	}
	

	@Override
	public void render(GL2 gl, double[][] pPos)
	{
		first.render(gl, getTransformedPosition(pPos));
	}

}
