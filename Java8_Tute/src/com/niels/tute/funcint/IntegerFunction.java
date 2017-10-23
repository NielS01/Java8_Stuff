package com.niels.tute.funcint;

@FunctionalInterface
public interface IntegerFunction {
	Integer doSomething(Integer x, Integer y);
	
	// Integer doSomething2(Integer x, Integer y); // this will cause a compiler error because of @FunctionalInterface
}
