# 정답은 맞았지만 시간초과 문제 !!

import sys

# 입력받은 문자를 리스트에 담는다.
seq = list(sys.stdin.readline().rstrip())
N = int(sys.stdin.readline())

# 커서값을 만들어주고 커서를 따라가면서 index위치를 정해준다. 커서는 index보다 한칸 뒤에 있어야해서 총길이를 받는다.
cursor = len(seq)

def left(cur):
    global cursor
    # 커서값이 0이면 가장 왼쪽이라서 값을 바꾸지 않는다.
    if(cursor == 0):
        return cursor
    elif ( cursor < 0 ):
        cursor = 0
    # 가장 왼쪽이 아니면 왼쪽으로 한칸 움직인다.
    else:
        cursor -= 1

def right(cur):
    global cursor
    # 커서값이 가장 마지막 인덱스 값이면 그 값 그대로 뽑는다.
    if(cursor == len(seq)):
        return cursor
    elif (cursor > len(seq)):
        cursor = len(cursor)
    else:
        cursor += 1

def delete(cur):
    global cursor
    # cursor가 0이 아니면 한칸뒤로가서 삭제
    if (cursor != 0):
        cursor -= 1
        del seq[cursor]
    else:
        cursor = 0

def add(cur):
    global cursor
    # cursor 자리에 삽입!
    seq.insert(cursor, enter[1])
    cursor += 1

for i in range(N):
    enter = list(sys.stdin.readline().split())
    first_word = enter[0]

    if(first_word == 'P'):
        add(cursor)
    elif(first_word == 'L'):
        left(cursor)
    elif( first_word == 'D' ):
        right(cursor)
    elif( first_word == 'B' ):
        delete(cursor)

print(''.join(seq))

'''
결론 : 시간 초과 문제 
파이썬 자료형별 시간복잡도를 정확하게 알아야 할 것 같음.. 
insert와 del의 구조를 정확하게 파악 후에 문제 다시 풀자!
'''