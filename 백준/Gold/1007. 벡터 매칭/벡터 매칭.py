import sys
import math
from itertools import combinations

sys.setrecursionlimit(10 ** 8)
input = lambda: sys.stdin.readline().rstrip()

T = int(input())
for _ in range(T):
    n = int(input())
    ps = [0 for _ in range(n)]
    xtotal, ytotal = 0, 0
    for i in range(n):
        x, y = map(int, input().split())
        xtotal += x
        ytotal += y
        ps[i] = (x, y)

    min_scala = 1000000
    for c in combinations(range(n), n // 2): # nC(n//2)

        xsum, ysum = 0, 0
        for i in c:
            xsum += ps[i][0] # i번 점의 x값 더해주기 
            ysum += ps[i][1] # i번 점의 y값 더해주기

        xsum -= xtotal - xsum # <- 더하는 집단 - 빼는 집단 == 더하는 집단 - (x총합 - 더하는 집단)
        ysum -= ytotal - ysum

        scala = math.sqrt(xsum ** 2 + ysum ** 2) #벡터 크기
        if min_scala > scala:
            min_scala = scala

    print(min_scala)