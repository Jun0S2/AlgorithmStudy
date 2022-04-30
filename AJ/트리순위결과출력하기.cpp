
#include <iostream>
#include <vector>
#include <queue>

using namespace std;

struct Tree{
  int left,right;
};

int N;
vector<Tree>tree;//N개의 트리 백터
/* 전위 순회 */
void sol1(int x )
{
  if(tree[x].left == -1 && tree[x].right == -1)
  {
    cout<<x<<" ";
  }
  else{
    cout<<x<<" ";
    if(tree[x].left != -1)  sol1(tree[x].left);
    if(tree[x].right != -1)  sol1 (tree[x].right);
  }
}
 
/* 중위 순회 */
void sol2 (int x)
{
 if(tree[x].left == -1 && tree[x].right == -1)
 {
    cout<<x<<" ";
  }else
  {
    if(tree[x].left != -1) sol2(tree[x].left);
    cout<<x<<" ";
    if(tree[x].right != -1) sol2(tree[x].right);
  }
}
/* 후위 순회 */
void sol3 (int x)
{
  if(tree[x].left ==-1 && tree[x].right ==-1 )
    {
      cout<<x<<" "; //끝
    }
    else
    {
      if(tree[x].left !=-1) sol3(tree[x].left);
      if(tree[x].right !=-1) sol3(tree[x].right);
      cout << x<<" ";
    
    }
}

int main() {
  cin>>N;
  tree.resize(N);
  int root, l,r;
  
  for(int i = 0 ; i<N ; i++)
  {
    cin>>root>>l>>r;
    tree[root].left = l;
    tree[root].right = r;
  }
  

  sol1(0);
  cout<<endl;
  sol2(0);
  cout<<endl;
  sol3(0);
  cout<<endl;

  return 0;
}
