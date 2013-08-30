import java.util.ArrayList;
import java.util.Scanner;


public class CycleNFromS
{
	public CycleNFromS(String from,int times)
	{
		this.N = times;
		this.S = from;
	}
	
	public static void  main(String[] args)
	{
		System.out.println("请按先后顺序输入初始值以及循环次数，并以空格隔开");
		Scanner scanner = new Scanner(System.in);
		String[] data = scanner.nextLine().split(" ");
		String from = data[0];
		int times = Integer.parseInt(data[1]);
		
		CycleNFromS initObj = new CycleNFromS(from,times);
		finalResList = initObj.equipResult(S);
		for(String str:finalResList)
		{
			System.out.print(str + " ");
		}
	}
	
	public int getStringLength(String sourceStr)
	{
		return  sourceStr.length();
	}
	
	public int stringToInteger(String sourceStr)
	{
		return Integer.parseInt(sourceStr);
	}
	
	/**
	 * @param sourceStr
	 * @return
	 */
	public ArrayList<String> equipResult(String sourceStr)
	{
		int length = sourceStr.length();
		Integer indexNum = Integer.parseInt(sourceStr);
		ArrayList<String> resList = new ArrayList<String>();
		Integer nextNum = 0; 
		for(int i = 0; i < N;i++)
		{
			String preResult = "";
			nextNum = indexNum + i;
			if(nextNum.toString().indexOf("4") >= 0)
			{
				N++;
				continue;
			}else{
				for(int index = length-indexNum.toString().length();index >0;index--)
				{
					preResult += "0";
				}
				resList.add(preResult + nextNum);
			}
		}
		
		return resList;
	}
	
	private static ArrayList<String> finalResList;
	private static String S = "000003";
	private static int N = 10;
}
