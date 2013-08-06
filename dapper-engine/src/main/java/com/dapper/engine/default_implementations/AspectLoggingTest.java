package com.dapper.engine.default_implementations;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectLoggingTest {

	@Pointcut(
			"execution(* com.dapper.engine.data.interfaces.DapperGameEngineInterface.start(..))") 
	public void dapperGameEngineStart() { }
	

	
	@Pointcut(
			"execution(* com.dapper.engine.data.interfaces.DapperGameEngineInterface.init(..))") 
	public void dapperGameEngineInit() { }	
	
	@Pointcut(
			"execution(* com.dapper.engine.data.interfaces.DapperGameEngineInterface.dispose(..))") 
	public void dapperGameEngineDispose() { }
	
	@Before("dapperGameEngineDispose()") 
	public void beforeGameEngineDispose() {
		System.out.println("AoP: Game Engine Disposing");
	}
	
	@Before("dapperGameEngineInit()") 
	public void beforeGameEngineInit() {
		System.out.println("AoP: Game Engine Initializing");
	}
	
	@Pointcut(
			"execution(* com.dapper.engine.data.interfaces.DapperGameEngineInterface.reshape(..))") 
	public void dapperGameEngineReshape() { }
	
	@Before("dapperGameEngineReshape()") 
	public void beforeGameEngineReshape() {
		System.out.println("AoP: Game Engine Reshaping");
	}
	
	@Before("dapperGameEngineStart()") 
	public void beforeGameEngineStart() {
		System.out.println("AoP: Game Engine Starting");
	}
	
}
