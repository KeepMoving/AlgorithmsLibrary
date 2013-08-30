package recursion;

public class RecursiveTest {  
    /** 
     * 递归实现 
     *  
     * @param n 
     * @return 
     */  
    public static double recursive(long n) {  
        if (n == 1) {  
            return Math.log(1);  
        } else {  
            return Math.log(n) + recursive(n - 1);  
        }  
    }  
  
    /** 
     * 非递归实现 
     *  
     * @param n 
     * @return 
     */  
    public static double directly(long n) {  
        double result = 0;  
        for (int i = 1; i <= n; i++) {  
            result += Math.log(i);  
        }  
        return result;  
    }  
  
    public static void main(String[] args) {  
        int i = 5000000;  
        long test = System.nanoTime();  
        long start1 = System.nanoTime();  
        double r1 = recursive(i);  
        long end1 = System.nanoTime();  
        long start2 = System.nanoTime();  
        double r2 = directly(i);  
        long end2 = System.nanoTime();  
  
        System.out.println("recursive result:" + r1);  
        System.out.println("recursive time used:" + (end1 - start1));  
        System.out.println("non-recursive result:" + r2);  
        System.out.println("non-recursive time used:" + (end2 - start2));  
    }  
}  
