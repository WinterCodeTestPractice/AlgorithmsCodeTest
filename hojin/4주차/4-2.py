def solution(arr1, arr2):
    # 빈 리스트로 2차원 배열 채우기
    answer = [[] for _ in range(len(arr1))]

    # len(arr1) => arr1의 행
    for i in range(len(arr1)):
        # len(arr2[0]) => arr2의 첫번째 행의 원소의 갯수
        temp = [0] * len(arr2[0])
        '''
        밑에 계산은 arr1의 1행1열과 arr2의 1행1열 곱하고 arr1의 1행1열과 arr2의 1행2열을 
        그 다음에 arr1의 1행2열과 arr2의 2행1열 곱하고 arr1의 1행2열과 arr2의 2행 2열 
        즉 , 첫번째 열부터 먼저 계산이 완료됨
        '''
        for j in range(len(arr1[0])):
            for k in range(len(arr2[0])):
                temp[k] += arr1[i][j] * arr2[j][k]
        # 배열 통째로 만들어 놓은 2차원 배열에 넣는다!
        answer[i] = temp

    return answer

solution([[1, 4], [3, 2], [4, 1]],	[[3, 3], [3, 3]])