#include <string>
#include <vector>
#include <unordered_map>
#include <set>
#include <sstream>

using namespace std;

vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    vector<int> answer(id_list.size(), 0); //초기화
    //step 1 : index map 생성
    unordered_map<string, int> index_map;
    for(int i = 0 ; i<id_list.size() ; i++) index_map[id_list[i]] = i;//맴버들의 index를 맵에 저장
    
    //step 2 : report map 생성
    unordered_map<string, set<string>> report_map;//신고당한 사람, 신고한 사람 리스트 셋(중복회피)
    stringstream ss;//string tokenizer 같은 애임
    
    //step 3 : report를 돌며 신고 정보 저장
    for(auto r : report) //r은 리포트 안의 string
    {
        ss.str(r);//r을 넣는다
        string first , second ; //띄어쓰기를 기준으로 저장할 변수
        ss >> first >> second;//첫번째, 두번째 변수에 띄어쓰기를 기준으로 split
        
        report_map[second].insert(first);//신고먹은 사람key에 리스트 더함 value = set
        ss.clear();//splitter 초기화
    }
    
    //step 4 : 이메일 전송
    for(auto it : report_map)
    {
        //report_map의 second의 value set의 길이가 k 이상이면 이메일을 전송한다
        if(it.second.size()>=k)//key : iter->first, value : iter->second
        {
            for(auto set_it : it.second) //set을 돌면서 신고자들 추출
            {
                int index = index_map[set_it];//신고자의 index get
                answer[index]++;//이메일 횟수 ++
            }
        }
    }
    
    return answer;
}
