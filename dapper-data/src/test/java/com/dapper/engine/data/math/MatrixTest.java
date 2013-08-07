package com.dapper.engine.data.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixTest {

	@Test
	public void testIdentity() {
		System.out.println("testing identity");
        double[][] c = Matrix.identity(5);
        System.out.println(Matrix.toString(c));
        for (int y = 0; y < 5; y++)
        	for (int x = 0; x < 5; x++)
    		{
        		if (y == x)
        			assertEquals(c[x][y], 1, 0);
        		else 
        			assertEquals(c[x][y], 0, 0);
    		}
	}
	
	@Test
	public void testMatrixMultiply() {
		double[][] a = { { 3, 5 ,2}, {4, 5,1 } };
		double[][] b = { { 1, 2 }, { 4, 5 }, { 9,3 } };		
		double[][] c = Matrix.multiply(a, b);

		assertEquals(c[0][0], 41, 0);
		assertEquals(c[0][1], 37, 0);
		assertEquals(c[1][0], 33, 0);
		assertEquals(c[1][1], 36, 0);
	}

	@Test
	public void testTranspose() {
		double[][] a = { { 3, 5 ,2}, {4, 5,1 } };
		System.out.println(Matrix.toString(a));
		double[][] b = Matrix.transpose(a);
		System.out.println(Matrix.toString(b));
		assertEquals(a[0][1], b[1][0], 0);
		assertEquals(a[1][2], b[2][1], 0);
		
	}

	@Test
	public void testAdd() {
		double[][] a = { { 3, 5 ,2}, {4, 5,1 } };
		double[][] b = Matrix.add(a, a);
		System.out.println(Matrix.toString(b));
		assertEquals(b[0][0], 6, 0);
		assertEquals(b[0][1], 10, 0);
		assertEquals(b[0][2], 4, 0);
		assertEquals(b[1][0], 8, 0);
		assertEquals(b[1][1], 10, 0);
		assertEquals(b[1][2], 2, 0);
	}

	@Test
	public void testSubtract() {
		double[][] a = { { 3, 5 ,2}, {4, 5,1 } };
		double[][] b = Matrix.subtract(a, a);
		System.out.println(Matrix.toString(b));
		assertEquals(b[0][0], 0, 0);
		assertEquals(b[0][1], 0, 0);
		assertEquals(b[0][2], 0, 0);
		assertEquals(b[1][0], 0, 0);
		assertEquals(b[1][1], 0, 0);
		assertEquals(b[1][2], 0, 0);
	}

	@Test
	public void testMatrixDot() {
		double[] a = {1, 2, 3};
		double b = Matrix.dot(a, a);
		assertEquals(b, 14, 0);
	}

	@Test
	public void testMultiplyDoubleBySingle() {
		double[][] a = { {1,2,3}, {4, 5,6 } };
		double[] b = {1,2,3};
		double[] c = Matrix.multiply(a, b);
		System.out.println(Matrix.toString(c));
		assertEquals(14, c[0], 0);
		assertEquals(32, c[1], 0);
		assertEquals(2, c.length);
	}

	@Test
	public void testMultiplySingleByDouble() {
		double[] a = {1,2,3};
		double[][] b = { {1,2,3}, {4, 5,6 }, {7,8,9} };
		
		double[] c = Matrix.multiply(a, b);
		System.out.println(Matrix.toString(c));
		assertEquals(30, c[0], 0);
		assertEquals(36, c[1], 0);
		assertEquals(42, c[2], 0);
		assertEquals(3, c.length);
	}
	
	@Test 
	public void testTranslate() 
	{
		
		double[][] t = Matrix.translation(1, 2);
		double[] point ={1,1,1};
		System.out.println("Translate\n" + Matrix.toString(point) + " by (1,2)\n");
		point = Matrix.multiply(t, point);
		System.out.println("___________\n" + Matrix.toString(point));
		
		assertEquals(point[0], 2, 0);
		assertEquals(point[1], 3, 0);
	}
	@Test 
	public void testScale() 
	{
		
		double[][] t = Matrix.scale(2, 2);
		double[] point ={1,1,1};
		point = Matrix.multiply(t, point);
		System.out.println(Matrix.toString(point,2));
		
		assertEquals(point[0], 2, 0);
		assertEquals(point[1], 2, 0);
		
	}
	@Test
	public void testRotate()
	{
		double[][] t = Matrix.rotation(90);
		double[] point ={0,1,1};
		point = Matrix.multiply(t, point);
		assertEquals( 1,DapperUtil.round(point[0],2), 0);
		assertEquals(0,DapperUtil.round(point[1],2),0);
		point = Matrix.multiply(Matrix.rotation(180), point);
		assertEquals(-1,DapperUtil.round(point[0],2), 0);
		assertEquals(0,DapperUtil.round(point[1],2),0);
		

	}
}
