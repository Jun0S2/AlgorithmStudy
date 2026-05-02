def solution(n):
    answer = 0
    n2str = str(n)
    
    for x in n2str :
        answer += int(x)
    return answer