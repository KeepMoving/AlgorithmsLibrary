package keyWordSubString2nd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import keyWordSubString.ElementOperationInList;

public class Function 
{
	public static void main(String[] args) 
	{
		String loop = "N";
		do{
			try {
				System.out.println("请输入包含M个单词的英文描述，用空格隔开:");
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
				inputData = in.readLine();
			} catch (IOException e) {
				System.out.println("IOException:" + e.getMessage());
			}
			
			System.out.println("-----------------------------------");
			try {
				System.out.println("请输入包含N个单词的英文关键词，用空格隔开:");
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
				inputKeyWords = in.readLine();
			} catch (IOException e) {
				System.out.println("IOException:" + e.getMessage());
			}
	
			String[] inputDataArray = inputData.split(" ");
			String[] inputKeyWordsArray = inputKeyWords.split(" ");
			int keyWordsLength = inputKeyWordsArray.length;
			int i = 0;
			for(String targetword:inputDataArray)
			{
				if(indexList.size() >= keyWordsLength){
					break;
				}else{
					for(String keyword:inputKeyWordsArray)
					{
						if(targetword.matches(keyword)){
							if(indexList.isEmpty()){
								indexList.add(inputDataArray[i]+ "/" + i);
							}else{
								elementOperationInList.setTargetList(indexList);
								tempIndex = elementOperationInList.getElementFromList(inputDataArray[i]+"/"+i);
								
								if(tempIndex >= 0){
									System.out.println("删除的元素为：" + indexList.remove(tempIndex));
									indexList.add(inputDataArray[i] + "/" + i);
								}else{
									indexList.add(inputDataArray[i] + "/" + i);
								}
							}
						}
					}
				}
				i++;
			}
			
			int startIndex = 0;
			int endIndex = 0;
			
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
			
			System.out.println("---------------------------------------");
			System.out.println("继续吗？(Y/N)");
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
				loop = in.readLine();
			} catch (IOException e) {
				System.out.println("IOException:" + e.getMessage());
			}
		}while(loop.endsWith("Y")|| loop.endsWith("y"));
		System.out.println("游戏结束！");
	}
	
	private static ArrayList<String> indexList = new ArrayList<String>();
	private static ElementOperationInList elementOperationInList = new ElementOperationInList();
	private static int tempIndex;
	private static String inputData = ""; 
	private static String inputKeyWords = ""; 
}
