package com.dapper.engine.data.default_implementations;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.dapper.engine.data.objects.DapperObject;
import com.dapper.engine.data.objects.SimpleShape;

@Component
public class DefaultScene {
	public Map<Integer, DapperObject> sceneContents;	
	DefaultScene() {
		sceneContents = new HashMap<Integer, DapperObject>();
	}
	
	public void add(DapperObject obj) {
		sceneContents.put(obj.id, obj);
	}
	
	public Collection<DapperObject> getDisplayScene() {
		return (Collection<DapperObject>) sceneContents.values();
		
	}
}
