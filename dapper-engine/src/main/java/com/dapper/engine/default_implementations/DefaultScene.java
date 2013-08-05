package com.dapper.engine.default_implementations;

import java.util.ArrayList;
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
	public Map<Integer, DapperObject> sceneMap;	
	public List<DapperObject> sceneList;
	public DefaultScene() {
		sceneMap = new HashMap<Integer, DapperObject>();
		sceneList = new ArrayList<DapperObject>();
	}
	
	public void add(DapperObject obj) {
		sceneMap.put(obj.id, obj);
		sceneList.add(obj);
	}
	
	public Collection<DapperObject> getDisplayScene() {
		return sceneList;
		
	}
}
