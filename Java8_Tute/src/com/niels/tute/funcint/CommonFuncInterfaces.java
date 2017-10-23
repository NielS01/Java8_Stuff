package com.niels.tute.funcint;

import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;

public class CommonFuncInterfaces {

	public static void main(String[] args) {
		// Predicate<t>
		IntPredicate intPred = (int t) -> t > 0;
		int x = 7;
		System.out.println(String.format("%d is greater than 0:%b", x, intPred.test(x)));
		
		// UnaryOperater<T>
		x = 5;
		IntUnaryOperator intOp = (int t) -> t + t;
		IntUnaryOperator intOp2 = (int t) -> t - 1;
		int result = intOp.andThen(intOp2).applyAsInt(x); // intOp is evaluated first then intOp2
		System.out.println(result);
		
		IntegerFunction intFunc = (Integer c, Integer d) -> c + d;
		Integer y = 6;
		String str = String.format("intFunct(%d,%d)=%d", x, y, intFunc.doSomething(x, y));
		System.out.println(str);
		
		
	}
}
