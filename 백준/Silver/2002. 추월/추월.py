import heapq

N = int(input())
t ={}
que = []
for i in range(N):
    t[input()] = i
for i in range(N):
    que.append([i,t[input()]])
que.sort()
find = 100000000
ans =0
for i in range(N-1,-1,-1):
    if que[i][1] <= find:
        find = que[i][1]
    else:
        ans+=1
print(ans)