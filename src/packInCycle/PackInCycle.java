package packInCycle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PackInCycle 
{
	//创建一个主函数   
	public static void main(String[] args)
	{   
		try {
			System.out.print("请输入矩阵边长：N=");
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
			N = Integer.parseInt(in.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException:" + e.getMessage());
		}
		
		//创建一个登录对象   
		PackInCycle lg = new PackInCycle();   
		//调用其中的方法   
		try {
			lg.UI();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception:" + e.getMessage());
		}   
	}   
	
	public void UI() throws Exception
	{   
		//先创建一个窗体   
		javax.swing.JFrame jf = new javax.swing.JFrame("螺旋打印数组");   
		  
		//设置窗体的大小   
		jf.setSize(N*40, N*40); 
		
		//创建一个流式布局管理器   
		java.awt.FlowLayout fl = new java.awt.FlowLayout();   
		jf.setLayout(fl);   
		 
		//创建一个表格对象   
		table = new javax.swing.JTable();   
		  
		//创建一个表格模型对象   
		model = new MyModel(N);   
		  
		//将表格模型加到表格对象中   
		table.setModel(model);   
		  
		//设置表格的高度   
		table.setRowHeight(30);   

		//逐一设置宽度   
		for(int col=0;col<table.getColumnCount();col++)
		{   
			//得到表格列对象   
			javax.swing.table.TableColumn tablecol = table.getColumnModel().getColumn(col);   
			tablecol.setPreferredWidth(30);   
		}   
		
		//将表格添加到窗体中   
		jf.add(table);   
		//关闭窗体时退出程序   
		jf.setDefaultCloseOperation(3);   
		//设置窗体出现时的位置   
		jf.setLocationRelativeTo(null);   
		//将窗体设置为可见   
		jf.setVisible(true);   

		
		//得到表格模型对象   
		javax.swing.table.TableModel tablemodel = table.getModel();   
		//强制转化为MyModel对象   
		MyModel myModel = (MyModel)tablemodel; 
		
		
		String[][] data = myModel.GetData();
		int tableRow = myModel.getRowCount();
		int tableColumn = myModel.getColumnCount();
		for(int i=0;i<tableRow;i++)
		{
			for(int j=0;j<tableColumn;j++)
			{
				data[i][j] = "0";
			}
		}
		
		int row = 0;
		int column = 0;
		data[row][column] = "1";
		String dir = "R";
		table.updateUI();
		
		int loopNum = N*N;
		System.out.println("loopNum=" + loopNum);
		for(Integer num=2; num<=loopNum; num++)
		{
			//得到MyModel中的二维数组   
			data = myModel.GetData();
			
			if(dir.equalsIgnoreCase("R")){
				if(row<0 || row==tableRow || column<0 || column+1==tableColumn || data[row][column+1] != "0")
				{
					dir = "D";
					num--;
				}else{
					System.out.println("rrrrrrrrrrrrrrrrrrr");
					data[row][column+1] = num.toString();
					column++;
					table.updateUI();
				}
			}else if(dir.equalsIgnoreCase("D")){
				if(row<0 || row+1==tableRow || column<0 || column==tableColumn || data[row+1][column] != "0")
				{
					dir = "L";
					num--;
				}else{
					System.out.println("ddddddddddddddddddd");
					data[row+1][column] = num.toString();
					row++;
					table.updateUI();
				}
			}else if(dir.equalsIgnoreCase("L")){
				if(row<0 || row==tableRow || column-1<0 || column==tableColumn || data[row][column-1] != "0")
				{
					dir = "T";
					num--;
				}else{
					System.out.println("lllllllllllllllllll");
					data[row][column-1] = num.toString();
					column--;
					table.updateUI();
				}
			}else if(dir.equalsIgnoreCase("T")){
				if(row-1<0 || row==tableRow || column<0 || column==tableColumn || data[row-1][column] != "0")
				{
					dir = "R";
					num--;
				}else{
					System.out.println("ttttttttttttttttttt");
					data[row-1][column] = num.toString();
					row--;
					table.updateUI();
				}
			}
			table.updateUI();
		}
	}   
	
	private static Integer N;
	private static javax.swing.JTable table;
	private static MyModel model;
}
