package sort;

import java.util.Arrays;
import java.util.Collections;

public class CollectionsSortTest 
{
	public static void main(String[] args)
	{
        // TODO Auto-generated method stub
        
        Integer[] num = {5,8,3,9,1};
        //double[] num = {4.4,2.9,6.3};  //不可以
        //Double[] num = {4.4,2.9,6.3};  //可以
        Arrays.sort(num,Collections.reverseOrder()); //对整形数组按降序排序
        for(int i=0;i<num.length;i++){
            System.out.println(num[i]);
        }  
	}
}
