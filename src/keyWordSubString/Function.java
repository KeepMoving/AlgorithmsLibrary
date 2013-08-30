package keyWordSubString;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Function 
{
	public static void main(String[] args) 
	{
		try {
			System.out.println("请输入包含M个单词的英文描述，用空格隔开:");
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
			inputData = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException:" + e.getMessage());
		}
		
		System.out.println("-----------------------------------");
		try {
			System.out.println("请输入包含N个单词的英文关键词，用空格隔开:");
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
			inputKeyWords = in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException:" + e.getMessage());
		}

//		System.out.println("-----------------------------------");
		String[] inputDataArray = inputData.split(" ");
		String[] inputKeyWordsArray = inputKeyWords.split(" ");
		int dataLength = inputDataArray.length;
		int keyWordsLength = inputKeyWordsArray.length;
//		System.out.println("////////////////////////////////////////////////////");
//		System.out.println("dataLength = " + dataLength + "; keyWordsLength = " + keyWordsLength);
		
		Comparator comparator = new Comparator();
		comparator.setStr(inputKeyWordsArray);
		
		int startIndex = 0;
		int endIndex = 0;
		
		for(int index = 0;index<dataLength;index++)
		{
			if(indexList.size() >= keyWordsLength){
				break;
			}else if(comparator.equaledWith(inputDataArray[index])){
				if(indexList.isEmpty()){
//					System.out.println("inputDataArray[index] = " + inputDataArray[index]+"/"+index);
					indexList.add(inputDataArray[index]+ "/" + index);
				}else{
					elementOperationInList.setTargetList(indexList);
//					System.out.println("inputDataArray[index] = " + inputDataArray[index]+"/"+index);
					tempIndex = elementOperationInList.getElementFromList(inputDataArray[index]+"/"+index);
					
//					System.out.println("/////////////////////////////////////////////");
//					System.out.println("tempIndex = " + tempIndex);
//					for(String obj:indexList)
//					{
//						System.out.println(obj);
//					}
//					System.out.println("tempIndex = " + tempIndex);
					
					if(tempIndex > 1){
						indexList.remove(tempIndex - 1);
						indexList.add(inputDataArray[index] + "/" + index);
					}else{
						indexList.add(inputDataArray[index] + "/" + index);
					}
				}
			}
		}
		
//		System.out.println("/////////////////////////////////////////////");
//		for(String obj:indexList)
//		{
//			System.out.println(obj);
//		}
		
		String[] startPoint = indexList.get(0).split("/");
		String[] endPoint = indexList.get(keyWordsLength - 1).split("/");
		startIndex = Integer.parseInt(startPoint[1]);
		endIndex = Integer.parseInt(endPoint[1]);
		
		String resultStr = "";
		for(int index = startIndex;index <= endIndex;index++)
		{
			resultStr += inputDataArray[index] + " ";
		}
		
		System.out.println("---------------------------------------");
		System.out.println("结果是:" + resultStr);
	}
	
	private static ArrayList<String> indexList = new ArrayList<String>();
	private static int tempIndex;
	private static ElementOperationInList elementOperationInList = new ElementOperationInList();
	private static int startIndex = 0;
	private static int endIndex = 0;
	private static String inputData = ""; 
	private static String inputKeyWords = ""; 
}
