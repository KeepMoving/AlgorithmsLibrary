package rankMultiplies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RankMultiplies 
{
	public static int getRankMultiplies(int num)
	{
		if(num==1)
			return 1;
		else
			return num*getRankMultiplies(num-1);
	}
	
	public static int getResult(int end)
	{
		int result = 0;
		for(int index = 1;index<=end;index++)
		{
			result += getRankMultiplies(index);
		}
		
		return result;
	}
	
	public static void main(String[] args) 
	{
		String inputData = "";
		try {
			System.out.print("请输入最大阶乘数:");
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
			inputData = in.readLine();
		} catch (IOException e) {
			System.out.println("IOException:" + e.getMessage());
		}
		
		System.out.println();
		System.out.println("得到结果为：" + getResult(Integer.parseInt(inputData)));
	}
}


