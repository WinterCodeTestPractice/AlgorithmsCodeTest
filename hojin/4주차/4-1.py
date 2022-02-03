# 기본적인 다익스트라 알고리즘 문제
# 다익스트라를 만족시키고 그 안에 조건만 만족시키면 된다.
import heapq

def dijkstra(dis , adj):
    heap = []
    heapq.heappush(heap,[0,1])

    while heap:
        cost , node = heapq.heappop(heap)
        for c , n in adj[node]:
            if cost + c < dis[n]:
                dis[n] = cost + c
                heapq.heappush(heap , [cost + c , n])


def solution(N, road, K):
    INF = float('inf')
    dis = [INF] * (N+1)
    dis[1] = 0
    adj = [[] for _ in range(N+1)]
    for r in road:
        adj[r[0]].append([r[2],r[1]])
        adj[r[1]].append([r[2],r[0]])
    dijkstra(dis,adj)

    return print(len([x for x in dis if x <= K]))

solution(5,[[1,2,1],[2,3,3],[5,2,2],[1,4,2],[5,3,1],[5,4,2]],3)