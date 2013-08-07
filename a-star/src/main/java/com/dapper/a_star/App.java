package com.dapper.a_star;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dapper.engine.DapperEngine;

/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
    	ApplicationContext ctx = new AnnotationConfigApplicationContext(AStarConfig.class);
    	
    	DapperEngine engine = ctx.getBean(DapperEngine.class);    	
        engine.start();
    }
}
