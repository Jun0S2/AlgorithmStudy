https://school.programmers.co.kr/learn/courses/30/lessons/12926?language=python3
def solution(s, n):
    answer = ''
    print(ord('Z')) # 122 z Z 90 A 65 a  97
    for x in s:
        if x == ' ' :
            answer += (x)
        else:
            index = ord(x) + n
            if x.islower():
                if index > ord('z'):
                    index -= 26
            else :
                if index > ord('Z'):  

                    index -= 26
            answer+=chr(index)

    return answer 