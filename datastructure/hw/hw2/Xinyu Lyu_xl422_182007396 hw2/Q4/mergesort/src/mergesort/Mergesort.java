package mergesort;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
public class Mergesort {
	private static int count; //record the number of comparisons of merge sort  
	    public static void main(String []args){
	   	 int[] a = readTxtFile("C:\\Users\\admin\\Desktop\\data\\data1.32768");
	   	 int []b=new int[a.length];
	     sort(a,0,a.length-1,b);
	     if(issorted(a)) System.out.println("Numbers for comparisons: "+count+ " mergesortú║" + Arrays.toString(a));
	        else  System.out.println("Not sorted");
	    }
	    private static void sort(int[] arr,int left,int right,int []temp){
	        if(left>=right)return;
	            int mid = (left+right)/2;
	            sort(arr,left,mid,temp);//sort left
	            sort(arr,mid+1,right,temp);//sort right
	            merge(arr,left,mid,right,temp);//merge
	    }
	    private static void merge(int[] arr,int left,int mid,int right,int[] temp){//partly cited from http://blog.csdn.net/yuehailin/article/details/68961304
	        int i = left;
	        int j = mid+1;
	        int t = 0;
	        while (i<=mid && j<=right){//  two sub arrays both have elements
	            if(less(arr[i],arr[j]))temp[t++] = arr[i++]; 
	            else {temp[t++] = arr[j++]; }
	        }
	        while(i<=mid&&j>right) temp[t++] = arr[i++];    //second sub array has no elements
	        while(j<=right&&i>mid)temp[t++] = arr[j++];//first sub array has no elements
	        for(int k=0;k<t;k++)// get the merged the sequence from the temp to the original array
	            arr[left+k] = temp[k];
	    }
	    private static boolean less(int v,int w)
		{   ++count;
			return v<=w;	}
	    public static boolean issorted(int []a)
	 		{
	 			for(int i=1;i<a.length;i++)
	 			{
	 			   if(a[i-1]>a[i]) return false;
	 			}
	 			return true;
	 		}
	    public static int[] readTxtFile(String filePath)//cited from https://hacpai.com/article/1472004508201?m=0
	    {                                                     // read test txt
	        try{
	            File f = new File(filePath);
	            Scanner s = new Scanner(f);

	            int ctr = 0;
	            while(s.hasNextInt())
	            {
	                ctr++;
	                s.nextInt();
	            }
	            int[] arr = new int [ctr];

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
