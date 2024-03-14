import heapq
from collections import deque
K = int(input())
list1 = [[] for _ in range(K+1)]
list2 = [0 for K in range(K+1)]
list3 = [0 for K in range(K+1)]
ans = [0 for K in range(K+1)]
que = []
for i in range(1,K+1):
    temp = list(map(int, input().strip().split(" ")))
    list2[i] = temp[0]
    ans[i] = temp[0]
    for j in range(1,len(temp)-1):
        list3[i] += 1
        list1[temp[j]].append(i)
for i in range(1,K+1):
    if list3[i] == 0:
        heapq.heappush(que,(list2[i],i))
while que:
    weight, x = heapq.heappop(que)
    for i in range(len(list1[x])):
        nxt = list1[x][i]
        if list3[nxt] != 0:
            list3[nxt] -= 1
        if list3[nxt] == 0 and ans[nxt] != 0:
            ans[nxt] = weight+list2[nxt]
            heapq.heappush(que,(weight+list2[nxt],nxt))
for i in range(1,len(ans)):
    print(ans[i])

