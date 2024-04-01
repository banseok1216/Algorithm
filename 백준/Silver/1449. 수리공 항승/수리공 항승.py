N, M = map(int,input().split(" "))
lst = list(map(int,input().split(" ")))
lst.sort()
start = -M
answer =0
for i in range(len(lst)):
    if  lst[i]>=start+M:
        start = lst[i] - 0.5
        answer+=1
print(answer)