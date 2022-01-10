# 정답은 맞았지만 시간초과 문제 !!

import sys

N = int(sys.stdin.readline())
M = int(sys.stdin.readline())

S = sys.stdin.readline()

# 문자열은 IO가 n번 반복하고 I가 붙은 형식
string = 'IO'* N +'I'

result = 0

# 반복문을 통해서 M에서 string 길이를 빼준다.
# S에 첫번째부터 접근해서 string과 같은것을 찾는다.
for i in range( M-len(string) ):
    if S[i] == 'I':
        if S[i:i+len(string)] == string:
            result +=1

print(result)

'''
결론 : 시간 초과 문제 ( 서브태스크 1은 맞았지만 서브태스크 2가 틀렸음 )
구조를 완전 바꿔야하는지..? KMP라는 알고리즘을 사용하는건지..? 잘모르겠음 
'''