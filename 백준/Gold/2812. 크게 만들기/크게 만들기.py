import sys
from collections import deque
def solution():
    INPUT = sys.stdin.readline
    N, K = map(int, INPUT().split())
    numbers = input().rstrip()
    stack = []

    for number in numbers:
        while stack and stack[-1] < number and K > 0:
            stack.pop()
            K -= 1
        stack.append(number)
    if K > 0:
        return ''.join(stack[:-K])
    else:
        return ''.join(stack)
print(solution())
