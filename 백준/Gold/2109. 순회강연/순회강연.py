import heapq

N = int(input())
que = []
board =[0 for i in range(10001)]
heapq.heapify(que)
for i in range(N):
    P, D = map(int, input().split(" "))
    heapq.heappush(que, (-P,D))
ans = 0
while(len(que) != 0):
    node = heapq.heappop(que)
    idx = node[1]
    while(idx >= 0 and board[idx] != 0):
        idx -= 1
    if idx!=0:
        board[idx] = -node[0]
        ans -=node[0]
print(ans)