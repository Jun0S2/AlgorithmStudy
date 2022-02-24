#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(string s) {
    int answer = 0;
    vector<string> itos = {"zero","one","two", "three", "four", "five", "six", "seven", "eight", "nine"};
    vector<int> stoi;
    
    //cout<<s.size();
    //cout<<s.at(2); 오 이게 charat임
    for(int i = 0 ; i<s.size() ; i++)
    {
        if(s.at(i)-'0'>=0 && s.at(i)-'0'<=9) stoi.push_back(s.at(i)-'0');//숫자인 경우
        else//숫자가 아닌경우
        {    
            for(int j = 0 ; j <= 9 ; j++) //itos배열
            {
                if(s.at(i)!=itos[j].at(0)) continue;
                else
                {
                    if(s.at(i+1)==itos[j].at(1))//발견
                    {
                        stoi.push_back(j);
                        i += itos[j].size()-1;//새 pointer
                        break;
                    }
                    else continue;//같은 애가 아님 (ex : three, two)
                }
            }
        }
    }
    
    //stoi 배열 원소 털기
    int digit = 1;
    for(int i = stoi.size() -1 ; i>=0 ;i --)
    {
        answer += (digit * stoi[i]);
        digit *=10;
    }
    return answer;
}