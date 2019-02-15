#include"quick-find.h"   // cited from the slides in the lecture
 void UF::uf(int N)
{
	for (int i = 0; i < N; i++)
	{
		id.push_back(i);                 //set the element of vector
	}
}
bool UF::connected(int p,int q)           //return if p and q has the same id
{
	return find(p) == find(q);
}
int UF::find(int p)                        // return the id of p
{
	return id[p];
}
void UF::union_(int p, int q)             
{
	int pID = find(p);                     //return the id of p
	int qID = find(q);                       //return the id of q
	if (pID == qID) return;                   
	for (int i = 0; i < id.size(); i++)// traverse the whole array find the element with pid and change them to qid
	{
		if (id[i] == pID) id[i] = qID;
	}
}
void UF::load(vector<int>&a, vector<int>&b)
{
	ifstream read;
	read.open("4096pair.txt");
	int number1, number2;
	if (read.fail())
	{
		cout << "Error when opening txt file" << endl;
	}
	while (read >> number1 >> number2)
	{
		a.push_back(number1);
		b.push_back(number2);
	}
	read.close();
}