import heapq
import math
from collections import deque
from itertools import combinations, permutations
N = int(input())

board = [list(map(float, input().split(" "))) + [_] for _ in range(N)]
perm = list(combinations(board, 2))
que = []
parent = [i for i in range(N)]
def find(a):
    if parent[a] == a:
        return a
    parent[a] = find(parent[a])
    return parent[a]

def union(a,b):
    a= find(a)
    b= find(b)
    parent[a] = parent[b]

for list1 in perm:
    roadX = abs(list1[0][0]-list1[1][0])
    roadY = abs(list1[0][1] - list1[1][1])
    road = math.sqrt(pow(roadX,2)+pow(roadY,2))
    heapq.heappush(que,(road,list1[0][2],list1[1][2]))
ans = 0
while(len(que) != 0):
    node = heapq.heappop(que)
    if find(node[1]) != find(node[2]):
        union(node[1],node[2])
        ans+= node[0]
print("{:.2f}".format(ans))