#include <iostream>
#include <vector>

using namespace std;

/**
 * author : June Park
 * 백준 2738번 행렬 더하기
 * 문제 요약 : 행렬 두개가 주어지는데, 이 둘의 합을 출력한다.
 * 풀이 방법 : result 벡터를 0으로 초기화하여, 입력을 받을 때 해당 위치의 element에 더한다.
*/

int N,M;
vector<vector<int>> vec;

void print(){
    for (int i = 0; i < vec.size(); i++) {
        for (int j = 0; j < vec[i].size(); j++)
        {
            cout << vec[i][j] << " ";
        }
        cout<<endl;
    }
}

void addVec(){
    int temp;
    for (int i = 0; i < vec.size(); i++) {
        for (int j = 0; j < vec[i].size(); j++)
        {
            cin >> temp;
            vec[i][j] += temp;
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin>>N>>M; // N * M 사이즈의 벡터 생성
    vec.resize(N, vector <int> (M,0));
    
    addVec();
    addVec();
    print();

    return 0;
}