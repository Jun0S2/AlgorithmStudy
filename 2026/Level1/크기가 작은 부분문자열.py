# https://school.programmers.co.kr/learn/courses/30/lessons/147355
def solution(t, p):
    answer = 0
    k = len(p)

    # Use zip to extract k-length substrings
    substrings = ["".join(t[i:i+k]) for i in range(len(t) - k + 1)]
    
    for x in substrings:
        if (int(x) <= int(p)) :
            answer+=1

    return answer