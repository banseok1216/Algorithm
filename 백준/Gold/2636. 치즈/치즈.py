import heapq
import math
from dataclasses import dataclass
import sys
from heapq import *
from collections import *
from queue import PriorityQueue

input = sys.stdin.readline

if __name__ == '__main__':
    N,M = map(int, input().split(" "))
    board = [list(map(int, input().split(" "))) for _ in range(N)]
    check = [[False for _ in range(M)] for _ in range(N)]

    heap = []
    list1 = [-1,1,0,0]
    list2 = [0,0,-1,1]
    heapq.heappush(heap,(0,0,0))
    time = 0
    ans = 0
    count = 0
    board[0][0] = -1
    while(len(heap) != 0):
        node = heapq.heappop(heap)
        if time != node[0]:
            time = node[0]
            ans = count
            count = 0
        for i in range(4):
            nx = node[1] + list1[i]
            ny = node[2] + list2[i]
            if(nx>=0 and nx<N and ny>=0 and ny<M and board[nx][ny] != -1):
                if(board[nx][ny] == 0):
                    heapq.heappush(heap, (node[0],nx, ny))
                else:
                    count += 1
                    heapq.heappush(heap, (node[0]+1,nx, ny))
                board[nx][ny] = -1
    print(time)
    print(ans)