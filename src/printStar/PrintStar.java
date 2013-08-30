package printStar;

public class PrintStar 
{

	public static void printStar(int m,int max)
	{
		if(m>max)
			return;
		
		for(int i=1;i<=m;i++)
			System.out.print("*");
		System.out.println();
		printStar(m+1,max);
		
		for(int j=m-1;j>=1;j--)
			System.out.print("*");
		System.out.println();
	}
	
	public static void main(String[] args) 
	{
		printStar(1,5);
	}
}
