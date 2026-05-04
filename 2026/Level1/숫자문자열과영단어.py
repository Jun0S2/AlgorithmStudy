# https://school.programmers.co.kr/learn/courses/30/lessons/81301?language=python3
def solution(s):
    english = ["zero", "one", "two", "three", "four", 
               "five", "six", "seven", "eight", "nine"]
    
    for i in range(10):
        s = s.replace(english[i], str(i))  # s를 계속 업데이트
    
    return int(s)