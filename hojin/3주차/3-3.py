'''
반복문을 최대 길이를 기준으로 돌리는 이유를 모르겠어서 꽤나 시간이 걸린 문제

문제 자체는 이분탐색으로 접근하면 쉽게 풀린다.
'''

import sys

K, N = map(int, input().split())
lan = [int(sys.stdin.readline()) for _ in range(K)]
start, end = 1, max(lan)  # 이분탐색 처음과 끝위치

while start <= end:  # 적절한 랜선의 길이를 찾는 알고리즘
    mid = (start + end) // 2  # 중간 위치
    lines = 0  # 랜선 수
    for i in lan:
        lines += i // mid  # 분할 된 랜선 수

    if lines >= N:  # 랜선의 개수가 분기점
        start = mid + 1
    else:
        end = mid - 1
print(end)