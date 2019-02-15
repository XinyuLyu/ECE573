#pragma once
#include<iostream>
#include<vector>
#include<fstream>
using namespace std;
class UF
{
public:
	vector<int>id = {};
	vector<int>sz = {};
	void uf(int N);
	bool connected(int p, int q);
	int find(int p);
	void union_(int p, int q);
	void UF::load(vector<int>&a, vector<int>&b);
};