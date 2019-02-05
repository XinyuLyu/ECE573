package HW3_Q5;
import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class main {
	  public static void main(String[] args) { 
	        BST<Integer, Integer> st = new BST<Integer, Integer>();
	        int[] a = readTxtFile("E:\\Eclipse\\workspace\\HW3 DSA\\testdata.txt");//read txt file 
	        for (int i = 0; i<a.length; i++) {
	            st.put(a[i], 1);
	        }
	        int c=st.select(7);
	        int d=st.rank(7);
	        System.out.println("rank(7):"+d);
	        System.out.println("select(7):"+c);
	   }
	  public static int[] Shuffle(int []a) {    //shuffle the array cited from http://blog.csdn.net/mnmlist/article/details/51378132
	        int ranIndex=0;  
	        Random random = new Random();    
	        for (int i = 0; i <a.length; i++) {  
	            ranIndex = random.nextInt(a.length);  
	            swap(a, ranIndex, i);  
	        }  
	        return a;  
	    }   
	    private static void swap(int[] arr, int a, int b) {
	        int temp = arr[a];
	        arr[a] = arr[b];
	        arr[b] = temp;
	    }
	  public static int[] readTxtFile(String filePath)
	    {                                                 
	        try{
	            File f = new File(filePath);
	            Scanner s = new Scanner(f);
	            int ctr = 0;
	            while(s.hasNextInt())
	            {
	                ctr++;
	                s.nextInt();
	            }
	            int[] arr = new int[ctr];
	            Scanner s1 = new Scanner(f);
	            for (int i = 0; i < arr.length; i++)
	                arr[i] = s1.nextInt();
	            return arr;
	        }
	        catch(Exception e)
	        {
	            return null;
	        }
	    }
}
