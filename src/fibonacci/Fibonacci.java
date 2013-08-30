package fibonacci;

public class Fibonacci 
{
	public static void main(String[] args) 
	{
		int[] fib = new int[20];
		
		fib[0] = 0;
		fib[1] = 1;
		
		for(int i= 2;i<fib.length;i++)
			fib[i] = fib[i-1] + fib[i-2];
	
		for(int i = 0;i<fib.length;i++)
			System.out.print(fib[i] + " ");
		
		System.out.println();
	}
}
