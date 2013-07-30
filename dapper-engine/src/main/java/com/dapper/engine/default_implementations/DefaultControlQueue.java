package com.dapper.engine.default_implementations;

import java.util.LinkedList;
import java.util.Queue;

public class DefaultControlQueue {
	Queue<Short> queue;
	public void init() 
	{
		queue = new LinkedList<Short>();
		
	}	
	public void add(short i) { queue.add(i); }
	public short get() { return queue.remove(); }	
	
}
