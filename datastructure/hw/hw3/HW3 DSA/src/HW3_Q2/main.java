package HW3_Q2;
	import java.util.Random;
	public class main {
		  public static void main(String[] args) { 
		    for(int N=64;N<=8192;N*=2)// N=64,128,256...8192
		     {
		    	 double avglength1=0.0;//sorted input avglength
		    	 double avglength2=0.0;//random input avglength
		         for(int j=0;j<5;j++)  //each size run 5 times and get the average length of such 5 times run 
		         {	
		        	 RedBlackBST<Integer, Integer> st1 = new RedBlackBST<Integer, Integer>();
		        	 RedBlackBST<Integer, Integer> st2 = new RedBlackBST<Integer, Integer>();
		        	int [] b= new int [N];
		            for (int i = 0; i<N; i++) 
		        	{
		        	 b[i]=i;
		            }
		        	for (int i = 0; i<b.length; i++) 
		        	{
		             st1.put(b[i], 1);//sorted input
		            }
		        	avglength1= st1.getresult();		    	
		        	Shuffle(b);
		        	for (int i = 0; i<b.length; i++) 
		        	{
		             st2.put(b[i], 1);//random input
		            }
		        	//avglength2= st2.avgTreePaths();
		        	avglength2=st2.getresult();
		        }
		         System.out.println(N+" sorted insertions:"+" average length path:"+avglength1);
		         System.out.println(N+" random insertions:"+" average length path:"+avglength2);
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


