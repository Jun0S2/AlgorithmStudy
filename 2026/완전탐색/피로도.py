# https://school.programmers.co.kr/learn/courses/30/lessons/87946?language=python3
from itertools import *
# queue append pop(0)
# k : 현재 피로도.dungeons[최소필요피로도, 소모필요도]
def solution(k, dungeons):
    answer = -1
    
    def bfs(k, dungeons):
        # contains index of the dungeon
        visited = [False] * len(dungeons)
        queue = [0] # just start with the first one
        hp = k
        local_max = 0
        
        # visit first place
        idx = 0
        
        while(queue):
            # print("======================")
            idx = queue[-1]
            queue.pop(0)
            # print("current index : ", idx)
            # print("HP Left : ",hp)
            
            # boundary
            if (idx == len(dungeons)):
                # print("reached end")
                break;
                
            # already visited
            if(visited[idx]):
                # print("visited.")
                continue
            
            # has min hp and can visit
            if (hp >= dungeons[idx][0] and hp-dungeons[idx][1]>=0):
                # print("HP Left : ", hp, " min : ", dungeons[idx][0], " req : ",dungeons[idx][1])
                visited[idx] = True
                queue.append(idx+1)
                hp -= dungeons[idx][1]
                local_max += 1
             
        # print("local max?", local_max)
        return local_max
        
    # for combinations of len(dungeons)
    # answer = bfs(k)
    for x in permutations(dungeons, len(dungeons)):
        # answer = max(answer, bfs(k))
        temp = bfs(k, x)
        answer = max(answer, temp)
    return answer