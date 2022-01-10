T = int(input())

for test_case in range(1, T+1):
    N = int(input())
    snail = [[0]*N for i in range(N)]
    x,y,direction = 0,0,0

    # 방향 전환
    # 우 , 하 , 좌 , 상
    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]

    # test_case 1번 , 2번
    print(f'#{test_case}')

    for cnt in range(1,N**2+1):
        # 초기값을 셋팅
        snail[x][y] = cnt

        # 우,하,좌,상 순서로 이동한다.
        x += dx[direction]
        y += dy[direction]

        # 범위 값을 이용해서 범위를 벗어나지 않으면 방향을 바꾸지 않고 값을 증가시킨다.
        if 0 <= x + dx[direction] < N and 0 <= y + dy[direction] < N and not snail[x+dx[direction]][y+dy[direction]]:
            continue
        # 방향을 다돌면 다시 원래대로 돌아온다!
        if direction != 3:
            direction += 1
        else:
            direction = 0
    # snail값을 출력한다.
    for i in snail:
        print(*i,' ')

'''
결론 : 방향전환을 dx,dy배열을 이용해서 전환해준다. 
마지막 반복문을 통한 호출 방법을 잘몰랐음 
'''