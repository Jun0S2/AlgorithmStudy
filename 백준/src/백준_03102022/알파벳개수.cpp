#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main(){
    string str;
    vector<int>alphabets(26,0);
    cin>>str;
    for(char &c : str) alphabets[c-'a']++;
    for(int i : alphabets) cout<<i <<" ";
}