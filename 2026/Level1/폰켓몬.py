# https://school.programmers.co.kr/learn/courses/30/lessons/1845?language=python3
def solution(nums):
#     nums = [3,1,2,3]
#     고를 수 있는 개수: 2
#     종류: {1,2,3} → 3개
#     결과: min(2, 3) = 2
    return min(len(nums)//2, len(set(nums)))