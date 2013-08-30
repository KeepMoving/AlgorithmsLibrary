import java.util.Scanner;


public class Sum1s 
{
	
	
	public static void main(String[] args) 
	{
		Scanner keyboard  = new Scanner(System.in);
		int data = keyboard.nextInt();
		int result = sum1s(data);
		System.out.println("result = " + result);
	}
	
	public static int sum1s(int n)
	{
		int iCount = 0;
		int iFactor = 1;
		
		int iLowerNum = 0;
		int iCurrNum = 0;
		int iHigherNum = 0;
		
		while(n/iFactor != 0)
		{
			iLowerNum = n - (n/iFactor)*iFactor;
			iCurrNum = (n/iFactor)%10;
			iHigherNum = n / (iFactor*10);
			
			switch (iCurrNum) 
			{
				case 0:
					iCount += iHigherNum * iFactor;
					break;
				case 1:
					iCount += iHigherNum * iFactor + iLowerNum + 1;
					break;
				default:
					iCount += (iHigherNum + 1)*iFactor;
					break;
			}
			
			iFactor *= 10;
		}
		return iCount;
	}
}
