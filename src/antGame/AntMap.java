package antGame;

public class AntMap 
{
	private int size;
	int[][] matrix;
	
	AntMap(int size)
	{
		this.size = size;
		matrix = new int[size][size];
	}

	public int getSize() 
	{
		return this.size;
	}
	
	void print()
	{
		for(int i=0;i<size;++i)
		{
			for(int j =0;j<size;j++)
			{
				System.out.format("%d", matrix[i][j]);
			}
			System.out.println();
		}
	}
}
