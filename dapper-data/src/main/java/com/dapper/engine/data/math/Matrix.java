package com.dapper.engine.data.math;

public class Matrix {

	public static double[][] copy(double[][] m)
	{
		double[][] rt = new double[m.length][m[0].length];
		for (int i = 0; i < m.length; i++)
			for (int j = 0; j < m.length; j++)
			{
				rt[i][j] = m[i][j];
			}
		return rt;
	}
	
    // return a random m-by-n matrix with values between 0 and 1
    public static double[][] random(int m, int n) {
        double[][] C = new double[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = Math.random();
        return C;
    }

    // return n-by-n identity matrix I
    public static double[][] identity(int n) {
        double[][] I = new double[n][n];
        for (int i = 0; i < n; i++)
            I[i][i] = 1;
        return I;
    }

    // return x^T y
    public static double dot(double[] x, double[] y) {
        if (x.length != y.length) throw new RuntimeException("Illegal vector dimensions.");
        double sum = 0.0;
        for (int i = 0; i < x.length; i++)
            sum += x[i] * y[i];
        return sum;
    }

    // return C = A^T
    public static double[][] transpose(double[][] A) {
        int m = A.length;
        int n = A[0].length;
        double[][] C = new double[n][m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                C[j][i] = A[i][j];
        return C;
    }

    // return C = A + B
    public static double[][] add(double[][] A, double[][] B) {
        int m = A.length;
        int n = A[0].length;
        double[][] C = new double[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }

    // return C = A - B
    public static double[][] subtract(double[][] A, double[][] B) {
        int m = A.length;
        int n = A[0].length;
        double[][] C = new double[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] - B[i][j];
        return C;
    }

    // return C = A * B
    public static double[][] multiply(double[][] A, double[][] B) {
        int mA = A.length;
        int nA = A[0].length;
        int mB = B.length;
        int nB = B[0].length;
        if (nA != mB) throw new RuntimeException("Illegal matrix dimensions.");
        double[][] C = new double[mA][nB];
        for (int i = 0; i < mA; i++)
            for (int j = 0; j < nB; j++)
                for (int k = 0; k < nA; k++)
                    C[i][j] += (A[i][k] * B[k][j]);
        return C;
    }

    // matrix-vector multiplication (y = A * x)
    public static double[] multiply(double[][] A, double[] x) {
        int m = A.length;
        int n = A[0].length;
        if (x.length != n) throw new RuntimeException("Illegal matrix dimensions.");
        double[] y = new double[m];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                y[i] += (A[i][j] * x[j]);
        return y;
    }


    // vector-matrix multiplication (y = x^T A)
    public static double[] multiply(double[] x, double[][] A) {
        int m = A.length;
        int n = A[0].length;
        if (x.length != m) throw new RuntimeException("Illegal matrix dimensions.");
        double[] y = new double[n];
        for (int j = 0; j < n; j++)
            for (int i = 0; i < m; i++)
                y[j] += (A[i][j] * x[i]);
        return y;
    }
    
    public static String toString(double[][] a, int roundTo)
    {
    	String rt = "";
    	int height = a.length;
    	int width = a[0].length;
    	for (int y = 0; y < height; y++)
    	{
    		for (int x = 0; x < width; x++)
    		{
    			rt += DapperUtil.round(a[y][x], roundTo) + " ";
    		}
    		rt += "\n";
    	}
    	
    	return rt;
    	
    }

    public static String toString(double[][] a) {
    	String rt = "";
    	int height = a.length;
    	int width = a[0].length;
    	for (int y = 0; y < height; y++)
    	{
    		for (int x = 0; x < width; x++)
    		{
    			rt += a[y][x] + " ";
    		}
    		rt += "\n";
    	}
    	
    	return rt;
    	
    	
    }
    public static String toString(double[] a, int roundTo) {
    	String rt = "";
    	int width = a.length;

		for (int x = 0; x < width; x++)
		{
			rt += DapperUtil.round(a[x], roundTo) + " ";
		}

    	
    	return rt;
    	
    	
    }
    public static String toString(double[] a) {
    	String rt = "";
    	int width = a.length;

		for (int x = 0; x < width; x++)
		{
			rt += a[x] + " ";
		}	
    	return rt;
    }
    
    public static double[][] translation(double x, double y) {
    	return new double[][] {{1,0,x},{0,1,y},{0,0,1}};
    }
    
    public static double[][] scale(double x, double y) {
    	return new double[][] {{x,0,0},{0,y,0},{0,0,1}};
    }
    
    public static double[][] rotation(double deg) {
    	double rad = Math.toRadians(deg) * -1;

    	return new double[][] {
    			{Math.cos(rad), -Math.sin(rad), 0}, 
    			{Math.sin(rad), Math.cos(rad), 0}, 
    			{0,0,1}};
    }
    
    public static double[][] skew(double xAng, double yAng)
    {
    	xAng = Math.toRadians(xAng);
    	yAng = Math.toRadians(yAng);
    	return new double[][] {
    			{1,Math.tan(xAng),0},
    			{Math.tan(yAng),1,0},
    			{0,0,1}
    	};
    }


	public static double[][] new2DPosition(double x, double y, double scaleX,
			double scaleY, double rotation) {
		double[][] rt = identity(3);
		rt = multiply(rt, Matrix.translation(x, y));
		rt = multiply(rt, Matrix.scale(scaleX, scaleY));
		rt = multiply(rt, Matrix.rotation(rotation));
		return rt;
	}
    
  


}
