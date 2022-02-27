#include <string>
#include <vector>
#include <iostream>

using namespace std;

int N;

string toBinary(int n){
    string ans = "";
    while(n>=1)
    {
        ans += to_string(n%2);
        n/=2;
    }
    //뒤집어야함
    string rev = "";
    int addZeros = N - ans.size();
    for(int i = 0 ; i<addZeros; i++) rev+="0";
    
    for(int i = ans.size() ; i>=0;i--)
    {
        rev += ans[i];
    }
    return rev;
}
//그냥 단순한 or 연산이 아닐까..?
vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    N = n;
    vector<string> answer;
    
    for(int i = 0 ; i< n ;i++)
        //decimal 로 주어짐...
    {
        string map1 = toBinary(arr1[i]);
        string map2 = toBinary(arr2[i]);
        //cout<<map1<<"와 "<<map2<<endl;
        
        string line = "";
        for(int j = 1 ; j<= n ; j++)
        {
            if(map1.at(j)-'0'==1||map2.at(j)-'0'==1)line+="#";
            else line+=" ";
        }
       // cout<<line<<endl;
        answer.push_back(line);
    }
    return answer;
}