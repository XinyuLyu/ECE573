package HW3_Q3;
import java.util.Random;
public class main {
	 public static void main(String[] args) {        
	      for(double M=10000.0;M<=1000000.0;M*=10)  //M 10000,100000,1000000
	      {  
	       double per=0.0;// red nodes percentage
	       for(int j=0;j<100;j++)// 100 trials
	       {
	        int N=(int)M;
	        int [] b= new int[N];
	        for (int i = 0; i<N; i++)// innitialize the input array 
	    	{
	    	 b[i]=i;
	        }
	        Shuffle(b);
	        RedBlackBST<Integer, Integer> st = new RedBlackBST<Integer, Integer>(); 
	    	for (int i = 0; i<b.length; i++) 
	    	{
	         st.put(b[i], 1);
	        }
	        per+=st.rednodes(M);
	      }
	        System.out.println("M random insertions:"+M+" red node percentages"+(per)+"%");
	     }
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
}
