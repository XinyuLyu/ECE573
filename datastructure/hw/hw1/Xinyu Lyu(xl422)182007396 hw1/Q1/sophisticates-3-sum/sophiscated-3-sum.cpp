//Xinyu Lyu 182007396
//Instructions: First you should create a project,to process the program you need to change the file name in the "void load_number(int a[])" function. The test txt file can't be simply add to the resource 
//file folder in the IDE, it MUST be mannually put under the same catalog together with the debug folder in the project workspace. Also you need input the number of integer in your test file. 
//Because when using vector as a container it is too slow to load the data when testing the datafile with 8192 int. So, I use the original array to reduce the run time. 
//And the original array need you to set the size, sorry for inconvenient.
#include<iostream>
#include<time.h>            //for time recording
#include<windows.h>         
#include<fstream>
using namespace std;
int three_sum(int a[],int size);
void load_number(int a[]);
void InsertSort(int a[],int size);
int BinarySearch(int a[],int size, int key);
void main()
{
	int size;
	cout << "Input the number of test datas in test file, number=";// For array as container you need to set its size.
	cin >> size;
	int *a = new int[size];                                        //allocate a new space for array 
    cout << "Loading...PLease Wait..." << endl;
	load_number(a);                                                //load the number from the test file into the array
	long startime = GetTickCount();                                //record the start time for 3-sum
	InsertSort(a,size);                                            //insertion sort method
	int result = three_sum(a,size);                                //three-sum function
	long endtime = GetTickCount();                                 //record the end time for 3-sum
	cout << result << endl;                                         //print the result
	cout << "Time for 3-sum:" << endtime - startime << "ms" << endl;         //print the run time
	system("pause");
}
int three_sum(int a[],int size)
{
	int count = 0;
	for (int i = 0; i < size; i++)
		for (int j = i + 1; j < size; j++)
		{
			int k = BinarySearch(a,size, -(a[i] + a[j]));    //binary search search the index of  -(a[i] + a[j])
			if ((k !=-1)&&(i<j<k))
				count++;
		}
	return count;
}
void load_number(int a[])  //load the number from the test file into the array 
{
	ifstream read;
	read.open("8int.txt");
	int number;
	int i = 0;
	if (read.fail())
	{
		cout << "Error when opening txt file" << endl;
	}
	while (read >> number)
	{
		a[i] = number;
		i++;
	}
	read.close();
}
void InsertSort(int a[],int size)
{
	for (int i = 1; i<size; i++)
	{
		int inserter = a[i];
		int index = i - 1;
		while (index >= 0 && inserter < a[index])
		{
			a[index + 1] = a[index];
			index--;
		}
		a[index + 1] = inserter;
	}
}
int BinarySearch(int a[], int size,int key)
{
	int low = 0;
	int high = size - 1;
	int mid = 0;
	while (low <= high)
	{
		mid = (low + high) / 2;

		if (a[mid] < key)
			low = mid + 1;
		else if (a[mid] > key)
			high = mid - 1;
		else
			return mid;
	}
	return -1;
}