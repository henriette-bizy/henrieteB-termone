package com.learning.eveningClass.service;

import java.awt.dnd.InvalidDnDOperationException;

public interface MathOperator {
	double doMath(double operand1, double operand2, String operation) throws InvalidDnDOperationException;
}
