package antGame;

public class AntGame 
{
	public static void main(String[] args) 
	{
		int m = 6;
		AntMap antMap = new AntMap(m);
		Ant ant = new Ant(antMap);
		Position curPos = new Position();
		int count = 1;
		while(count<=m*m)
		{
			ant.action(curPos, count++);
		}
		
		antMap.print();
	}
}
