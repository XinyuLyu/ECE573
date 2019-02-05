package quicksort;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.lang.Math;
public class quick {
private static int cut_off=7;// define the cut off to insertion sort
private static int counter=0;  //record the comparisons of quick sort without cut off to insertion sort
private static int counter1=0; //record the comparisons of quick sort with cut off to insertion sort
	    public static void main(String[] args) {
	        int[] a = readTxtFile("C:\\Users\\admin\\Desktop\\data\\data1.32768");
	        Shuffle(a);// shuffle the array
	        System.out.println("after shuffle£º" + Arrays.toString(a)); 
	        int []b=new int [a.length];// a temp array used to temporarily store the stored sub array
	        for(int i=0;i<a.length;i++)
	        {
	        	b[i]=a[i];
	        }
	        quickSort(a, 0, a.length - 1);//quick sort without cut off to insertion sort
	        if(issorted(a)) System.out.println("Numbers for comparisons: "+counter+" "+" quicksort£º" + Arrays.toString(a));//if sorted print
	        else  System.out.println("Not sorted");
	        quickSort2(b, 0, b.length - 1);// quick sort with cut off to insertion sort	   
	        if(issorted(b))System.out.println("Numbers for comparisons: "+ counter1+" quicksort with cut-off "+cut_off+" :"  + Arrays.toString(b));
	        else  System.out.println("Not sorted");
	  }
	    public static void quickSort(int[] arr, int left, int right) {
	    	if(right<=left) return;
		     int i=left,j=right+1;
		     three_median_Pivot(arr,left,right);
		        int v=arr[left];
		    	while(true)
		    	 {
		    	 while(less(arr[++i],v)) if(i==right) break;
		    	 while(less(v,arr[--j])) if(j==left) break;
		    	 if(i>=j) break;
		    	 swap(arr,i,j);
		    	 }
		    	swap(arr,left,j);
		    	quickSort(arr,left,j-1);  //sort left
		    	quickSort(arr,j+1,right);// sort right
		   }
	    public static void quickSort2(int[] arr, int left, int right) {
		     if(right<=left+cut_off) {insertionsort(arr,left,right);return;}
		     int j=partition(arr,left,right);// part the array
		    	quickSort2(arr,left,j-1);//sort left
		    	quickSort2(arr,j+1,right);// sort right
		   }
	    public static void three_median_Pivot(int[] arr, int left, int right) {// get the pivot as the median among left, mid and right
	        int mid = (left + right) / 2;
	        if (arr[left] > arr[mid]) {
	            swap(arr, left, mid);
	        }
	        if (arr[left] > arr[right]) {
	            swap(arr, left, right);
	        }
	        if (arr[right] < arr[mid]) {
	            swap(arr, right, mid);
	        }// aim: left < mid < right
	        swap(arr,mid,left);// exchange mid and left, so we can get a[left] as the three-median-pivot
	    }
	    private static int partition(int []a,int left,int right)//partly cited from 4th edition of Algorithm 2.5
	    {
	    	  int i=left,j=right+1;
	    	  three_median_Pivot(a,left,right);
		        int v=a[left];
		    	while(true)
		    	 {
		    	 while(less1(a[++i],v)) if(i==right) break;
		    	 while(less1(v,a[--j])) if(j==left) break;
		    	 if(i>=j) break;
		    	 swap(a,i,j);
		    	 }
		    	swap(a,left,j);
		    	return j;
	    }
	    private static void swap(int[] arr, int a, int b) {
	        int temp = arr[a];
	        arr[a] = arr[b];
	        arr[b] = temp;
	    }
		private static boolean less(int v,int w)//compare and record the compare times of quick sort
		{   ++counter;
			return v<w;	}
		private static boolean less1(int v,int w)////compare and record the compare times of quick sort with cut off 
		{   ++counter1;
			return v<w;	}
	    public static int[] Shuffle(int []a) {    //shuffle the array cited from http://blog.csdn.net/mnmlist/article/details/51378132
	        int ranIndex=0;  
	        Random random = new Random();    
	        for (int i = 0; i <a.length; i++) {  
	            ranIndex = random.nextInt(a.length);  
	            swap(a, ranIndex, i);  
	        }  
	        return a;  
	    }   
	    public static boolean issorted(int []a)// tell if the array is sorted
		{
			for(int i=1;i<a.length;i++)
			{
			   if(a[i-1]>a[i]) return false;
			}
			return true;
		}
	    public static int[] readTxtFile(String filePath)// cited from https://hacpai.com/article/1472004508201?m=0
	    {                                               // read txt files from the test txt
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
	    public static void insertionsort (int [] a,int left,int right)// partly cited from 4th edition of Algorithm 2.1.3
	    {
	    		int N=right-left+1;
	    		for(int i=left+1;i<right+1;i++)
	    		{
	    			for(int j=i;j>left&&(less1(a[j],a[j-1]));j--)
	    			swap(a,j,j-1);	
	    		}
	    }
	} 

