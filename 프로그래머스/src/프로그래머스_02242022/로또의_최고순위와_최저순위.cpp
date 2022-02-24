#include <string>
#include <vector>

using namespace std;
/*lottos : 낙서된 번호. 
  win_nums : 우승 번호
  알아볼 수 없는 번호  : 0, 번호 6개의 최고순위와 최저순위(순서무관)
  최저 순위 : 둘다 아닐때. 즉, 안지워진 번호가 최저 순위이다
  최고 순위 : 다 맞췄을 때. 즉, 전체 - 틀린개수 
 */
vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    //1등  : 6개 일치, 2등 : 5개 ... 6등 :1개 or 0개
    vector<int> rank = {6,6,5,4,3,2,1}; //rank[맞춘 개수] = 랭크
    int possible = 0;
    int match = 0;
    //step 1 : lottos의 0의 개수 파악 및 맞춘 개수 파악
    for(auto i = 0; i<6 ; i++)
    {
        if(lottos[i]==0) possible++;
        for(int j = 0 ; j<6 ; j++)
        {
            if(win_nums[j]==lottos[i])
            {
                match ++;
                break;
            }
        }
    }

    //step 2: 최저개수 및 최고개수 파악
    vector<int> answer;//최고랭크, 최저랭크
    answer.push_back(rank[match+possible]);
    answer.push_back(rank[match]);

    return answer;
}
