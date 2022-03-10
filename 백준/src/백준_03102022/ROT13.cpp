#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main(){
  
    string answer="", str="";
    vector<char>upper={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    vector<char>lower={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

   getline(cin,str);

    for(char &c : str)
    {
        
        if(c-'A'>=0 && c-'A'<=26)
        {
            int index = c -'A';
            answer += upper[(index+13)%26];
        }
        else if (c-'a'>=0  && c-'a'<=26)
        {
            int index = c -'a';
            answer += lower[(index+13)%26];
        }
        else
        {
            answer += c;
        }
    }
    cout<<answer;
}