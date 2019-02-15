//Xinyu Lyu 182007396
//Instructions: First you need to create the project,for this program you need to in put the number of the test numbers. Then follow the instructions to add the testnumbers one by one
#include<iostream>
#include"math.h"          //abs
using namespace std;
void find_farthest_pair(double a[],int size);
int main()
{   int size;
	cout << "input the number of test data(double), N=" ;
	cin >> size;
	double *a = new double[size];                    //allocate a new space for array  
	for (int i = 0; i < size; i++)
	{
		cout << "Input the value for a[" << i << "]=";//input the test data
		cin >> a[i];
	}
	find_farthest_pair(a,size);                //find the farthest pair and print the largest difference
	system("pause");
	return 0;
}
void find_farthest_pair(double a[],int size)//bubble sort to find the max and min figure in the array
{
	double max = a[0];
	double min = a[0];
	for (int i = 1; i < size; i++)            //f(N)=2N O(N)=N
	{
		if (a[i] > max)  max = a[i]; 
		if (a[i] < min)  min = a[i];
	}
	cout << "The farthest pair is (" << max << "," << min << ")" << " and the largest difference is " <<abs( min - max) << endl;
}