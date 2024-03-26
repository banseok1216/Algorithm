import bisect

N = int(input())
DATA = [*map(int, input().split())]
dp = [0] * N
l = [-int(2e9)]
MAX = 0

for i, n in enumerate(DATA):
    if l[-1] < n:
        l.append(n)
        dp[i] = len(l) - 1
        MAX = dp[i]
    else:
        dp[i] = bisect.bisect_left(l, n)
        l[dp[i]] = n
print(MAX)
