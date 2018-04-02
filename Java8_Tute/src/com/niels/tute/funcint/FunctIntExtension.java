package com.niels.tute.funcint;

import java.util.function.IntUnaryOperator;

// Here we extend IntUnaryOperator for the purpose of being able
// to throw an exception in it's applyAsInt() method - not possible
// with a lambda
public class FunctIntExtension  implements IntUnaryOperator {

	@Override
	public int applyAsInt(int operand) throws ArrayIndexOutOfBoundsException{
		// TODO Auto-generated method stub
		return 0;
	}

}
