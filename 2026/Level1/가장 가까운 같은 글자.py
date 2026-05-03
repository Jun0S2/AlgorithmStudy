# https://school.programmers.co.kr/learn/courses/30/lessons/142086?language=python3
def distance(idx, str):
    rev_str = str[:idx+1][::-1] # ::-1이 reverse, 0 to index+1
    dist = 0 ;
    find = str[idx]
    for x in range(1, len(rev_str)) :
        dist += 1
        if rev_str[x] == find :
            return dist
    return dist

def solution(s):
    answer = []
    for x in range(len(s)):
        if s[x] in s[:x]:
            print(s[x])
            answer.append(distance(x,s))
        else:
            answer.append(-1)
    return answer