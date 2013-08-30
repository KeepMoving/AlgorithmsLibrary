package sort;

public class Convention 
{
	/** 
	 * 求两数的最大公约数 
	 */  
	int divisor(int m,int n)
	{   
		if(m%n==0){  
			return n;  
		}else{  
			return divisor(n,m%n);  
		}  
	} 
	
	/** 
	 * 求两数的最小公倍数 
	 */  
	int gbs(int a,int b)
	{  
		int gbs = 0;  
		gbs = a*b/divisor(a,b);  
		return gbs;  
	}  
}
