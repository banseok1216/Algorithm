import copy
import math
import heapq
import sys

input = sys.stdin.readline

if __name__ == '__main__':
    N, M = map(int, input().split(" "))
    board = [list(map(int, input().split(" "))) for _ in range(N)]
    heap = []
    heapq.heappush(heap, (0, 0, 0))
    list1 = [-1, 1, 0, 0]
    list2 = [0, 0, -1, 1]
    check = [[False for _ in range(M)] for _ in range(N)]
    check2 = [[0 for _ in range(M)] for _ in range(N)]
    check[0][0] = True
    times = 0
    while (heap):
        node = heapq.heappop(heap)
        if node[0] != times:
            times = node[0]
        for i in range(4):
            nx = node[1] + list1[i]
            ny = node[2] + list2[i]
            if (nx >= 0 and nx < N and ny >= 0 and ny < M and not check[nx][ny]):
                if board[nx][ny] == 0:
                    check[nx][ny] = True
                    heapq.heappush(heap, (node[0], nx, ny))
                    continue
                if board[nx][ny] == 1:
                    check2[nx][ny] += 1
                if check2[nx][ny] >= 2:
                    if not check[nx][ny]:
                        check[nx][ny] = True
                        heapq.heappush(heap, (node[0] + 1, nx, ny))
    print(times)