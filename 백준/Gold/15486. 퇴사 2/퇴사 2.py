# 백준이는 퇴사를 하려고 함  N+1 일째 되는 퇴사를 원함
# 남은 N일 동안 최대한 많은 상담을 하려고 한다.
# 1일에 잡혀 있는 상담 3일 금액 10 5일에 잡혀있는 상담 2일 15
N = int(input())
l = []
for i in range(N):
    a, b = map(int, input().split(" "))
    l.append([a, b])
dp = [0 for _ in range(N+1)]
for i in range(len(l)):
    day, gold = l[i]
    dp[i] = max(dp[i-1],dp[i])
    if i + day > N:
        continue
    else:
        dp[i + day] = max(dp[i] + gold, dp[i + day])
print(max(dp[N-1],dp[N]))
