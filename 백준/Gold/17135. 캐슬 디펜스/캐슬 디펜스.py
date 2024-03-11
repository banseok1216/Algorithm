import copy
import heapq
import sys
from collections import deque
from itertools import combinations

input = sys.stdin.readline
N, M, K = map(int, input().split())
ans = 0
board = [list(map(int,input().split())) for i in range(N)]
com = [i for i in range(M)]
perm = list(combinations(com, 3))
que = []
for shooter in perm:
    copyBoard = copy.deepcopy(board)
    count = 0
    for _ in range(N):
        heapq.heappush(que,(0, shooter[0],N, 1))
        heapq.heappush(que, (0, shooter[1],N,  2))
        heapq.heappush(que, (0, shooter[2],N , 3))
        list1 = set()
        while len(que) != 0:
            node = heapq.heappop(que)
            if node[3] in list1:
                continue
            if node[0] > K:
                continue
            if node[2] != N and copyBoard[node[2]][node[1]] != 0:
                list1.add(node[3])
                copyBoard[node[2]][node[1]] = -1
                continue
            for direct in (0,1), (0,-1), (-1,0):
                nN = direct[0]+node[2]
                nM = direct[1]+node[1]
                if(nN< N and nN >=0 and nM <M and nM >= 0):
                    heapq.heappush(que,(node[0]+1,nM,nN,node[3]))
        for i in range(N):
            for j in range(M):
                if(copyBoard[i][j] == -1):
                    count +=1
                    copyBoard[i][j] = 0
        copyBoard.pop()
        copyBoard.insert(0,[0]*M)
    ans = max(ans,count)
print(ans)




