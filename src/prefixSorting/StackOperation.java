package prefixSorting;

import java.util.Stack;

public class StackOperation {
	
	public int getMaxNumFromStack(Stack<Integer> dataStack , int depth)
	{
		int max = 0;
		Stack<Integer> dataStackCopy = (Stack<Integer>)dataStack.clone();
		for(int i = 0;i < depth;i++)
		{
			max = dataStackCopy.peek()>max?dataStackCopy.peek():max;
			dataStackCopy.pop();
		}
		return max;
	}
}
