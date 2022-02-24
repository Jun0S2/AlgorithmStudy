#include <string>
#include <vector>

using namespace std;

int solution(string s) {

    string answer = "";
    vector<string> itos = {"zero","one","two", "three", "four", "five", "six", "seven", "eight", "nine"};
   
    for(int i = 0 ; i<s.size() ; i++)
    {
        if(s.at(i)-'0'>=0 && s.at(i)-'0'<=9) answer += s.at(i); 
        else//숫자가 아닌경우
        {    
            for(int j = 0 ; j <= 9 ; j++) //itos배열
            {
                if(s.at(i)!=itos[j].at(0)) continue;
                else
                {
                    if(s.at(i+1)==itos[j].at(1))//발견
                    {
                        answer += to_string(j);
                        i += itos[j].size()-1;//새 pointer
                        break;
                    }
                    else continue;//같은 애가 아님 (ex : three, two)
                }
            }
        }
    }
    return stoi(answer);
}