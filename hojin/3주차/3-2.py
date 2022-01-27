'''

처음 생각 : 배열을 모두 규칙대로 채우고 행순으로 끊어 slice로 자른다!
=> 입력값이 너무 커서 시간초과 날 확률이 높음

다른 방법으로 접근
=> 배열의 행과 열을 기준으로 가장 큰값 + 1의 값이 각 자리에 채워짐
=> 시간을 줄이기 위해 범위내에서만 작동시킨다.

'''


def solution(n, left, right):
    answer = []
    # 특정 부분만 확인하면 된다. left에서 right까지
    for i in range(left, right + 1):
        # 몫과 나머지를 n으로 나눴을때 최댓값이 곧 답!!
        a = i // n  # 몫
        b = i % n  # 나머지
        result = max(a,b)
        answer.append(result+1)
    print(answer)
    return answer
solution(3,2,5)
