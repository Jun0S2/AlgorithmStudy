#include <iostream>
#include <string>
#include <map>
#include <vector>

using namespace std;

int main(){
    /* 이 3가지 넣어줬더니 시간초과가 안났다..*/
    ios_base::sync_with_stdio(0);
    cin.tie(0); 
    cout.tie(0);
    
    int N,M;
    cin >>N >>M;
    map<string,int>pokedex;// 이름 도감번호
    vector<string>pokedexNum(N+1,"");//번호순으로 정렬->O(1)용
    string pokemon;
    for(int i = 1 ; i<=N ; i++)
    {
        cin>>pokedexNum[i];
        pokedex.insert(pair<string,int>(pokedexNum[i],i));
    }
    for(int i = 1; i<=M ; i++)
    {
        cin>>pokemon;
        if(isdigit(pokemon[0]))cout<<pokedexNum[stoi(pokemon)]<<"\n";
        else{cout<<pokedex[pokemon]<<"\n"; }

    }
    
 return 0;
    

}