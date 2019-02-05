package shellsort;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
public class shell {
	public static void main(String []args)
	{	
		 Integer[] a = readTxtFile("C:\\Users\\admin\\Desktop\\data\\data1.1024");
		 Integer[] b = readTxtFile("C:\\Users\\admin\\Desktop\\data\\data1.32768");
		 System.out.println("original array: "+Arrays.toString(a));
		 shellsort(a,7);
		 if(issorted(a))                             // if sorted print the array
		 {System.out.println("shell sort: "+Arrays.toString(a));}
		 else
		 {System.out.println("Not sorted");}
		  insertionsort(b);
		 if(issorted(b))                             // if sorted print the array
		{System.out.println("Insertion sort: "+Arrays.toString(a));}
			 else
			 {System.out.println("Not sorted");}
		 System.out.println("Shell sort phase comparisons: "+counter1);
		 System.out.println("Insertionsort sort phase comparisons: "+counter2);
	}
	private static int counter1=0;   //record the number of comparisons of shell sort phase 
	private static int counter2=0;   //record the number of comparisons of insertion sort phase
	public static void shellsort (Integer[] a, int h)
	{
	    int N=a.length;
	    while(h>=1) 
	    {
		for(int i=h;i<N;i++)
		{
			for(int j=i;j>=h&&less(a[j],a[j-h]);j-=h)
			exchange(a,j,j-h);	
		}
		h=h/2;                                             // h=7...3...1
	    }
	}
	public static void insertionsort (Integer[] a)//recited from 4th edition of Algorithm 2.1.3
	{
	    int N=a.length;
	    int h=1;
		for(int i=h;i<N;i++)
		{
			for(int j=i;j>=h&&less1(a[j],a[j-h]);j-=h)
			exchange(a,j,j-h);	
		}
	}
	private static boolean less(Integer v,Integer w)  //compare and record the compare times of shell sort 
	{   ++counter1;
		return v.compareTo(w)<0;	}
	private static boolean less1(Integer v,Integer w)//compare and record the compare times of insertion sort 
	{   ++counter2;
		return v.compareTo(w)<0;	}
	public static void exchange(Integer []a,int i, int j)// cited from 4th edition of Algorithm 2.1.1
	{Integer t=a[i];a[i]=a[j];a[j]=t;	}
	public static boolean issorted(Integer []a)          // cited from 4th edition of Algorithm 2.1.1
	{
		for(int i=1;i<a.length;i++)
		{
		   if(a[i-1]>a[i]) return false;
		}
		return true;
	}
	 public static Integer[] readTxtFile(String filePath)// cited from https://hacpai.com/article/1472004508201?m=0
	    {                                                 // read test txt
	        try{
	            File f = new File(filePath);
	            Scanner s = new Scanner(f);
	            int ctr = 0;
	            while(s.hasNextInt())
	            {
	                ctr++;
	                s.nextInt();
	            }
	            Integer[] arr = new Integer[ctr];
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
