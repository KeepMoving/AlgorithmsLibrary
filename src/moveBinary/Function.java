package moveBinary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Function 
{
	public static void main(String[] args) 
	{
		System.out.println("请输入n位二进制数");
		String inputData = "";
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
			inputData = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("-----------------------------------");
		int size = inputData.length();
		inputData += inputData;
		System.out.println("得到"+size+"位数字，输出"+size+"位偏移数如下：");
		TreeSet<String> dataTree = new TreeSet<String>();
		for(int index = 0;index<size;index++)
		{
			System.out.println(inputData.substring(index, index+size));
			dataTree.add(inputData.substring(index, index+size));
		}
		
		System.out.println("-----------------------------------");
		System.out.println("得到集合如下:");
		System.out.println(dataTree);
		
		System.out.println("-----------------------------------");
		System.out.println("得到结果如下");
		for(String temp:dataTree)
		{
			System.out.print(temp.charAt(size-1));
		}
	}
}
