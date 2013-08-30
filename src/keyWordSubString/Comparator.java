package keyWordSubString;

public class Comparator
{
	public boolean equaledWith(String s)
	{
		for(String obj:str)
		{
			if(obj.endsWith(s))
				return true;
		}
		return false;
	}
	
	public String[] getStr() {
		return str;
	}

	public void setStr(String[] str) {
		this.str = str;
	}
	
	private String[] str;
}
