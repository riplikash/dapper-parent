package com.dapper.engine.data.math;

public class DapperUtil {
	  public static double round(double value, int places) {
	        if (places < 0) throw new IllegalArgumentException();

	        long factor = (long) Math.pow(10, places);
	        value = value * factor;
	        long tmp = Math.round(value);
	        System.out.println((double)tmp/factor);
	        return (double) tmp / factor;
	    }
}
