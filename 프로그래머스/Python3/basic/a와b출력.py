# split input
a, b = map(int, input().strip().split(' '))

minVal = -100000
maxVal = 100000

if(a<=maxVal and b<=maxVal and a >= minVal and b >= minVal) :
    print("a =",a, "\nb =",b)
