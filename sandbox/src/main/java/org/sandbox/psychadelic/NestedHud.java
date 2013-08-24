package org.sandbox.psychadelic;

import javax.media.opengl.GL2;

import com.dapper.engine.data.math.DapperUtil;
import com.dapper.engine.data.math.SimpleColor;
import com.dapper.engine.data.objects.DapperObject;
import com.dapper.engine.data.objects.SimpleFont;
import com.dapper.engine.data.objects.SimpleSquare;

public class NestedHud extends DapperObject {
	public SimpleFont sx, sy, tx, ty, r1, r2;
	public SimpleSquare a, b, c, d, e, f;
	public double height = .95;
	public double fontSize = 5;

	public double pos(int i) { return (-.98 + i * (.34)); }
	public double blockPos(int i) { return pos(i) + .09; }
	public NestedHud(double ttx, double tty, double tsx, double tsy, double trot) {
		
		a = new SimpleSquare(blockPos(0), height, .4, .1, 0, SimpleColor.black);
		b = new SimpleSquare(blockPos(1), height, .4, .1, 0, SimpleColor.black);
		c = new SimpleSquare(blockPos(2), height, .4, .1, 0, SimpleColor.black);
		d = new SimpleSquare(blockPos(3), height, .4, .1, 0, SimpleColor.black);
		e = new SimpleSquare(blockPos(4), height, .4, .1, 0, SimpleColor.black);
		f = new SimpleSquare(blockPos(5), height, .4, .1, 0, SimpleColor.black);
		sx = new SimpleFont("Sx:" + tsx , pos(0), height, fontSize);		
		sy = new SimpleFont("Sy:" + tsy, pos(1), height, fontSize);
		tx = new SimpleFont("Tx:" + ttx, pos(2), height, fontSize);
		ty = new SimpleFont("Ty:" + tty, pos(3), height, fontSize);
		r1 = new SimpleFont("R1:" + trot, pos(4), height, fontSize);
		r2 = new SimpleFont("B2:" + trot, pos(5), height, fontSize);
		
		addChild(sx);
		addChild(sy);
		addChild(tx);
		addChild(ty);
		addChild(r1);
		addChild(r2);
	}
	
	@Override
	public void render(GL2 gl, double[][] pPos)
	{
		double[][] finalT = getTransformedPosition(pPos);
		a.render(gl, finalT);
		b.render(gl, finalT);
		c.render(gl, finalT);
		d.render(gl, finalT);
		e.render(gl, finalT);
		f.render(gl, finalT);
		sx.render(gl, finalT);
		sy.render(gl, finalT);
		tx.render(gl, finalT);
		ty.render(gl, finalT);
		r1.render(gl, finalT);
		r2.render(gl, finalT);
	}
	
	public void update(double tx, double ty, double sx,double sy, double rot1, double rot2) {
		updateSx(sx);
		updateSy(sy);
		updateTx(tx);
		updateTy(ty);
		updateRot1(rot1);
		updateRot2(rot2);
	}
	
	public void updateSx(double i) {sx = new SimpleFont("Sx:"+DapperUtil.round(i, 3) , pos(0), height, fontSize); }
	public void updateSy(double i) {sy = new SimpleFont("Sy:"+DapperUtil.round(i, 3), pos(1), height, fontSize); }
	public void updateTx(double i) {tx = new SimpleFont("Tx:"+DapperUtil.round(i, 3), pos(2), height, fontSize); }
	public void updateTy(double i) {ty = new SimpleFont("Ty:"+DapperUtil.round(i, 3), pos(3), height, fontSize); }
	public void updateRot1(double i) { r1 = new SimpleFont("R1:"+DapperUtil.round(i, 3), pos(4), height, fontSize);}
	public void updateRot2(double i) { r2 = new SimpleFont("R2:"+DapperUtil.round(i, 3), pos(5), height, fontSize);}
	
}
