package prefixSorting;

import java.util.Stack;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestStackOperation {

	@Test
	public void testGetMaxNumFromStack() {
		Stack<Integer> dataStack = new Stack<Integer>();
		dataStack.push(2);
		dataStack.push(34);
		dataStack.push(56);
		dataStack.push(12);
		dataStack.push(7);
		dataStack.push(23);
		dataStack.push(45);
		dataStack.push(32);
		dataStack.push(9);
		
		StackOperation stackOperation = new StackOperation();
		int res = stackOperation.getMaxNumFromStack(dataStack, 9);
		System.out.println(dataStack.pop());
		assertEquals(56,res);
	}

}
