# https://school.programmers.co.kr/learn/courses/30/lessons/42862?language=python3
def solution(n, lost, reserve):
    # 1. 여벌 있으면서 도난당한 학생 제거
    available = []
    need = []
    
    for x in reserve:
        if x not in lost:
            available.append(x)
    
    for x in lost:
        if x not in reserve:  # 여벌 없는 학생만
            need.append(x)
    
    # 2. 정렬
    available.sort()
    need.sort()
    
    # 3. 빌려주기
    for x in need[:]:  # 복사본이라고함 [:]
        if (x-1) in available:
            available.remove(x-1)
            need.remove(x)
        elif (x+1) in available:
            available.remove(x+1)  # x+1 제거!
            need.remove(x)
    
    # 4. 답 계산
    return n - len(need)