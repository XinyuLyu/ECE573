package com.company;

// import package
import java.io.*;
import java.util.*;

// class ThreeSum
public class ThreeSum {

    // main function
    public static void main(String[] args)
    {
        long beginTime, endTime;// declare the begin time and the end time of the program
        // read the integers from given file and store into an array
        Integer[] arr = readTxtFile("E:\\Study\\DataStructure\\HW1\\hw1-1\\hw1-1\\8192int.txt");
        System.out.println("There are " + arr.length + " integers in the file");// output the data size of file

        beginTime = System.currentTimeMillis();// obtain the begin time from system and assign to beginTime
        int threeSum = naiveThreeSum(arr);// proceed the program of naive three sum
        endTime=System.currentTimeMillis();// obtain the end time from system and assign to beginTime

        System.out.println("Result of 3-sum is "+ threeSum);// output the result
        System.out.println("Implement naive 3-sum costs "+(endTime - beginTime)+"ms\n");// output the cost of time

        // the same to naive three sum, proceed the program of sophisticated three sum
        beginTime = System.currentTimeMillis();
        threeSum = sophisticatedThreeSum(arr);
        endTime=System.currentTimeMillis();

        System.out.println("Result of 3-sum is "+ threeSum);
        System.out.println("Implement sophisticated 3-sum costs "+(endTime - beginTime)+"ms");

    }

    // function of naive three sum
    public static int naiveThreeSum(Integer[] a)
    {
        int N = a.length;
        int count = 0;

        for(int i = 0; i < N; i++)
            for(int j = i + 1; j < N; j++)
                for(int k = j + 1; k < N; k++)
                    if(a[i] + a[j] + a[k] == 0)
                        count++;
        return count;
    }

    // function of sophisticated three sum
    public static int sophisticatedThreeSum(Integer[] a)
    {
        // sort the array
        int temp;
        int N = a.length, count =0;
        for(int i=1; i < N; i++)
            for(int j = i; j > 0; j--)
                if(a[j-1] > a[j])
                {
                    temp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = temp;
                }
                else
                    break;
        //array is sorted

        // use binarySearch
        for(int i = 0;i < N;i++)
            for(int j = i+1;j < N;j++) {
                if (binarySearch(a, i, j) != -1)
                    count++;
            }
        return 0;
    }

    // function of binary search
    private static int binarySearch(Integer[] a, int i, int j)
    {
        // actually the function is to binary search -(a[i] + a[j])
        int key = -(a[i] + a[j]);
        int low = 0;
        int high = a.length;
        while(low <= high){
            int mid = (low + high)>>>1;// shift operation
            if(a[mid] < key)
                low = mid + 1;
            else if(a[mid] > key)
                high = mid - 1;
            else if(mid > j)
                return mid;
        }
        return -1;
    }

    // function of read text file from users
    public static Integer[] readTxtFile(String filePath)
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

