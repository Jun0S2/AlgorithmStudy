/**
 * Tree 순회 기본 문제
 * @date 2024.09.22
 * @author June Park
 * https://www.acmicpc.net/problem/1991
 * 실버1
 */
#include <vector>
#include <iostream>
using namespace std;

int N;                             // 트리 노드의 개수
vector<pair<char, char>> tree(26); // 트리의 각 노드 (왼쪽, 오른쪽 자식)

void getInput()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> N;
    for (int i = 0; i < N; i++)
    {
        char root, left, right;
        cin >> root >> left >> right;
        tree[root - 'A'] = {left, right}; // A를 인덱스 0 으로 사용
    }
}

/**
 * 전위 순회
 * 루트 출력 -> 왼쪽 자식 -> 오른쪽 자식
 */
void preOrder(char root)
{
    if (root == '.') // 자식이 없는 경우
        return;

    cout << root;                      // 현재 노드 출력
    preOrder(tree[root - 'A'].first);  // 왼쪽 자식 순회
    preOrder(tree[root - 'A'].second); // 오른쪽 자식 순회
}

/**
 * 중위 순회
 * 왼쪽 자식 -> 루트 -> 오른쪽 자식
 */
void leftOrder(char root)
{
    if (root == '.')
        return;
    leftOrder(tree[root - 'A'].first);
    cout << root;
    leftOrder(tree[root - 'A'].second);
}

/**
 * 후위 순회
 */
void postOrder(char root)
{
    if (root == '.')
        return;
    postOrder(tree[root - 'A'].first);
    postOrder(tree[root - 'A'].second);
    cout << root;
}
int main()
{
    getInput();
    preOrder('A'); // A부터 전위 순회
    cout << "\n";
    leftOrder('A'); // A부터 중위 순회
    cout << "\n";
    postOrder('A'); // A부터 후위 순회
    return 0;
}
