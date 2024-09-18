/**
 * @date 2024.09.18
 * @author June Park
 * 골드 4 문제
 * 대각선 : abs(board[depth]-board[i] == depth -i )인지 확인
 */

#include <iostream>
#include <array>

using namespace std;

int N;
int board[15]; // 어차피 queen 은 가로에 못놓이니까..
int answer = 0;
/**
 * 놓여도 되는지 확인
 */
bool valid(int depth)
{
    // 같은 column 에 있는 경우
    for (int i = 0; i < depth; i++)
    {
        if (board[i] == board[depth])
            return false; // 같은 라인
        if (abs(board[depth] - board[i]) == (depth - i))
            return false; // 대각선
    }
    return true;
}

void dfs(int depth)
{
    if (depth == N)
    {
        answer++;
    }
    else
    {
        for (int i = 0; i < N; i++)
        {
            board[depth] = i; // 배치
            if (valid(depth))
                dfs(depth + 1);
        }
    }
}

int main()
{
    cin >> N;
    dfs(0);
    cout << answer;
    return 0;
}
