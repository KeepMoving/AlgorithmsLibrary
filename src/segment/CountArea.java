package segment;

import java.util.ArrayList;

public class CountArea 
{
	public ArrayList<Double> getArea(ArrayList<String> dataList)
	{
		String[] temp;
		for(String obj:dataList)
		{
			temp = obj.split("/");
			res.add(Double.parseDouble(temp[0]));
			res.add(Double.parseDouble(temp[1]));
		}
		res = this.sortList(res);
		return res;
	}
	
	//把数列从小到大排序
	public ArrayList<Double> sortList(ArrayList<Double> doubleList)
	{
		int length = doubleList.size();
		for(int index = 0;index<length;index++)
		{
			for(int j = 0;j<length - index - 1;j++)
			{
				if(doubleList.get(j) > doubleList.get(j + 1))
				{
					doubleList.add(j, doubleList.get(j + 1));
					doubleList.remove(j+2);
				}
			}
		}
		return doubleList;
	}
	
	public double[][] transToArray(ArrayList<String> dataList)
	{
		int size = dataList.size();
		double[][] data = new double[size][2];
		String[] temp;
		for(int i = 0;i < size;i++)
		{
			temp = dataList.get(i).split("/");
			data[i][0] = Double.parseDouble(temp[0]);
			data[i][1] = Double.parseDouble(temp[1]);
		}
		return data;
	}
	
	public ArrayList<String> getSegment(ArrayList<Double> doubleList)
	{
		ArrayList<String> arrayList = new ArrayList<String>();
		int length = doubleList.size();
		for(int i = 0;i < length-1;i++)
		{
			arrayList.add(doubleList.get(i)+"/"+doubleList.get(i+1));
		}
		return arrayList;
	}
	
	private static ArrayList<Double> res = new ArrayList<Double>();
}
