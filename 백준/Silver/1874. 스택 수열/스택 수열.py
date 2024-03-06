# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.

import sys
from collections import deque

input = sys.stdin.readline
mod = 1000000000

# Press the green button in the gutter to run the script.
if __name__ == '__main__':
    dq = deque()
    N = int(input())
    list1 = [int(input()) for i in range(N)]
    list2 = []
    check = 0
    for i in range(1,N+1):
        dq.append(i)
        list2.append("+")
        while len(dq) != 0 and list1[check] <= dq[-1]:
            dq.pop()
            check+=1
            list2.append("-")
    if(check == N):
        for _ in range(len(list2)):
            print(list2[_])
    else :
        print("NO")
