package numFill;

public class NumFill {
	  
    public static int number = 4;  
    public static int circleNum = (number+1)/2;  
      
    public static int getCircle(int i, int j)  
    {  
        int c = 1;  
          
          
        if(i>circleNum) i = number+1-i;  
        if(j>circleNum) j = number+1-j;  
        c= (i<j?i:j);  
          
        return c;  
    }  
      
    public static int getLastNumber(int nCircle)  
    {  
        int ln = 0;  
        for ( int i = 1 ; i<=nCircle ; i=i+1)  
        {  
            int numPerCircle = number - 2*(nCircle-i);  
            ln = ln + 4*(numPerCircle -1);  
        }  
        return  ln;  
    }  
      
    public static int getSequence(int i, int j, int nCircle)  
    {  
        int s = 0;  
        int numPercircle = number - (nCircle-1)*2;  
        if(i == nCircle )  
        {  
            s = j-nCircle+1;  
        }  
        else if(j == nCircle )  
        {  
            //s = 3*(number-1)+number+nCircle-i;  
            s = 4*numPercircle+nCircle-3-i;  
        }  
        else if(nCircle == (number+1-j) )  
        {  
            s = numPercircle + i + 1 - nCircle-1;  
        }         
        else if(nCircle == (number+1-i) )  
        {  
            //s = 2*(number-1)+number+1-j  
            s = 3*numPercircle-2+nCircle-j;  
        }  
          
        return s;  
    }  
      
    public static int getNumber(int i, int j)  
    {  
        int n = 0;  
        int nCircle = getCircle(i,j);  
        int firstNum = getLastNumber(nCircle-1)+1;  
        n = firstNum + getSequence(i,j,nCircle)-1;  
        return n;  
    }  
      
    public static void printCircle()  
    {  
        for(int i = 0 ; i < number ; i++)  
        {  
            for(int j = 0 ; j < number ; j++)  
            {  
                System.out.print(getNumber(i+1,j+1));  
                System.out.print('\t');  
            }  
            System.out.println('\n');  
        }  
    }  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        try  
        {  
            if(args.length==1)   
            {  
                number = Integer.parseInt(args[0]);  
                circleNum = (number+1)/2;  
            }  
        }  
        catch(Exception e){};  
        NumFill.printCircle();  
    }  
}
