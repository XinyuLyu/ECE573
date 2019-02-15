#pragma once
#pragma once
#include<iostream>
#include<vector>
#include<fstream>
using namespace std;
class UF
{
public:
	vector<int>id = {};//id for each point
	void uf(int N);//set the size of id[] of initialized root
	bool connected(int p, int q); //connect pair p and q
	int find(int p); //return root of p
	void union_(int p, int q); //union p and q
	void load(vector<int>&a, vector<int>&b); //load the test pair into two vector from test file
};