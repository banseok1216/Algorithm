import math
from dataclasses import dataclass
import sys

input = sys.stdin.readline
def find(start, cur):
    if(cur != -1 and cur != -2):
        list2[cur] = True
        find(start,a[cur])
    if(cur == -1):
        list2[start] = False
        return
    return

if __name__ == '__main__':
    X = int(input())
    ans = 0
    a = list(map(int,input().split()))
    list2 = [False for i in range(len(a))]
    a[int(input())] = -2
    for i in range(len(a)):
        if list2[i] == False:
            find(i,i)
    for i in range(len(a)):
        if list2[i] == False :
            ans+=1
    print(ans)
