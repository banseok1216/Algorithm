import bisect

N = int(input())

nl = list(map(int, input().split(" ")))

M = int(input())

ml = list(map(int, input().split(" ")))

ans = []

nl.sort()
for num in ml:
    ans.append(bisect.bisect_right(nl,num) - bisect.bisect_left(nl,num))
print(' '.join([str(x) for x in ans]))