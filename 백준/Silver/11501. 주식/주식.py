import heapq

C = int(input())
for _ in range(C):
    N = int(input())
    lst = list(map(int,input().split(" ")))
    board = []
    heapq.heapify(board)
    for i in range(len(lst)):
        heapq.heappush(board,(-lst[i],i))
    preIndex = -1
    ans = 0
    while len(board) != 0:
        count, index = heapq.heappop(board)
        if index > preIndex:
            ans += (index - preIndex)*(-count)
            preIndex = index
    for i in range(len(lst)):
        ans-=lst[i]
    print(ans)
