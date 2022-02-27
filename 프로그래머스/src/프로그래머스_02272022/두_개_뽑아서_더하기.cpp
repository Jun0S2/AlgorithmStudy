#include <string>
#include <vector>
#include <queue>
//백트래킹을 사용했더니 시간초과가 났다 ㅠㅠ
using namespace std;

vector<int> solution(vector<int> numbers) {
    priority_queue<int,vector<int>,greater<int>> pq;
    vector<int> answer;
    pq.push(numbers[0]+numbers[1]);//미리 해놓음
    
    for(int i = 0 ; i <numbers.size()-1 ; i++ )
    {
        for(int j = i+1 ; j < numbers.size() ; j++)
        {
            pq.push(numbers[i] + numbers[j]);       
        }
    }
    
    while(!pq.empty()){
        if(answer.empty())answer.emplace_back(pq.top());
        else if(pq.top()!=answer.back())answer.emplace_back(pq.top());
        
        pq.pop();
    }

    return answer;
}

/*void backtracking(int cnt , int start , vector<bool> visited , vector<int>numbers){
    if(cnt == 2)
    {
        //visited를 보고 push
        int sum = 0;
        for(int i = 0 ; i <  visited.size() ; i ++ )  if(visited[i]) sum += numbers[i];
        pq.push(sum);
    }
    for(int i = start ; i < numbers.size() ; i++)
    {
        if(visited[i])continue;
        visited[i] = true;
        backtracking(++cnt , i+1 , visited , numbers);
        cnt--;
        visited[i] = false;
    }
}

*/
