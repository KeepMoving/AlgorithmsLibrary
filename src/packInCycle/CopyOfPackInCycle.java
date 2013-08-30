package packInCycle;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class CopyOfPackInCycle 
{
	//创建一个主函数   
	public static void main(String[] args)
	{   
		try {
			System.out.print("请输入矩阵边长：N=");
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
			final int num = Integer.parseInt(in.readLine());
			
			System.out.println("num = " + num);
			EventQueue.invokeLater(new Runnable()
			{
				public void run()
				{
					JFrame frame = new MyTableFrame(num);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				}
			});
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("NumberFormatException:" + e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException:" + e.getMessage());
		}
		

	}   
}

class MyTableFrame extends JFrame
{
	public MyTableFrame(Integer N)
	{
		setTitle("螺旋打印数组");
		setSize(N*40,N*40);
		FlowLayout fly = new FlowLayout();
		this.setLayout(fly);
		
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
		this.add(table);   
		//关闭窗体时退出程序   
		this.setDefaultCloseOperation(3);   
		//设置窗体出现时的位置   
		this.setLocationRelativeTo(null);   
		//将窗体设置为可见   
		this.setVisible(true);   

		
		//得到表格模型对象   
		TableModel tablemodel = table.getModel();   
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
			if(data==null||table==null)
			{
				System.out.println("出错");
				break;
			}
			
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
	
	private static JTable table;
	private static MyModel model;
}
