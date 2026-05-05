# https://school.programmers.co.kr/learn/courses/30/lessons/12941?language=python3
def calculate(mina, minb):
    val = 0
    for x in range(len(mina)):
        val += mina[x] * minb[x]
    return val

def solution(A,B):
    answer = 0
    # 어째튼 이렇게 하려면 A 는 최소로 sort, B는 최대로 sort.
    # 또는 A는 최대, B는 최소로 sort
    # 그 두 값 비교해서 작은 값 리턴
    
    minA = sorted(A)
    maxA = sorted(A, reverse = True)
    minB = sorted(B)
    maxB = sorted(B, reverse = True)

    caseA = calculate(minA, maxB)
    caseB = calculate(maxA, minB)
    return min(caseA,caseB)