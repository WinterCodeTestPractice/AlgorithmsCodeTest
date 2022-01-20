# 큐를 사용하기 위한 모듈
from collections import deque

M, N, K = map(int, input().split())

# 위 , 아래 , 왼쪽 , 오른쪽
dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

# 0으로 채워진 2차원 배열을 만든다.
graph = [list([0] * N) for _ in range(M)]

# 지정된 영역을 색칠한다.
for _ in range(K):
    x1, y1, x2, y2 = map(int, input().split())
    for i in range(y1, y2):
        for j in range(x1, x2):
            graph[i][j] = -1


resultList = []

# bfs 탐색 방식을 이용해서 해결한다!
for i in range(M):
    for j in range(N):
        if graph[i][j] == 0:
            count = 1
            queue = deque([])
            queue.append([i, j])
            graph[i][j] = count
            while queue:
                y, x = queue.popleft()
                # 상하좌우 방향을 움직여가며 확인한다
                for k in range(4):
                    nY = y + dy[k]
                    nX = x + dx[k]
                    # 지난번 달팽이 배열 문제랑 똑같이 작동 
                    if 0 <= nX < N and 0 <= nY < M and graph[nY][nX] == 0:
                        graph[nY][nX] = 1
                        queue.append([nY, nX])
                        count += 1

            resultList.append(count)

print(len(resultList))
resultList.sort()

for num in resultList:
    print(num,end=" ")