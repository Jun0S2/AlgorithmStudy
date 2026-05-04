# https://school.programmers.co.kr/learn/courses/30/lessons/17681?language=python3
def fill_map(num) :
    row = ''
    for x in str(num):
        if x == "1":
            row += "#"
        elif x == "0":
            row += " "
    return row

def solution(n, arr1, arr2):
    answer = []
    for x in range(len(arr1)) :
        anded = bin(arr1[x] | arr2[x])[2:]   # 0b 제거
        anded = anded.rjust(n, '0')          # 문자열 길이를 n으로 맞추되 왼쪽에 0 추가
        
        answer.append(fill_map(anded))
                      
    return answer