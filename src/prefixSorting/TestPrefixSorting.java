package prefixSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TestPrefixSorting 
{
	public static void main(String[] args) 
	{
		try {
			System.out.println("请输入一组整数，用空格隔开：");
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
			inputData = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("-----------------------------------");
		String[] dataArray = inputData.split(" ");
		dataCount = dataArray.length;
		System.out.println("dataCount = " + dataCount);
		
		Stack<Integer> dataStack = new Stack<Integer>();
		
		//装配
		for(int i = 0;i<dataCount;i++){
			dataStack.push(Integer.parseInt(dataArray[i]));
		}
		
		System.out.println("-----------------------------------运行中");
		for(int j = dataCount ;j >0;j--)
		{
			maxNum = stackOperation.getMaxNumFromStack(dataStack, j);
			maxIndex = dataCount - dataStack.indexOf(maxNum) - 1; //倒序排列
			
			System.out.println("-------------------------------------");
			System.out.println("maxIndex = " + maxIndex);
			System.out.println("-------------------------------------");
			
			for(int index = 0;index <= maxIndex;index++)
			{
				System.out.println(dataStack.peek() + " -> queueDataTemp");
				queueDataTemp.offer(dataStack.pop());
			}
			while(!queueDataTemp.isEmpty())
			{
				System.out.println("queueDataTemp -> " + queueDataTemp.peek() + " -> dataStack");
				dataStack.add(queueDataTemp.remove());
			}
			for(int index = 0;index < j;index++)
			{
				System.out.println("dataStack -> " + dataStack.peek() + " -> queueDataTemp");
				queueDataTemp.offer(dataStack.pop());
			}
			while(!queueDataTemp.isEmpty())
			{
				System.out.println("queueDataTemp -> " + queueDataTemp.peek() + " -> dataStack");
				dataStack.add(queueDataTemp.remove());
			}
		}
		
		System.out.println("-----------------------------------最终结果");
		while(!dataStack.isEmpty()){
			System.out.print(dataStack.pop() + " ");
		}
	}
	
	private static String inputData = ""; 
	private static int dataCount = 0;
	private static int maxNum;
	private static int maxIndex;
	private static Queue<Integer> queueDataTemp = new LinkedList<Integer>();
	private static StackOperation stackOperation = new StackOperation();
	
}
