#include"WeightQuickUnion.h" //cited from the book named Alogorithms Fourth Edition page145
void UF::uf(int N)
{
	for (int i = 0; i < N; i++)id.push_back(i);//set the element of vector id
	for (int i = 0; i < N; i++)sz.push_back(1);//set the element of vector size
}
bool UF::connected(int p, int q)//return if p and q has the same root
{
	return find(p) == find(q);
}
int UF::find(int p)// return the root of p
{
	while (p != id[p])p = id[p];//if the root of p is not itself, it means p is not the root, so loop to find his father and repeat the compare  
	return p;
}
void UF::union_(int p, int q)
{
	int pRoot = find(p);//return the root of p
	int qRoot = find(q); //return the root of q
	if (pRoot == qRoot) return;
	if (sz[pRoot] < sz[qRoot]) { id[pRoot] = qRoot; sz[qRoot] += pRoot;} // connect the small tree to the big tree
	else { id[qRoot] = pRoot; sz[pRoot] += qRoot; }
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