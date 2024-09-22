/**
 * 이진 검색트리
 * 왼쪽은 오른쪽보다 무조건 가벼움
 * 후위 순회로 출력
 * https://www.acmicpc.net/problem/5639
 *
 * 골드 4
 * dynamic input
 * class Node*
 */

#include <iostream>
using namespace std;
class Node
{
public:
    int value;
    Node *left; // 동적으로 접근해야해서 주소로 바아옴
    Node *right;
    Node(int value) : value(value), left(nullptr), right(nullptr) {}
};

// 이진 검색 트리에 값 삽입
// 이렇게 만들어진 노드는 heap 영역에 저장된다
Node *insert(Node *node, int value)
{
    if (node == nullptr)
        return new Node(value); // 신규 노드 생성

    if (value < node->value)
        node->left = insert(node->left, value);
    else
        node->right = insert(node->right, value);

    return node;
}

void postOrder(Node *node)
{
    if (node == nullptr)
        return;
    postOrder(node->left);       // 왼쪽 서브트리 순회
    postOrder(node->right);      // 오른쪽 서브트리 순회
    cout << node->value << endl; // 현재 노드 출력
}

Node *getInput()
{
    ios::sync_with_stdio(false);
    cout.tie(0);
    cin.tie(0);

    int value;
    Node *root = nullptr;

    while (cin >> value) // value 가 올때까지
    {
        root = insert(root, value);
    }
    return root;
}

int main()
{
    Node *parent = getInput();
    postOrder(parent);
    return 0;
}