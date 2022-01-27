# 기하 + 최대공약수

# 구현을 못했습니다.
'''
8,6의 사각형을 예를 들어 기울기는 3/4이다. x값에 1,2,3,4를 대입했을때 격자점 4,3에서 만난다.
그동안 잘린 사각형의 갯수를 세어보면 6개이다.
파이썬에서는 최대 공약수의 개수를 구하는 것을 math 모듈내에 gcd 내장함수를 이용하면 바로 찾을수있다.
'''

def func(w,h):
    a,b = max([w,h]),min([w,h])
    while(True):
        r=a%b
        if r==0:
            return b
        a = b
        b = r

def solution(w,h):
    squares = w*h
    gcd = func(w,h)
    return squares - (w+h-gcd)

