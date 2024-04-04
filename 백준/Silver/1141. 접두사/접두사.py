N = int(input())
lst=[]
for i in range(N):
    lst.append(input())
lst.sort()
answer =0
for i in range(N-1):
    check = True
    for j in range(len(lst[i])):
        if lst[i][j] != lst[i+1][j]:
            check = False
            break
    if check:
        answer +=1
print(N-answer)