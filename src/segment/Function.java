package segment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Function 
{
	public static void main(String[] args) 
	{
		System.out.println("请输入多组线段参数，比如2/3，代表(2,3),中间用空格分开:");
		String data = "";
		try {
			System.out.println("请输入包含M个单词的英文描述，用空格隔开:");
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
			data = in.readLine();
		} catch (IOException e) {
			System.out.println("IOException:" + e.getMessage());
		}
		String[] inputData = data.split(" ");
		ArrayList<String> dataList = new ArrayList<String>(); //得到原始数列dataList
		for(String obj:inputData)
		{
			dataList.add(obj);
		}
		CountArea countArea = new CountArea();
		ArrayList<Double> doubleList = countArea.getArea(dataList); //得到一个从小到大的Double数列doubleArray
		ArrayList<String> segList = countArea.getSegment(doubleList); //得到从小到大的各个分段
//		double[][] doubleArray = countArea.transToArray(dataList); //得到一个double型的二维数组,第一列是原始线段起始点，第二列是原始线段结束点

		TransTool transTool = new TransTool();
		ArrayList<String> resList = new ArrayList<String>();
		int inCount;
		for(String src:segList)
		{
			inCount = 0;
			for(String des:dataList)
			{
				if(transTool.inSegment(src, des) == 0)
				{
					inCount++;
				}
			}
			if(inCount >1){
				resList.add(src);
			}
		}
		ArrayList<String> res = transTool.mergeResult(resList);
		transTool.printRes(res);
	}
}

