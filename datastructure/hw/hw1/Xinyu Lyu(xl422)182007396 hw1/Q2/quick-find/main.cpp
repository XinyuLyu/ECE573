//Xinyu Lyu 182007396
//Instructions: For this program, first you need to create a project and add "quick-find.h" to head file folder,"quick-find.cpp","main.cpp" these two files into the resource folder 
//in VS 2015 IDE, to change the file name in the member funnction "void UF::load(vector<int>&a, vector<int>&b)" in the "quick-find.cpp", 
// The test txt file can't be simply add to the resource file folder in the IDE, it MUST be mannually put under the same catalog together with the debug folder
//in the project workspace. 
#include<iostream>
#include<vector>
#include<fstream>
#include"quick-find.h"
#include<time.h>
#include<windows.h>
#define N 8192
using namespace std;
int main()
{
	clock_t startime;                 
	clock_t endtime;
	vector<int>a;
	vector<int>b;
	UF uf;                                        //create new object 
	uf.uf(N);                                      //set the size(N) for id[] N is constant 8192 
	uf.load(a,b);                                //load the pair into vector a and vector b
	startime = clock();                         //obtain and record the start time
	for(int i=0;i<a.size();i++)
	{
		if (uf.connected(a[i], b[i]))continue;    //if connected next loop
		uf.union_(a[i],b[i]);                      //union the unconnected pair
		cout << a[i] << " " << b[i] << endl;        
	}
    endtime = clock();                           //obtain and record the end time
	cout << "Time for 3-sum:" << endtime - startime << "ms" << endl;
	system("pause");
	return 0;
}

