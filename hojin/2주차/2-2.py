from collections import deque

# deque 모듈을 사용한다.
deq = deque()
cnt = 0
resultSum = 0


# 올바른 괄호인지 체크하는 함수
def solution(s):
    # 전역변수 cnt , resultSum 선언
    global cnt
    global resultSum
    # deq안에 넣기
    for i in s:
        deq.append(i)
    # deq만큼 빼고 넣고 비교한다 .
    # deq의 길이만큼 횟수를 반복시키고 안쪽 반복문에서는 조건이 맞는지 검사하는 코드
    for k in range(len(deq)):
        stack = []
        cnt = 0
        # 여는 괄호가 들어올때 stack에 넣는다.
        for j in range(len(deq)):
            if(deq[j] == '[' or deq[j] == '(' or deq[j] == '{' ):
                stack.append(deq[j])
                cnt+=1
            else:
                cnt -= 1
                # 만일 cnt가 음수면 처음부터 닫는 괄호가 나왔거나 닫는 괄호가 여는 괄호보다 많다는 뜻이다.
                if (cnt < 0):
                    break
                if (deq[j] == ')' and stack[cnt] == '('):
                    stack.pop()
                elif (deq[j] == ']' and stack[cnt] == '['):
                    stack.pop()
                elif (deq[j] == '}' and stack[cnt] == '{'):
                    stack.pop()
                else:
                    break
        # 스택이 비었거나 cnt값이 0이면 괄호가 모두 삭제된 상태라 올바른 괄호임!
        if(len(stack) == 0 and cnt == 0):
            resultSum+=1
        first = deq.popleft()
        deq.append(first)

    return resultSum


solution("[)(]")