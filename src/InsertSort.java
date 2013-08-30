import java.util.Random;
  
public class InsertSort {   
    /**  
     * 插入排序算法实现  
     * @author Jason  
     * @param arr  
     * @return  
     */  
    public static int[] insertSort(int[] arr) {   
        int searchCount = 0;   
        for (int out = 1; out < arr.length; out++) {   
            outPrint(arr);   
            if (arr[out]>arr[out-1]) {   
                continue;   
            }   
            //普通查找算法   
            /*for (int inn = 0; inn < out; inn++) {  
                searchCount++;  
                if (arr[out]<arr[inn]) {  
                    move(arr,out,inn);  
                    break;  
                }else {  
                    continue;  
                }  
            }*/  
            //使用二分查找算法找到要插入的位置   
            int start = 0;   
            int end = out - 1;   
            while (start <= end) {   
                searchCount++;   
                int searchIndex = (start + end) / 2;   
                if (arr[out] > arr[searchIndex]) {   
                    start = searchIndex + 1;   
                } else if (arr[out] < arr[searchIndex]) {   
                    if (searchIndex == 0  
                            || (searchIndex != 0 && arr[out] > arr[searchIndex - 1])) {   
                        move(arr, out, searchIndex);   
                        break;   
                    } else {   
                        end = searchIndex - 1;   
                        continue;   
                    }   
                } else {   
                    move(arr, out, searchIndex);   
                    break;   
                }   
            }   
        }   
        check(arr);   
        System.out.println("Search Count:" + searchCount);   
        return arr;   
    }   
    /**  
     * 移动数据  
     */  
    private static void move(int[] arr, int out, int inn) {   
        int changeTemp = arr[out];   
        for (int i = out; i > inn; i--) {   
            arr[i] = arr[i - 1];   
        }   
        arr[inn] = changeTemp;   
    }   
    /**  
     * 输出  
     */  
    private static void outPrint(int[] arr) {   
        System.out.println();   
        for (int i = 0; i < arr.length; i++) {   
            System.out.print(arr[i] + "|");   
        }   
    }   
    /**  
     * 结果检查  
     */  
    private static boolean check(int[] arr) {   
        System.out.println();   
        for (int i = 1; i < arr.length; i++) {   
            if (arr[i] < arr[i - 1]) {   
                System.out.println("Sort Error!");   
                return false;   
            }   
        }   
        System.out.println("Sort Success!");   
        return true;   
    }   
    /**  
     * 测试方法  
     * @param args  
     */  
    public static void main(String[] args) {   
        // TODO Auto-generated method stub   
        Random ran = new Random();   
        int[] arr = new int[60];   
        for (int i = 0; i < arr.length; i++) {   
            arr[i]=ran.nextInt(300000);   
        }   
        System.out.println("Befor sort:");   
        for (int i = 0; i < arr.length; i++) {   
            System.out.print(arr[i]+"|");   
        }   
        arr = InsertSort.insertSort(arr);   
        System.out.println("After sort:");   
        for (int i = 0; i < arr.length; i++) {   
            System.out.print(arr[i]+"|");   
        }   
           
    }   
} 

