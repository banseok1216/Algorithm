import heapq

N, M = map(int,input().split(" "))
check ={}
que = []
heapq.heapify(que)
for i in range(N):
    s = input()
    if len(s)>= M:
        if s in check:
            check[s] += 1
        else:
            check[s] = 1
for key, value in check.items():
    heapq.heappush(que,(-value,-len(key),key))
while len(que) != 0:
    node = heapq.heappop(que)
    print(node[2])