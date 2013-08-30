package recursion;
/** 
 *递归算法，求n的阶乘 
 */  

public class Recursion 
{
	int result=1;  
	public int nRecursion(int n) 
	{       
		if (n > 0) 
		{           
			result = result * n;         
			nRecursion(n-1);       
		}   
		return result;  
	}   
}
