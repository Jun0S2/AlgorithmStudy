def solution(citations):
    N = len(citations)
    citations.sort(reverse=True)
    
    answer = 0
    for h in range(1, N + 1):  # h는 1부터 N까지
        cnt = 0
        for x in citations:
            if x >= h:
                cnt += 1
        
        if cnt >= h:  # 조건
            answer = h
    
    return answer