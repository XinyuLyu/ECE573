package HW3_Q4;
import java.io.IOException;
import java.util.Random;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
public class main {
	 public static void main(String[] args) throws IOException {
		  double [][]csv=new double[10000][2] ;
		  File csv1 = new File("Q4_result1.csv");
	      BufferedWriter bw = new BufferedWriter(new FileWriter(csv1, true));
	      for(int N=1;N<=10000;N++)  //N 1-10000
	      {  
	    	double []res=new double[2];//store avg and dev
	    	double []temp=new double[1000];	// store every avg
	    	int [] b= new int[N];
	        	for (int j = 0; j<N; j++) //initialize a sorted array
	        	{
	        		b[j]=j+1;
	        	}
	        	
	        for(int i=0;i<1000;i++)// 100o trials
	    	{
	        	Shuffle(b);// get the random input array
	        	RedBlackBST<Integer, Integer> st = new RedBlackBST<Integer, Integer>();  
	        	for (int k = 0; k<b.length; k++) 
	        	{
	        		st.put(b[k], 1);
	        	}
	            temp[i]=st.getresult();
	    	}  
	        
	         double avg=0.0;
	         for(int m=0;m<temp.length;m++)// get average value
	         {
	        	 avg+=temp[m];
	         }
	         avg/=1000;
	         res[0]=avg;
	         
	         double dev=0.0;//get deviation value
	         for(int n=0;n<temp.length;n++)
	         {
	        	 dev+=Math.pow(avg-temp[n], 2);
	         }
             res[1]=Math.sqrt(dev/1000);

	         csv[N-1][0]=res[0];// write average into txt array
	         csv[N-1][1]=res[1];//write deviation into txt array
	        // fileWriter(csv);// read txt array into txt file
             bw.write(String.valueOf(N) + " , " +String.valueOf(csv[N-1][0]) + " , " + String.valueOf(csv[N-1][1]));
             bw.newLine();
         }
         bw.close();
	      
	         
	   }
	 public static void fileWriter(double[][]a) throws IOException {
		    OutputStream os = new FileOutputStream("E:\\Q4test.txt");
	        PrintWriter pw = new PrintWriter(os);
	        for(int i=0;i<a.length;i++)
	        	{
	        	pw.write("N:"+(i+1));
	            pw.append(" average of internal path length:"+a[i][0]);
	            pw.append(" std deviation of internal path length:"+a[i][1]);
	            pw.println();
	        	}
	        pw.close();
	        os.close(); 
	 }
	 public static int[] Shuffle(int []a) {   
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

