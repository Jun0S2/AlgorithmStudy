# 핵심 아이디어

# 각 작업이 완료되는 날짜를 큐에 넣기
# 맨 앞 작업이 배포되면, 그 뒤에 같이 배포될 수 있는 작업들을 함께 카운트

import math
from collections import deque

def solution(progresses, speeds):
    answer = []
    
    # 1. 각 작업의 완료 날짜를 계산해서 큐에 저장
    queue = deque()
    for i in range(len(progresses)):
        days_needed = math.ceil((100 - progresses[i]) / speeds[i])
        queue.append(days_needed)
    
    # 2. 큐에서 하나씩 꺼내면서 배포 처리
    while queue:
        # 현재 배포할 작업의 완료 날짜
        current_deploy_day = queue.popleft()
        count = 1  # 현재 작업은 무조건 배포
        
        # 뒤에 있는 작업 중 같이 배포 가능한 것들 찾기
        while queue and queue[0] <= current_deploy_day:
            queue.popleft()
            count += 1
        
        answer.append(count)
    
    return answer