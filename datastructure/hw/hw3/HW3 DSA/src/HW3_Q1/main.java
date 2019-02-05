package HW3_Q1;
import java.io.File;
import java.util.Random;
import java.util.Scanner;
public class main {
	 public static void main(String[] args) { 
		    RedBlackBST<Integer, Integer> st = new RedBlackBST<Integer, Integer>(); 
		    System.out.println("Test of the isempty function(the tree is null): "+st.isEmpty());
	        int N=1000;// set N to be 1000
		    int[] a = new int[N];// 
	        for(int i=0;i<a.length;i++)// sorted N input
	        {
	        	a[i]=i;
	        }
	     //   int []b=Shuffle(a);//random N input
	        for (int i = 0; i<a.length; i++) {
	            st.put(a[i], a[i]);// insert
	        }
	        System.out.println("Tree has been built.");
	        
	        System.out.println("Test of the built tree:");
	        if(st.is23())
	        {
	        	System.out.println("is 2-3 tree");
	        }
	        else 
	        { System.out.println("not 2-3 tree");}
	        if(st.isBalanced())
	        {
	        	System.out.println("is balanced");
	        }
	        else 
	        { System.out.println("not balanced");}
	        
	        System.out.println("Test of size() function:" +st.size());
	        
	        System.out.println("Test of get(3) function:"+st.get(3));
	        
	        System.out.println("Test of contains(2) function:");
	        if(st.contains(2))
	        {
	        	System.out.println("contains 2");
	        }
	        else 
	        { System.out.println("not consains 2");}
	        System.out.println("Test of delete(2) function:");
	        st.delete(2);
	        if(st.contains(2))
	        {
	        	System.out.println("after delete(2) still contains 2");
	        }
	        else 
	        { System.out.println("after delete(2) not contains 2");}
	   }
	  public static int[] Shuffle(int []a) {    //shuffle the array 
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
	  public static int[] readTxtFile(String filePath)// read datas from txt files
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
