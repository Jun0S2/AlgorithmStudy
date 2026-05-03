# https://school.programmers.co.kr/learn/courses/30/lessons/12969?language=python3
a, b = map(int, input().strip().split(' '))
# print(a + b)
for x in range(b) :
    line = "*" *a
    print(line)