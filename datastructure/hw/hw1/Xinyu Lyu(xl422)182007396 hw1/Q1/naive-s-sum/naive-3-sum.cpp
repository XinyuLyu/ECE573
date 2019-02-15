//Xinyu Lyu 182007396
//Instructions: First you should create a project,to process the program you need to change the file name in the "void load_number(int a[])" function. The test txt file can't be simply add to the resource 
//file folder in the IDE, it MUST be mannually put under the same catalog together with the debug folder in the project workspace.Also you need input the number of integer in your test file. 
//Because when using vector as a container it is too slow to load the data when testing the datafile with 8192 int. So, I use the original array to reduce the run time. 
//And the original array need you to set the size, sorry for inconvenient.
#include<iostream>
#include<time.h>                  //for time recording
#include<windows.h>
#include<fstream>
using namespace std;
int three_sum(int a[], int size);
void load_number(int a[]);
void main()
{
	int size;
	cout << "Input the number of test datas in test file, number=";// For array as container you need to set its size.
	cin >> size;                                                  
	int *a = new int[size]; //allocate a new space for array  
	cout << "Loading...PLease Wait..." << endl;
	load_number(a);                                                  //load the number from the test file into the array
	long startime = GetTickCount();                                  //record the start time for 3-sum
	int result = three_sum(a, size);                                 //three-sum function
	long endtime = GetTickCount();                                   //record the end time for 3-sum
	cout << result << endl;                                          //print the result
	cout<<"Time for 3-sum:"<< endtime - startime<<"ms"<<endl;            //print the run time
	system("pause");
}int three_sum(int a[], int size)                                
{
	int count = 0;
	for (int i = 0; i < size; i++)
		for (int j = i + 1; j <size; j++)
			for (int k = j + 1; k < size; k++)
				if (a[i] + a[j] + a[k] == 0)
					count++;
	return count;
}
void load_number(int a[])                                            //load the number from the test file into the array 
{
	ifstream read;
	read.open("8192int.txt");
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
