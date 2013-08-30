package segment;

import java.util.ArrayList;

public class TransTool {
	public int inSegment(String src,String des)
	{
		String[] tempSrc = src.split("/");
		String[] tempDes = des.split("/");
		double src1 = Double.parseDouble(tempSrc[0]);
		double src2 = Double.parseDouble(tempSrc[1]);
		double des1 = Double.parseDouble(tempDes[0]);
		double des2 = Double.parseDouble(tempDes[1]);
		if(src1>=des1&&src2<=des2){
			return 0;
		}else if(src1<des1&&src2>des2){
			return 1;
		}else if(src1<des1&&src2<des2){
			return 2;
		}else if(src1>des1&&src2>des2){
			return 3;
		}
		return -1;
	}
	
	public ArrayList<String> mergeResult(ArrayList<String> resList)
	{
		ArrayList<String> res = new ArrayList<String>();
		int size = resList.size();
		String[] preStr;
		String[] nextStr;
		double preStrStart;
		double preStrEnd;
		double nextStrStart;
		double nextStrEnd;
		
		res.add(resList.get(0));
		for(int i = 1;i<size;i++)
		{
			preStr = res.get(res.size()-1).split("/");
			nextStr = resList.get(i).split("/");
			preStrStart = Double.parseDouble(preStr[0]);
			preStrEnd = Double.parseDouble(preStr[1]);
			nextStrStart = Double.parseDouble(nextStr[0]);
			nextStrEnd = Double.parseDouble(nextStr[1]);
			if(preStrEnd == nextStrStart)
			{
				res.remove(res.size()-1);
				res.add(preStrStart + "/" + nextStrEnd);
			}else{
				res.add(resList.get(i));
			}
		}
		
		return res;
	}
	
	public void printRes(ArrayList<String> res)
	{
		System.out.println("------------------------------------\n得到结果：");
		String[] temp;
		for(String obj:res)
		{
			temp = obj.split("/");
			System.out.print("(" + temp[0] + "," + temp[1] + ") ");
		}
	}
}
