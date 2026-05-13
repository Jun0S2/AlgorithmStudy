from collections import deque

def solution(n, wires):
    answer = float('inf') # 최대값
    
    def bfs(start, graph):
        visited = [False] * (n+1)
        q = deque([start]) # make a deque with start
        visited[start] = True
        cnt = 1

        while q:
            now = q.popleft()
            for nxt in graph[now]:
                if not visited[nxt]:
                    visited[nxt] = True
                    q.append(nxt)
                    cnt += 1
        return cnt
    
    # 그래프 만들기 :
    for i in range(len(wires)): 
        graph = [[] for _ in range(n+1)]
        for j, (a,b) in enumerate(wires):
            if i == j: # itself
                continue
            graph[a].append(b) # a 노드에 연결
            graph[b].append(a) # b 노드에도 연결
            
        part1 = bfs(1, graph) # bfs로 돌아다니면서 연결된 수 
        part2 = n - part1 # 나머지 부분은 part1을 뺀 만큼
        diff = abs(part1- part2)
        answer = min(answer, diff)

    return answer