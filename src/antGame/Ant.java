package antGame;

public class Ant 
{
	AntMap map = null;
	Action curAction = Action.DOWN;
	
	public Ant(AntMap map)
	{
		this.map = map;
	}
	
	void action(Position pos,int count)
	{
		map.matrix[pos.row][pos.col] = count;
		
		if(shouldTurn(pos))
		{
			turn();
		}
		
		if(curAction == Action.FORWARD){
			forward(pos);
		}else if(curAction == Action.DOWN){
			down(pos);
		}else if(curAction == Action.BACKWARD){
			backward(pos);
		}else if(curAction == Action.UP){
			up(pos);
		}
	}
	
	private boolean shouldTurn(Position pos)
	{
		int min = 0;
		int max = map.getSize() - 1;
		
		if(curAction == Action.FORWARD)
		{
			if(pos.col >= max){
				return true;
			}else if(map.matrix[pos.row][pos.col + 1]>0){
				return true;
			}
		}else if(curAction == Action.DOWN){
			if(pos.row >= max){
				return true;
			}else if(map.matrix[pos.row+1][pos.col]>0){
				return true;
			}
		}else if(curAction == Action.BACKWARD){
			if(pos.row <= min){
				return true;
			}else if(map.matrix[pos.row - 1][pos.col] > 0){
				return true;
			}
		}
		
		return false;
	}
	
	private void turn()
	{
		if(curAction == Action.FORWARD){
			curAction = Action.UP;
		}else if(curAction == Action.DOWN){
			curAction = Action.FORWARD;
		}else if(curAction == Action.BACKWARD){
			curAction = Action.DOWN;
		}else if(curAction == Action.UP){
			curAction = Action.BACKWARD;
		}
	}
	
	private void forward(Position pos)
	{
		if(pos != null){
			pos.col++;
		}
	}
	
	private void backward(Position pos)
	{
		if(pos != null){
			pos.col--;
		}
	}
	
	private void up(Position pos)
	{
		if(pos != null){
			pos.row--;
		}
	}
	
	private void down(Position pos)
	{
		if(pos != null){
			pos.row++;
		}
	}
}


