import sys
from collections import deque

input = sys.stdin.readline

def is_possible(list1, list2):
    que = deque(list2)
    front = True
    while len(que) != len(list1):
        if front:
            if que[-1] == "B":
                front = False
            que.pop()
        else:
            if que[0] == "B":
                front = True
            que.popleft()

    for char in list1:
        if front:
            if char != que.popleft():
                return 0
        else:
            if char != que.pop():
                return 0

    return 1

if __name__ == '__main__':
    list1 = list(input().rstrip())
    list2 = list(input().rstrip())

    print(is_possible(list1, list2))
