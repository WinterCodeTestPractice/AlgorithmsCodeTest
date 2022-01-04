C = int(input())

cnt = 0

for i in range(C):
    cnt, avg = 0, 0
    score = list(map(int,input().split()))
    student = len(score)-1
    avg = (sum(score)-score[0])/student
    for j in range(1,student+1):
        if(score[j]>avg):
            cnt+=1
    ratio_student = cnt/student
    print("{:.3f}%".format(ratio_student*100))


