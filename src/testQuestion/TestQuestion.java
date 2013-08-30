package testQuestion;

import java.util.Iterator;
import java.util.TreeSet;

public class TestQuestion 
{   
	private String[] b = new String[]{"1", "2", "2", "3", "4", "5"};   
	private int n = b.length;   
	private boolean[] visited = new boolean[n];
	private int[][] a = new int[n][n];   
	private String result = "";   
	private TreeSet TreeSet = new TreeSet();   
	
	public static void main(String[] args) 
	{   
		new TestQuestion().start();   
	}  
	
	private void start() 
	{   
		for (int i = 0; i < n; i++)
		{   
			for (int j = 0; j < n; j++) 
			{   
				if (i == j) {   
					a[i][j] = 0;   
				} else {   
					a[i][j] = 1;   
				}   
			}   
		}
		a[3][5] = 0;   
		a[5][3] = 0;   
		for (int i = 0; i < n; i++)
		{   
			this.depthFirstSearch(i);   
		}  
		
		Iterator it = TreeSet.iterator();   
		while (it.hasNext()) 
		{   
			String string = (String) it.next();   
	  
			if (string.indexOf("4") != 2) 
			{   
				System.out.println(string);   
			}   
		}   
	}   
	
	private void depthFirstSearch(int startIndex)
	{   
		visited[startIndex] = true;   
		result = result + b[startIndex];   
		if (result.length() == n)
		{   
			TreeSet.add(result);   
		}   
		
		for(int j = 0; j < n; j++) 
		{   
			if (a[startIndex][j] == 1 && visited[j] == false)
			{   
				depthFirstSearch(j);   
			} else {   
				continue;   
			}   
		}   
		
	    result = result.substring(0, result.length() -1);   
	    visited[startIndex] = false;   
	}   
}  

