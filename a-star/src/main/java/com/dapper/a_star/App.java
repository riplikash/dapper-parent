package com.dapper.a_star;

import org.springframework.beans.factory.annotation.Autowired;

import com.dapper.engine.DapperEngine;

/**
 * Hello world!
 *
 */
public class App 
{
	@Autowired
	static DapperEngine engine;
    public static void main( String[] args )
    {
        engine.start();
    }
}
