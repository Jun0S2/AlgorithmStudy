# https://school.programmers.co.kr/learn/courses/30/lessons/12930?language=python3
def solution(s):
    answer = ""
    cnt = 0
    
    for x in s :
        if x == ' ':
            answer += x
            cnt = 0           # 단어 바뀌면 초기화
            continue
        
        if cnt %2 == 0 :
            answer += x.upper()
        else :
            answer += x.lower()
        cnt += 1
    return answer