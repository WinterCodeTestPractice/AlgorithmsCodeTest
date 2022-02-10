# 회전큐 문제 => deque을 이용해서 간단하게 해결 할 수 있다.

from collections import deque

deq = deque()

cnt = 0

# N : 큐의 크기 , M 뽑는 수
N , M = map(int,input().split())

for i in range(1,N+1):
    deq.append(i)

idx = list(map(int,input().split()))

for i in range(len(idx)):
    while 1:
        # 찾으려는 숫자 1과 deq에 첫번째가 같으면 추출하고 삐져나간다.
        if(idx[i] == deq[0]):
            deq.popleft()
            break
        else:
            # rotate를 이용해서 간단하게 좌우를 한칸씩 민다.
            if(deq.index(idx[i]) <= len(deq)//2):
                cnt+=1
                deq.rotate(-1)
            else:
                cnt+=1
                deq.rotate(1)
print(cnt)