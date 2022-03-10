#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;


vector<bool>visited(9,false);
vector<int>height(9,0);

void combi(int targetSum, int cnt, int start, int sum){
    if(cnt == 2)
    {
        if(targetSum == sum)
        {
            for(int i = 0 ; i< 9 ; i++)
            {
                if(visited[i])continue;
                else cout<<height[i]<<endl;
            }
            exit(0);
        }
        return;
    }
    for(int i = start ;i<9 ; i++)
    {
        if(visited[i])continue;
        visited[i] = true;
        sum += height[i];
        combi(targetSum, cnt+1 , i+1, sum);
        visited[i] = false;
        sum -= height[i];
        
    }
}
int main(){
    int sum = 0;//아홉난쟁이 키의 합
    for(int i = 0; i<9 ; i ++) 
    {
        cin>>height[i];
        sum+=height[i]; 
    }
    //cout<<"==================="<<endl;
    sort(height.begin(),height.end());//일단 정렬
    int targetSum = sum - 100;//두 난쟁이의 합이 targetSum 이면 정답
    combi(targetSum,0,0,0);//start, depth,sum
}