/**
 * 이진트리
 * https://www.acmicpc.net/problem/20364
 * 이진트리
 * 부모 : current/2
 * 자식 : 2* current or 2*current+1
 */

#include <iostream>
#include <vector>
using namespace std;

// 오리가 원하는 땅을 가질 수 있는지 없다면 처음 마주치는 땅은?
int Q;                 // 오리수
int N;                 // 땅의 수
vector<bool> occupied; // 땅이 점유되었는지

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> N >> Q;
    occupied.resize(N + 1, false);

    for (int i = 1; i <= Q; i++)
    {
        int wanted = 0;
        // i 번째 오리가 원하는 땅번호
        cin >> wanted;

        int conflict = 0; // 처음 마주치는 점유된 땅번호 (없으면 0)
        int current = wanted;

        while (current > 0)
        {
            if (occupied[current]) // 이미 가는길에 오리가 살고있으면
            {
                conflict = current;
            }
            // 이진트리에서 부모 노드로 이동
            // 왼쪽 자식 노드는 2K, 오른쪽은 2K +1
            // 반대로 K 노드의 부모는 K/2 이다.
            current /= 2; // 부모노드로 이동
        }
        if (conflict == 0) // 경로 상 점유된 땅이 없는 경우
        {
            occupied[wanted] = true;
            cout << 0 << '\n'; // 아무런 문제 없이 ㄷ원하는 땅을 점유
        }
        else
        {
            cout << conflict << '\n'; // 마주친 번호
        }
    }
    return 0;
}