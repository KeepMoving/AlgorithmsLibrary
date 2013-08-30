package keyWordSubString;

import java.util.ArrayList;

public class ElementOperationInList 
{
	public int getElementFromList(String s)
	{
		sourceTemp = s.split("/");
		int index = 0;
		for(;index < targetList.size();index++)
		{
			targetTemp = targetList.get(index).split("/");
			if(sourceTemp[0].endsWith(targetTemp[0]))
				return index;
		}
		return -1;
	}
	
	public ArrayList<String> getTargetList() {
		return targetList;
	}

	public void setTargetList(ArrayList<String> targetList) {
		this.targetList = targetList;
	}
	
	private String[] targetTemp;
	private String[] sourceTemp;
	private ArrayList<String> targetList;
}
