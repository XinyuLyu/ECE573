//Xinyu Lyu 182007396
//Instructions: First you need to create the project,for this program you need to change the file name in the "void load_number(vector<int>&a);" function, The test txt file can't be simply add to the resource 
//file folder in the IDE, it MUST be mannually put under the same catalog together with the debug folder in the project workspace.
#include<iostream>
#include<time.h>                         //for time recording
#include<windows.h>            
#include<fstream>
#include<vector>
using namespace std;
int three_sum(vector<int>&a);
void load_number(vector<int>&a);
void InsertSort(vector<int>&a);
void main()
{
	clock_t startime;
	clock_t endtime;
	vector<int>a = {};                //vector as container for test data
    cout << "Loading...PLease Wait..." << endl;
	load_number(a);//load the number from the test file into the array
	InsertSort(a);                     //sort
    startime = clock();                 //record the start time for 3-sum
	int result = three_sum(a);           //three-sum function
	endtime = clock();                   //record the end time for 3-sum
	cout << result << endl;                //print the result
	cout << "Time for 3-sum:" << endtime - startime << "ms" << endl;        //print the run time
	system("pause");
}
void load_number(vector<int>&a)
{
	ifstream read;
	read.open("4096int.txt");
	int number;
	if (read.fail())
	{
		cout << "Error when opening txt file" << endl;
	}
	while (read >> number)
	{
		a.push_back(number);
	}
	read.close();
}
void InsertSort(vector<int>&a)
{
	for (int i = 1; i<a.size(); i++)
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
int three_sum(vector<int>&a)           //i traverse the whole array one time, j and k together traverse the array one time until j=k
{                                      //therefore it only contain twice of array traverse
	int count = 0;                      //cited from http://shmilyaw-hotmail-com.iteye.com/blog/2085129
	for (int i = 0; i<a.size(); i++)
	{
		int j = i + 1;
		int k = a.size() - 1;
		while (j<k)                    //the vector is sorted, so when j=k just stop or you will get repeat count
		{
			if (a[j] + a[k] < -a[i])
				j++;
			else if (a[j] + a[k] > -a[i])
				k--;
			else
			{
				count++;
				j++;
				k--;
			}
		}
	}
	return count;
}