#include <vector>
#include <string>
#include <iostream>
/*@author : June Park
백준1065 실버4 함수
알고리즘 분류 : 함수
 */
using namespace std;

 vector<bool>numbers(1001,false);
 bool check(int number){
    int diff = 0;
    vector<int>digits;//일의자리 십의자리 백의자리
    string itos = to_string(number);
    for(char &c: itos) digits.push_back(c-'0');
    if(digits[1]-digits[0] == digits[2]-digits[1]) return true;
    else return false;
 }

int main(){
    int N ;
   
    for(int i = 1 ; i<= 1000 ; i++)
    {
        if(i<100)numbers[i] = true;//100보다 작으면 무조건 등차수열이지 않나? 하나밖에 없자너..
        else if (check(i)) numbers[i] = true;
    }

    cin>>N;//1000보다 작거나 같은 자연수

    int cnt = 0;

    for(int i = 1 ; i<=N ; i++)
    {
        if(numbers[i])cnt++;
    }

    cout<<cnt;

}