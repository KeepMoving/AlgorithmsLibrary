package packInCycle;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class MyModel implements TableModel 
{	
	public MyModel(int num)
	{
		//创建一个二维数组,用于存放数据   
		this.data = new String[num][num]; 
	}
	
	//取得数组的方法 
	public String[][] GetData()
	{   
		return data;   
	} 
	
	public void addTableModelListener(TableModelListener l) 
	{
	}

	public Class<?> getColumnClass(int columnIndex) 
	{
		//返回的数据类型   
		return String.class;
	}

	public int getColumnCount() 
	{
		return data[0].length;
	}

	public String getColumnName(int columnIndex) 
	{
		return "第" + columnIndex + "列";
	}

	public int getRowCount() 
	{
		return data.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) 
	{
		String str = data[rowIndex][columnIndex];   
		return str; 
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) 
	{
		return false;
	}

	public void removeTableModelListener(TableModelListener l) 
	{
	}

	public void setValueAt(Object value, int rowIndex, int columnIndex) 
	{
		data[rowIndex][columnIndex]=(String)value;
	}
	
	private String[][] data;
}
