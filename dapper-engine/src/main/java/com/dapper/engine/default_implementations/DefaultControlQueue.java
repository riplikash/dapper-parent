package com.dapper.engine.default_implementations;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import org.springframework.stereotype.Component;
@Component
public class DefaultControlQueue {
	Queue<Short> controlQueue;
	public DefaultControlQueue()
	{
		controlQueue = new LinkedList<Short>();
	}
	
	public Short remove() {
		return controlQueue.remove();
	}
	
	public void add(Short i) {
		controlQueue.add(i);
		
	}
	
	public int size() {
		return controlQueue.size();
	}
	
	public boolean isEmpty() {
		return controlQueue.isEmpty();
	}
	
	public Iterator iterator() {
		return controlQueue.iterator();
	}
}
