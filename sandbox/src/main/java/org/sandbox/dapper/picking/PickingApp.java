package org.sandbox.dapper.picking;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dapper.engine.DapperEngine;

public class PickingApp {
    public static void main( String[] args )
    {
    	ApplicationContext ctx = new AnnotationConfigApplicationContext(PickingConfig.class);
    	
    	DapperEngine engine = ctx.getBean(DapperEngine.class);    	
        engine.start();
    }
}
