# https://school.programmers.co.kr/learn/courses/30/lessons/42748?language=python3
def find_key(arr, loc):
    # print("subarray : ", arr)
    arr.sort()
    # print ("sorted array : ", arr)
    key = 0
    for x in range(len(arr)):
        if x == loc-1 :
            print (arr[x])
            return arr[x]
    return key

def solution(array, commands):
    answer = []
    for x in commands :
        # print(x)
        key = find_key(array[x[0]-1:x[1]], x[2])
        answer.append(key)
        
    return answer