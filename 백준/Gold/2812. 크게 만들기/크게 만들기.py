import sys
from collections import deque
input = sys.stdin.readline
N, K = map(int, input().split())
num = list(map(int, input().rstrip()))

point = 0
stack = deque([])
stack.append(num[0])
for i in range(1,N):
  while point >= 0 and num[i] > stack[point] and K > 0:
    stack.pop()
    K -= 1
    point -= 1
  stack.append(num[i])
  point += 1
  
while K > 0:
  stack.pop()
  K -= 1
for i in stack:
  print(i, end = "")